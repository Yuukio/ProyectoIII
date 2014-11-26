package com.elpoeta.menulateralslide.AdaptadorListas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.elpoeta.menulateralslide.R;

/**
 * Created by Luis on 04/11/14.
 */
public class Equipos_Adaptador_LV extends BaseAdapter {
    // Declare Variables
    Context context;
    int[] imagenes_equipos;
    String[] nombre_quipos;
    String[] lider_equipos;
    LayoutInflater inflater;

    public Equipos_Adaptador_LV(Context context, int[] imagenes_equipos, String[] nombre_quipos, String[] lider_equipos) {
        this.context = context;
        this.imagenes_equipos = imagenes_equipos;
        this.nombre_quipos = nombre_quipos;
        this.lider_equipos = lider_equipos;
    }

    @Override
    public int getCount() {
        return nombre_quipos.length;
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
        ImageButton imgEquipo;
        TextView txtNombreEquipo;
        TextView txtLiderEquipo;


        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.lv_estilo_equipos, parent, false);

        // Aqui se llama a los items que construyen la lista de miembros
        imgEquipo = (ImageButton) itemView.findViewById(R.id.ima_equipos);
        txtNombreEquipo = (TextView) itemView.findViewById(R.id.txt_nombre_equipos);
        txtLiderEquipo = (TextView) itemView.findViewById(R.id.txt_lider_equipos);

        // Muestra los arreglos
        imgEquipo.setImageResource(imagenes_equipos[position]);
        txtNombreEquipo.setText(nombre_quipos[position]);
        txtLiderEquipo.setText(lider_equipos[position]);

        return itemView;
    }
}
