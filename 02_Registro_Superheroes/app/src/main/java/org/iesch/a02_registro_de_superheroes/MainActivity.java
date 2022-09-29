package org.iesch.a02_registro_de_superheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.iesch.a02_registro_de_superheroes.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());

        binding.saveButton.setOnClickListener(v -> {
            // 3 b - Captamos la información de las diferentes vistas
            String superHeroName = binding.nombreHeroEdit.getText().toString();
            String alterEgo = binding.alterEgoEdit.getText().toString();
            String bio = binding.bioEdit.getText().toString();
            float rating = binding.powerBar.getRating();

            abrirDetailActivity(superHeroName,alterEgo,bio,rating);

        });
    }

    private void abrirDetailActivity( String superheroName,String alterEgo, String bio, float rating) {

        //1 - Nos creamos un objeto de tipo Intent
        Intent irADetalle = new Intent(this,DetailActivity.class);
        // 3b - Añadimos al intent TODA LA INFORMACION que queramos pasar
        irADetalle.putExtra("superhero_name",superheroName );
        irADetalle.putExtra("alterEgo",alterEgo );
        irADetalle.putExtra("bio",bio );
        irADetalle.putExtra("rating",rating );

        // 2- Llamamos a startActivity para ir a DetailActivity
        startActivity(irADetalle);
    }
}















