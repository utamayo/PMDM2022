package org.iesch.a09_pokeapp.fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import org.iesch.a09_pokeapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailFragment extends Fragment {

    // Declaraciones
    private ImageView detailImageView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailFragment newInstance(String param1, String param2) {
        DetailFragment fragment = new DetailFragment();
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


    public void setPokemonImage(String pokemonImageUrl ){
        //detailImageView.setImageDrawable(ContextCompat.getDrawable(getActivity(),pokemonImageId));
        // Llamar a la libreria de Picasso
        Log.i("POKEMON","LA URL del Pokemon es: " + pokemonImageUrl);
        // Mostramos la imagen usando PICASSO
        Picasso.get().load(pokemonImageUrl).into(detailImageView);
        // Glide.with(this).load(pokemonUrl).into(detailImageView);
    }
    public void playPokemonSound( int pokemonSoundId ){
        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),pokemonSoundId);
        mediaPlayer.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creamos el view en elonCreateView
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        detailImageView = view.findViewById(R.id.pokemon_detail_imageView);
        return view;
    }
}