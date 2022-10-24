package org.iesch.a09_pokeapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.iesch.a09_pokeapp.MainActivity;
import org.iesch.a09_pokeapp.PokemonListAdapter;
import org.iesch.a09_pokeapp.R;
import org.iesch.a09_pokeapp.model.Pokemon;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PokemonListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PokemonListFragment extends Fragment {

    // Declaraciones necesarias
    private ListView lvPokemon;
    private PokemonListAdapter adaptador;
    private ArrayList<Pokemon> pokemonList = new ArrayList<>();
    View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PokemonListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PokemonListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PokemonListFragment newInstance(String param1, String param2) {
        PokemonListFragment fragment = new PokemonListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // 1 - Creamos una lista, que es la que vamos a retornar
        view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);
        // 2 - A partir de esta vista vamos a obtener todos los views del fragmento
        lvPokemon = view.findViewById(R.id.listaPokemon);
        // 3 - Traemos el resto de codigo del MainActivity
        pokemonList.add(new Pokemon("1", "Bulbasaur",Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("2", "Ivysaur",Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("3", "VenuaSaur",Pokemon.Type.PLANT));
        pokemonList.add(new Pokemon("4", "Charmander",Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("5", "Charmeleon",Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("6", "Charizard",Pokemon.Type.FIRE));
        pokemonList.add(new Pokemon("7", "Squirtle",Pokemon.Type.WATER));
        pokemonList.add(new Pokemon("8", "Blastoise",Pokemon.Type.ELECTRIC));
        pokemonList.add(new Pokemon("25", "Pikachu",Pokemon.Type.ELECTRIC));
        pokemonList.add(new Pokemon("26", "Raichu",Pokemon.Type.ELECTRIC));
        // 4 - Cuando nos pida un Context desde un fragmento lo haremos usando getActivity
        adaptador = new PokemonListAdapter(getActivity(), pokemonList, R.id.pokemon_list_fragment);
        lvPokemon.setAdapter(adaptador);

        lvPokemon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pokemon selectedPokemon = (Pokemon) adaptador.getItem(position);
                if (selectedPokemon != null){
                    Toast.makeText(getActivity(), selectedPokemon.getName(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }
}














