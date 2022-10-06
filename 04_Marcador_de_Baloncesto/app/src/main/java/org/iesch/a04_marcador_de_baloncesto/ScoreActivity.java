package org.iesch.a04_marcador_de_baloncesto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.iesch.a04_marcador_de_baloncesto.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {

    private ActivityScoreBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1 - Recojo las puntuaciones que vienen del actuvity del marcador
        int localScore = getIntent().getExtras().getInt("localScore");
        int visitorScore = getIntent().getExtras().getInt("visitorScore");
        // 2 - dibujo las puntuaciones obtenidas y escribo el texto
        binding.scoreText.setText(String.valueOf(localScore) + " - " + String.valueOf(visitorScore));

        if (localScore > visitorScore){
            binding.whoWonText.setText(" Ganó el equipo local ");
        } else if (visitorScore > localScore){
            binding.whoWonText.setText(" Ganó el equipo visitante ");
        } else {
            binding.whoWonText.setText(" Ha habido un empate ");
        }

    }
}

















