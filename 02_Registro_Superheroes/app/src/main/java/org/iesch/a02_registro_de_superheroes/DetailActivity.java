package org.iesch.a02_registro_de_superheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.iesch.a02_registro_de_superheroes.databinding.ActivityMainBinding;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());
    }
}