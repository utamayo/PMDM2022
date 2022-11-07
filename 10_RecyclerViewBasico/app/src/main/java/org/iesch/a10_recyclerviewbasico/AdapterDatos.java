package org.iesch.a10_recyclerviewbasico;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

// 1 - El adaptador debe de extender de RecyclerView.Adapter y generar lo que me pide
public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> {

    // 2a Voy a recibir una lista que voy  a tener que mostrar en el Recycler
    ArrayList<String> listDatos;
    //2b Debo generar un constructor explicito a la lista de datos y la asignacion correspondiente
    public AdapterDatos(ArrayList<String> listDatos) {
        this.listDatos = listDatos;
    }

    @NonNull
    @Override
    public AdapterDatos.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 4 - Este metodo enlazará este adaptador con el list_item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        return new ViewHolderDatos(view);
    }

    // 6 - Este metodo establecerá la comunicacion entre el adaptador y la clase ViewHolderDatos
    @Override
    public void onBindViewHolder(@NonNull AdapterDatos.ViewHolderDatos holder, int position) {
        // 7 Llamamos al metodo de asignar datos y le enviamos la informacion que queremos mostrar
        holder.asignarDatos(listDatos.get(position));
    }

    // 5 - Este metodo devolverá el tamaño de la lista
    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        // 3 - Le doy la referencia al xml de item_list
        TextView dato;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            dato = itemView.findViewById(R.id.idDato);
        }
        // 8 Asignamos el dato al lugar a mostrar
        public void asignarDatos(String s) {
            dato.setText(s);
        }
    }
}
