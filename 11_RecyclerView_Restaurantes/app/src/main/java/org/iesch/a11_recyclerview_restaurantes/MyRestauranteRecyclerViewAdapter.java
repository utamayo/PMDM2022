package org.iesch.a11_recyclerview_restaurantes;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.iesch.a11_recyclerview_restaurantes.model.Restaurante;
import org.iesch.a11_recyclerview_restaurantes.databinding.FragmentRestauranteBinding;

import java.util.List;


public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {

    // Cambiamos de dummy a Restaurante ( en 3 sitios)
    private final List<Restaurante> mValues;
    // 12 - Rescatamos el contexto desde el fragment
    private Context ctx;

    public MyRestauranteRecyclerViewAdapter(Context context,List<Restaurante> items) {
        mValues = items;
        ctx=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentRestauranteBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    // METODO IMPORTANTE: Realiza el dibujado de la lista
    // Es lanzado tantas veces como elementos tengamos en la lista
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        // 10 - Rescatamos los datos del elemento que ocupa la posicion position
        holder.textViewNombreRestaurante.setText(mValues.get(position).getNombre());
        holder.textViewDireccionRestaurante.setText(mValues.get(position).getDireccion());
        holder.ratingBarRestaurante.setRating(mValues.get(position).getValoracion());
        // 11 - Implementamos la carga de la imagen usando la librería.... GLIDE
        Glide.with(ctx)
                .load(mValues.get(position).getUrlFoto())
                .into(holder.imageViewFotoRestaurante);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    // Esca clase mapea el diseño de los objetos del layout donde definimos un elemento de la lista
    // Coge cada uno d elos elementos de nuestro layout y los asigna a una variable final del tipo que sea
    // Esta clase depende en gran medida del diseño que tengamos, así que vamos al XML
    public class ViewHolder extends RecyclerView.ViewHolder {
        // 7 - Personalizamos el restaurante conforme al diseño
        public final TextView textViewNombreRestaurante;
        public final TextView textViewDireccionRestaurante;
        public final ImageView imageViewFotoRestaurante;
        public final RatingBar ratingBarRestaurante;
        public Restaurante mItem;

        // Dentro de este metodo constructor recibiremos el parametro del layout completo
        // y apartir de ahi podemos buscar el elemento en cuestion
        public ViewHolder(FragmentRestauranteBinding binding) {
            super(binding.getRoot());
            // 8 - Con cada linea vinculamos cada elemento
            textViewNombreRestaurante = binding.textViewRestaurante;
            textViewDireccionRestaurante = binding.textViewDireccion;
            imageViewFotoRestaurante = binding.imageViewRestaurante;
            ratingBarRestaurante = binding.ratingBarValoracion;
        }

        // 9 Modificamos este metodo para que imprima el nombre del restaurtante
        @Override
        public String toString() {
            return super.toString() + " '" + textViewNombreRestaurante.getText() + "'";
        }
    }
}