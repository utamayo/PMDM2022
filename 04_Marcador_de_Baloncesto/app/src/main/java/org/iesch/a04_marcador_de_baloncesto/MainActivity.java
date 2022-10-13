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
    // MVVM 6 - Creamos una variable para poderla utilizar en el MainActivity
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // MVVM 7 - El ViewModel se instancia de una manera diferente a otros objetos.
        // El provider hace cosas internamente. Si giramos el telefono, el provider detectará que ya existe esa clase y no la volverá a crear
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        setupButtons();
    }

    // MVVM 8 - Tomamos localScore y visitorScore del ViewModel
    private void setupButtons() {

        binding.localMinusButton.setOnClickListener(v -> {
                viewModel.decreaseLocal();
                binding.localScoreText.setText(String.valueOf(viewModel.getLocalScore()));
        });

        binding.visitorMinusButton.setOnClickListener(v -> {
                viewModel.decreaseVisitor();
                binding.visitorScoreText.setText(String.valueOf(viewModel.getVisitorScore()));
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
        intent.putExtra("localScore", viewModel.getLocalScore());
        intent.putExtra("visitorScore", viewModel.getVisitorScore());
        startActivity(intent);
    }

    private void addPointsToScore(int points, boolean isLocal) {
        viewModel.addPointsToScore(points, isLocal);
        if ( isLocal) {
            binding.localScoreText.setText(String.valueOf(viewModel.getLocalScore()));
        } else  {
            binding.visitorScoreText.setText(String.valueOf(viewModel.getVisitorScore()));
        }
    }

    private void resetScores() {
        viewModel.resetScores();
        binding.visitorScoreText.setText(String.valueOf(viewModel.getVisitorScore()));
        binding.localScoreText.setText(String.valueOf(viewModel.getLocalScore()));
    }

}
























