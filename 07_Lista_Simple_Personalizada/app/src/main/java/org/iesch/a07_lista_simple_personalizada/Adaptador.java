package org.iesch.a07_lista_simple_personalizada;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

// 1 - He de extender de BaseAdapter
public class Adaptador extends BaseAdapter {
    // 2 - Creamos algunos atributos necesarios para etsa clase
    private ArrayList<Pelicula> listaPeliculas;
    private Context context;

    // 3 - Generamos el constructor
    public Adaptador(ArrayList<Pelicula> listaPeliculas, Context context) {
        this.listaPeliculas = listaPeliculas;
        this.context = context;
    }

    // 4 - Este metodole indica a la ListView cuantos elementos va a tener
    @Override
    public int getCount() {
        return listaPeliculas.size();
    }
    // 5 - Este metodo nos va a devolver la posicion
    @Override
    public Pelicula getItem(int position) {
        return listaPeliculas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // 6 - Aqui se va a crear cada item y se le asignan los valores de cada elemento a cada item
    // Este metodo se va a ejecutar tantas veces como elementos tenga la lista
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 8 Creamos el elemento pelicula
        Pelicula pelicula = getItem(position);

        convertView = LayoutInflater.from(context).inflate(R.layout.item_lista, null);
        // 7 - Vamos a crear cada elemento que va a contener el item
        ImageView imgCartel = convertView.findViewById(R.id.imgCartel);
        TextView tvTitulo = convertView.findViewById(R.id.tvTitulo);
        TextView tvAno = convertView.findViewById(R.id.tvAno);

        // 8 - Vamos a llenar con datos cada elemento
        imgCartel.setImageResource(pelicula.getImgFoto());
        tvTitulo.setText(pelicula.getTitulo());
        tvAno.setText(pelicula.getAno());

        return convertView;
    }
}













