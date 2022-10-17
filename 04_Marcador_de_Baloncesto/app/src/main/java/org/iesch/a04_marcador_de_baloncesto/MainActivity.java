package org.iesch.a04_marcador_de_baloncesto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.iesch.a04_marcador_de_baloncesto.databinding.ActivityMainBinding;
import org.iesch.a04_marcador_de_baloncesto.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // LIVEDATA 5 - Aqui es donde entran en juego los observers
        viewModel.getLocalScore().observe(this,localScoreInteger -> {
            // Este entero es el valor del MutableLiveData que estamos observando
            binding.localScoreText.setText(String.valueOf(localScoreInteger));
        });
        viewModel.getVisitorScore().observe(this,visitorScoreInteger -> {
            // Este entero es el valor del MutableLiveData que estamos observando
            binding.visitorScoreText.setText(String.valueOf(visitorScoreInteger));
        });


        setupButtons();
    }

    // LIVEDATA 6 - Como cuando cambien los valores ya se actualizan los Textview, no necesitamos hacerlo aquí
    private void setupButtons() {
        // Siempre que ocurra un cambio a estos valores, se va a activar su observer y entonces cambiará de valor
        binding.localMinusButton.setOnClickListener(v -> {
                viewModel.decreaseLocal();
                //binding.localScoreText.setText(String.valueOf(viewModel.getLocalScore()));
        });

        binding.visitorMinusButton.setOnClickListener(v -> {
                viewModel.decreaseVisitor();
                //binding.visitorScoreText.setText(String.valueOf(viewModel.getVisitorScore()));
        });

        binding.localSumarButton.setOnClickListener(v -> {
            addPointsToScore(1 , true);
        });
        binding.localSumarDosButton.setOnClickListener(v -> {
            addPointsToScore(2 , true);
        });
        binding.visitorSumarButton.setOnClickListener(v -> {
            addPointsToScore(1 , false);
        });
        binding.visitorSumarDosButton.setOnClickListener(v -> {
            addPointsToScore(2 , false);
        });
        binding.restartButton.setOnClickListener(v -> {
            resetScores();
        });
        binding.resultButton.setOnClickListener(v -> {
            endMatch();
        });

    }

    private void endMatch() {
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("localScore", viewModel.getLocalScore().getValue());
        intent.putExtra("visitorScore", viewModel.getVisitorScore().getValue());
        startActivity(intent);
    }

    private void addPointsToScore(int points, boolean isLocal) {
        viewModel.addPointsToScore(points, isLocal);
        /*
        if ( isLocal) {
            binding.localScoreText.setText(String.valueOf(viewModel.getLocalScore()));
        } else  {
            binding.visitorScoreText.setText(String.valueOf(viewModel.getVisitorScore()));
        }
         */
    }

    private void resetScores() {
        viewModel.resetScores();
        //binding.visitorScoreText.setText(String.valueOf(viewModel.getVisitorScore()));
        //binding.localScoreText.setText(String.valueOf(viewModel.getLocalScore()));
    }

}
























