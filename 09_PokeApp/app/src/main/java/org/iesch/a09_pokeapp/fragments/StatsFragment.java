package org.iesch.a09_pokeapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.iesch.a09_pokeapp.R;
import org.iesch.a09_pokeapp.model.Stats;


public class StatsFragment extends Fragment {


    private static final String POKEMON_STATS = "pokemon_stats";

    public StatsFragment() {
        // Required empty public constructor
    }


    public static StatsFragment newInstance(Stats pokemonStats) {
        StatsFragment fragment = new StatsFragment();
        // A este Bundle le vamis a meter los datos de los Stats
        Bundle args = new Bundle();
        args.putParcelable(POKEMON_STATS, pokemonStats);

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stats, container, false);
        // Capturamos los Stats
        TextView hpTextView = view.findViewById(R.id.fragment_stats_hp);
        TextView attackTextView = view.findViewById(R.id.fragment_stats_ataque);
        TextView defenceTextView = view.findViewById(R.id.fragment_stats_defensa);
        TextView speedTextView = view.findViewById(R.id.fragment_stats_velocidad);

        if (getArguments() != null) {
            Stats pokemonStats = getArguments().getParcelable(POKEMON_STATS);
            // ahora llenamos los views conlas stats
            hpTextView.setText(pokemonStats.getHp());
            attackTextView.setText(pokemonStats.getAttack());
            defenceTextView.setText(pokemonStats.getDefence());
            speedTextView.setText(pokemonStats.getSpeed());
        }

        return view;
    }
}















