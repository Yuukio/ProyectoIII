package com.elpoeta.menulateralslide.PerfilEquipoTaps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.elpoeta.menulateralslide.R;

public class M_Adaptador_LV extends BaseAdapter {
    // Declare Variables
    Context context;
    String[] nombres;
    int[] imagenes;
    String[] goles;
    LayoutInflater inflater;

    public M_Adaptador_LV(Context context, String[] nombres, int[] imagenes, String[] goles) {
        this.context = context;
        this.nombres = nombres;
        this.imagenes = imagenes;
        this.goles = goles;
    }

    @Override
    public int getCount() {
        return nombres.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Declare Variables
        TextView txtNombre;
        ImageView imgImg;
        TextView txtGoles;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.lv_estilo_miembros, parent, false);

        // Aqui se llama a los items que construyen la lista de miembros
        txtNombre = (TextView) itemView.findViewById(R.id.txt_nombre);
        imgImg = (ImageView) itemView.findViewById(R.id.imagen);
        txtGoles = (TextView) itemView.findViewById(R.id.txt_goles);

        // Muestra los arreglos
        txtNombre.setText(nombres[position]);
        imgImg.setImageResource(imagenes[position]);
        txtGoles.setText(goles[position]);

        return itemView;
    }
}