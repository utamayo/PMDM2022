package org.iesch.a02_registro_de_superheroes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import org.iesch.a02_registro_de_superheroes.databinding.ActivityMainBinding;
import org.iesch.a02_registro_de_superheroes.model.SuperHero;

public class MainActivity extends AppCompatActivity {

    private Bitmap foto;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());

        // BOTON GUARDAR
        binding.saveButton.setOnClickListener(v -> {
            // 3 b - Captamos la información de las diferentes vistas
            String superHeroName = binding.nombreHeroEdit.getText().toString();
            String alterEgo = binding.alterEgoEdit.getText().toString();
            String bio = binding.bioEdit.getText().toString();
            float rating = binding.powerBar.getRating();

            abrirDetailActivity(superHeroName,alterEgo,bio,rating);

        });

        // 6 . -  asignamos la funcion al pulsar sobre el icono de la foto.
        //Se puede asignar un onClickListener a cualquier View
        binding.heroImage.setOnClickListener(v -> {
            abrirCamara();
        });

    }

    private void abrirCamara() {
        // 7 - Vamos a pedir a Android que mira si hay alguna APP que ejecute esa accion.
        // Estas aplicaciones se ponen en el Manifest de la APP
        Intent camaraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camaraIntent, 1000);
    }

    // 8 - Creo la funcion StartActivityForResult


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 9 - Si hacemos click en el "back" de la camara recibiremos un result_CANCEL, y si hacemos la foto un RESULT_OK
        if ( resultCode == Activity.RESULT_OK && requestCode == 1000 )
        {
            if ( data != null){
                foto = data.getExtras().getParcelable("data");
                // Se lo asignamos a la ImageView que tenemos
                // 10 - Asigno el Bitmap a la foto
                binding.heroImage.setImageBitmap(foto);
            } else {
                Toast.makeText(this, "Error haciendo la foto", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void abrirDetailActivity(String superheroName, String alterEgo, String bio, float rating) {

        // 4 - Nos creamos un objeto de tipo Superheroe
        SuperHero superHero = new SuperHero(superheroName,alterEgo,bio,rating);
        //1 - Nos creamos un objeto de tipo Intent
        Intent irADetalle = new Intent(this,DetailActivity.class);
        // 3b - Añadimos al intent TODA LA INFORMACION que queramos pasar
        //irADetalle.putExtra("superhero_name",superheroName );
        //irADetalle.putExtra("alterEgo",alterEgo );
        //irADetalle.putExtra("bio",bio );
        //irADetalle.putExtra("rating",rating );
        irADetalle.putExtra("superHero", superHero);

        // 2- Llamamos a startActivity para ir a DetailActivity
        startActivity(irADetalle);
    }
}















