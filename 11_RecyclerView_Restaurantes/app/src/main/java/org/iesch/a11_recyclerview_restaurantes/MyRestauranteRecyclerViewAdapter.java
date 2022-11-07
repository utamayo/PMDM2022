package org.iesch.a11_recyclerview_restaurantes;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.iesch.a11_recyclerview_restaurantes.model.Restaurante;
import org.iesch.a11_recyclerview_restaurantes.placeholder.PlaceholderContent.PlaceholderItem;
import org.iesch.a11_recyclerview_restaurantes.databinding.FragmentRestauranteBinding;

import java.util.List;


public class MyRestauranteRecyclerViewAdapter extends RecyclerView.Adapter<MyRestauranteRecyclerViewAdapter.ViewHolder> {

    // Cambiamos de dummy a Restaurante ( en 3 sitios)
    private final List<Restaurante> mValues;

    public MyRestauranteRecyclerViewAdapter(List<Restaurante> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentRestauranteBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    // Esca clase mapea el diseño de los objetos del layout donde definimos un elemento de la lista
    // Coge cada uno d elos elementos de nuestro layout y los asigna a una variable final del tipo que sea
    // Esta clase depende en gran medida del diseño que tengamos, así que vamos al XML
    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public PlaceholderItem mItem;


        public ViewHolder(FragmentRestauranteBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}