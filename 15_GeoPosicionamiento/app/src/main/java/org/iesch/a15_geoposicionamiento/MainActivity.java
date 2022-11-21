package org.iesch.a15_geoposicionamiento;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MainActivity extends AppCompatActivity {

    public static final long DEFAULT_UPDATE_INTERVAL = 5000;
    public static final long FAST_DEFAULT_INTERVAL = 3000;
    public static final int PERMISSION_FINE_LOCATION = 99;
    // 3 - Declaramos los elementos de la UI
    TextView  tv_lat, tv_lon, tv_altitude, tv_accuracy, tv_speed, tv_sensor, tv_updates, tv_address;
    Switch sw_locationUpdates, sw_gps;
    // 5 - Creamos el objeto FusedLocation
    FusedLocationProviderClient fusedLocationProviderClient;
    // 6-  Location Request es un archivo de configuracion del fusedLocationClient
    LocationRequest locationRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 4 - Obtengo las referencias de la UI
        tv_lat = findViewById(R.id.tv_lat);
        tv_lon = findViewById(R.id.tv_lon);
        tv_altitude = findViewById(R.id.tv_altitude);
        tv_accuracy = findViewById(R.id.tv_accuracy);
        tv_speed = findViewById(R.id.tv_speed);
        tv_sensor = findViewById(R.id.tv_sensor);
        tv_updates = findViewById(R.id.tv_updates);
        tv_address = findViewById(R.id.tv_address);
        sw_gps = findViewById(R.id.sw_gps);
        sw_locationUpdates = findViewById(R.id.sw_locationsupdates);

        // 7 - Tengo que preparar el archivo locationRequest
        locationRequest = new LocationRequest();
        locationRequest.setInterval(DEFAULT_UPDATE_INTERVAL);
        locationRequest.setFastestInterval(FAST_DEFAULT_INTERVAL);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        // 8 - Controlamos el cambio en el Switch
        sw_gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sw_gps.isChecked()){
                    // Si está activado, usaréla máxima precisión, GPS
                    locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                    tv_sensor.setText("Usando la máxima precisión. GPS.");
                } else {
                    locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
                    tv_sensor.setText("Usando localización mediante 4G y WIFI.");
                }
            }
        });

        // 9 - Obtenemos/Actualizamos la posicion
        updateGPS();

    }
    // 10 - Me creo el método override para controlar la respuesta a los permisos
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case PERMISSION_FINE_LOCATION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    updateGPS();
                } else {
                    Toast.makeText(this, "Esta app requiere permisos recesarios para trabajar correctamente", Toast.LENGTH_SHORT).show();
                    //finish();
                }
                break;
        }
    }

    private void updateGPS() {
        // Obtener permisos del usuario GPS
        // Obtener la localizacion desde el fusedClient
        // Actualizar la UI
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(MainActivity.this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)  == PackageManager.PERMISSION_GRANTED){
            // Aquí ya entro cuando tenga permisos de Localizacion
            fusedLocationProviderClient.getLastLocation().addOnSuccessListener(MainActivity.this, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location != null){
                        updateUIValues(location);
                    }

                }
            });
        } else {
            // Todavía no tengo los permisos de Localizacion
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_FINE_LOCATION);
            }
        }
    }

    private void updateUIValues(Location location) {
        // 8 - Actualizamos los valores a mostrar en la UI de la nueva location
        tv_lat.setText(String.valueOf(location.getLatitude()) );
        tv_lon.setText(String.valueOf(location.getLongitude()) );
        tv_accuracy.setText(String.valueOf(location.getAccuracy()) );

        if (location.hasAltitude()){
            tv_altitude.setText(String.valueOf(location.getAltitude()) );
        } else{
            tv_altitude.setText("No disponible" );
        }
        if (location.hasSpeed()){
            tv_altitude.setText(String.valueOf(location.getSpeed()) );
        } else{
            tv_altitude.setText("No disponible" );
        }


    }
}
















