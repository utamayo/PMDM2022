package org.iesch.a14_mapas_y_geo;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.iesch.a14_mapas_y_geo.databinding.ActivityMapsBinding;
import org.iesch.a14_mapas_y_geo.model.Restaurante;

import java.util.ArrayList;
import java.util.List;

// Para poder mostrar un mapa necesitamos implementar a esta interfaz
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    // Esto se declara aqui por si el mapa se quiere usar en algun metodo que no sea onMapReady
    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    // 1 - Creamos una lista de Restaurantes
    private List<Restaurante> listaRestaurantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // 3 - Llenamos la lista de restaurantes
        addFakeRestaurantes();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    // 2 - Añadimos un metodo para crear restaurantes aleatorios
    private void addFakeRestaurantes(){
        listaRestaurantes = new ArrayList<>();
        listaRestaurantes.add(new Restaurante("Restaurante Los Amantes", 40.335721,-1.103760));
        listaRestaurantes.add(new Restaurante("Rafi Kebab", 40.34406345043165, -1.1046478921644152));
        listaRestaurantes.add(new Restaurante("Dominos Pizza", 40.3333736830112, -1.0980211565397024));
        listaRestaurantes.add(new Restaurante("Flanagans", 40.34330807743428, -1.1060922136217743));
        listaRestaurantes.add(new Restaurante("Kebab Barbacana", 40.333176774900544, -1.103542361243647));
    }







    // Este método ya trae el mapa y ya podemos trabajar con el
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Creamos un objeto de tipo LatLng
        LatLng teruel = new LatLng(40.34215462530947, -1.1071156044052786);

        BitmapDescriptor taco = BitmapDescriptorFactory.fromResource(R.drawable.ic_taco);
        // 4 - Vamos a crear un marcador para cada restaurante
        for (Restaurante r:listaRestaurantes){
            LatLng posicion = new LatLng(r.getLatitud(),r.getLongitud());
            String nombre = r.getNombre().toString();
            // 5 - Para añadir un icono personalizado a cada marker

            mMap.addMarker(new MarkerOptions()
                    .position(posicion)
                    .icon(bitmapDescriptorFromVector(this, R.drawable.ic_taco))
                    .title(nombre));
        }

        // Para añadir el marcador necesitamos MarkerOptions
        // Le asigna un título, pero podemos asignarle más cosas
        mMap.addMarker(new MarkerOptions().position(teruel).title("TERUEL"));
        // Le dice al mapa que mueva la camara
        // Si queremos que aparaezca mas cerca
        // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(teruel,14.0f));
    }


    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}





