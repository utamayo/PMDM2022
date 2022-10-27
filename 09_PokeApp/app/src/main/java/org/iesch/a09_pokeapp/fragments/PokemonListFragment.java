package org.iesch.a09_pokeapp.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
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
import org.iesch.a09_pokeapp.iComunicaFragments;
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
    public View view;
    // declaro la interfaz que voy a utilizar
    iComunicaFragments interfaz;

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

    // SOLUCIONAMOS EL ERROR DEL CRASHEO //


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        interfaz = (iComunicaFragments) context;
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


        view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);

        lvPokemon = view.findViewById(R.id.listaPokemon);
        // 2 - Cambio los URLs y BORRO los Drawables
        pokemonList.add(new Pokemon("1", "Bulbasaur",Pokemon.Type.PLANT, R.raw.bulbasaur, "https://cdn.alfabetajuega.com/wp-content/uploads/2020/03/bulbasaur-pok%C3%A9mon.png"));
        pokemonList.add(new Pokemon("2", "Ivysaur",Pokemon.Type.PLANT, R.raw.ivysaur, "https://cdn.alfabetajuega.com/wp-content/uploads/2020/03/bulbasaur-pok%C3%A9mon.png"));
        pokemonList.add(new Pokemon("3", "VenuaSaur",Pokemon.Type.PLANT, R.raw.venuasaur, "https://cdn.alfabetajuega.com/wp-content/uploads/2020/03/bulbasaur-pok%C3%A9mon.png"));
        pokemonList.add(new Pokemon("4", "Charmander",Pokemon.Type.FIRE, R.raw.charmander, "https://cdn2.bulbagarden.net/upload/thumb/9/96/Ash_Charmeleon_M20.png/250px-Ash_Charmeleon_M20.png"));
        pokemonList.add(new Pokemon("5", "Charmeleon",Pokemon.Type.WATER, R.raw.charmeleon, "https://cdn2.bulbagarden.net/upload/thumb/9/96/Ash_Charmeleon_M20.png/250px-Ash_Charmeleon_M20.png"));
        pokemonList.add(new Pokemon("6", "Charizard",Pokemon.Type.FIRE, R.raw.charizard, "https://pm1.narvii.com/6210/b5e60c3ebf647e90a773813c09cab8aab6825cbf_hq.jpg"));
        pokemonList.add(new Pokemon("7", "Squirtle",Pokemon.Type.WATER, R.raw.squirtle, "https://pbs.twimg.com/media/EYzE5w0WsAAR69L.jpg"));
        pokemonList.add(new Pokemon("8", "Blastoise",Pokemon.Type.ELECTRIC, R.raw.blastoise, "https://esports.eldesmarque.com/wp-content/uploads/2021/09/Blass.jpg"));
        pokemonList.add(new Pokemon("25", "Pikachu",Pokemon.Type.ELECTRIC, R.raw.pikachu, "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/media/image/2018/08/pikachu_4.jpg"));
        pokemonList.add(new Pokemon("26", "Raichu",Pokemon.Type.ELECTRIC, R.raw.raichu, "https://www.egames.news/__export/1627425509127/sites/debate/img/2021/07/27/copia_de_egames_-_2021-07-27t163726_028.jpg_976912859.jpg"));

        adaptador = new PokemonListAdapter(getActivity(), pokemonList, R.id.pokemon_list_fragment);
        lvPokemon.setAdapter(adaptador);

        lvPokemon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pokemon selectedPokemon = (Pokemon) adaptador.getItem(position);
                if (selectedPokemon != null){

                    interfaz.enviarPokemon(selectedPokemon);
                }
            }
        });

        return view;
    }
}














