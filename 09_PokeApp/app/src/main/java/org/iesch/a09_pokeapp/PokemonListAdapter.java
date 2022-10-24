package org.iesch.a09_pokeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.iesch.a09_pokeapp.model.Pokemon;

import java.util.ArrayList;

// 2 - Creo el PookemonListAdapter, que ha de extender de BaseAdpater
public class PokemonListAdapter extends BaseAdapter {
    // 3 - Atributos necesarios para la clase
    private Context context;
    private ArrayList<Pokemon> pokemonList;
    private int layoutId;
    //4 - Genero el Constructor
    public PokemonListAdapter(Context context, ArrayList<Pokemon> pokemonList, int layoutId) {
        this.context = context;
        this.pokemonList = pokemonList;
        this.layoutId = layoutId;
    }
    // 5 - Modifico los metodos que sean necesarios en mi adaptador
    @Override
    public int getCount() {
        return pokemonList.size();
    }

    @Override
    public Object getItem(int position) {
        return pokemonList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    // 6 - En getView vamos a crear cada item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Pokemon pokemon = (Pokemon) getItem(position);
        // 7
        convertView = LayoutInflater.from(context).inflate(R.layout.pokemon_list_item, null);
        TextView pokemonIdTextView = convertView.findViewById(R.id.pokemon_list_item_id_textView);
        TextView pokemonNameTextView = convertView.findViewById(R.id.pokemon_list_item_name_textView);
        ImageView pokemonTypeImageView = convertView.findViewById(R.id.pokemon_list_item_type_image);
        // 8 - Llenamos la lista de elementos
        pokemonIdTextView.setText(pokemon.getId());
        pokemonNameTextView.setText(pokemon.getName());
        final Pokemon.Type type = pokemon.getType();
        // en vase al superpoder que tenga, le asignamos un icono u otro
        switch (type){
            case FIRE:
                pokemonTypeImageView.setImageResource(R.drawable.fire);
                break;
            case PLANT:
                pokemonTypeImageView.setImageResource(R.drawable.plant);
                break;
            case WATER:
                pokemonTypeImageView.setImageResource(R.drawable.water);
                break;
            case ELECTRIC:
                pokemonTypeImageView.setImageResource(R.drawable.electric);
                break;
        }
        return convertView;
    }
}
























