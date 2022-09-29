package org.iesch.a02_registro_de_superheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.iesch.a02_registro_de_superheroes.databinding.ActivityDetailBinding;
import org.iesch.a02_registro_de_superheroes.databinding.ActivityMainBinding;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());
        // 1 - Obtengo en un objeto Bundle todos los datos traídos de origen
        Bundle extras = getIntent().getExtras();
        // 2 - Creo las variables para obtener los valores del intent desde extras con el valor de la llave
        String heroName = extras.getString("superhero_name");
        String alterEgo = extras.getString("alterEgo");
        String bio = extras.getString("bio");
        float rating = extras.getFloat("rating");
        // 3 - Utilizamos los valores obtenidos
        binding.nombreHeroeText.setText(heroName);
        binding.textView3.setText(alterEgo);
        binding.textView4.setText(bio);
        binding.ratingBar.setRating(rating);


    }
}












