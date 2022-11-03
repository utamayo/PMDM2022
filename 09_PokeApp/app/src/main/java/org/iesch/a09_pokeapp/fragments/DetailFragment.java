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


public class DetailFragment extends Fragment {

    // Declaraciones
    private ImageView detailImageView;
    private static final String POKEMON_IMAGE_URL = "pokemon_image_url";
    private static final String POKEMON_SOUND_ID = "pokemon_sound_id";

    public DetailFragment() {
        // Required empty public constructor
    }

    public static DetailFragment newInstance(String pokemonImageUrl, int pokemonSoundId) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        // Son datos primitivos, no necesitaríamos elParcelable
        args.putString(POKEMON_IMAGE_URL, pokemonImageUrl);
        args.putInt(POKEMON_SOUND_ID, pokemonSoundId);
        fragment.setArguments(args);
        return fragment;
    }


    private void setPokemonImage(String pokemonImageUrl ){
        //detailImageView.setImageDrawable(ContextCompat.getDrawable(getActivity(),pokemonImageId));
        // Llamar a la libreria de Picasso
        Log.i("POKEMON","LA URL del Pokemon es: " + pokemonImageUrl);
        // Mostramos la imagen usando PICASSO
        Picasso.get().load(pokemonImageUrl).into(detailImageView);
        // Glide.with(this).load(pokemonUrl).into(detailImageView);
    }
    private void playPokemonSound( int pokemonSoundId ){
        MediaPlayer mediaPlayer = MediaPlayer.create(getActivity(),pokemonSoundId);
        mediaPlayer.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creamos el view en el onCreateView
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        detailImageView = view.findViewById(R.id.pokemon_detail_imageView);
        if (getArguments() != null){
            String pokemonImageUrl = getArguments().getString(POKEMON_IMAGE_URL);
            int pokemonSoundId = getArguments().getInt(POKEMON_SOUND_ID);
            // Llamamos a los metodos desde el propio fragmento
            setPokemonImage(pokemonImageUrl);
            playPokemonSound(pokemonSoundId);
        }
        return view;
    }
}