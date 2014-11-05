package com.elpoeta.menulateralslide.AdaptadorListas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.elpoeta.menulateralslide.R;

/**
 * Created by Luis on 05/11/14.
 */
public class Ranking_Adaptador_LV extends BaseAdapter {
    // Declare Variables
    Context context;
    String[] equipos_ra;
    int[] imagenes_ra;
    String[] listPts_ra;
    String[] listPJ_ra;
    String[] listGF_ra;
    LayoutInflater inflater;

    public Ranking_Adaptador_LV(Context context, String[] equipos_ra, int[] imagenes_ra, String[] listPts_ra, String[] listPJ_ra, String[] listGF_ra) {
        this.context = context;
        this.equipos_ra = equipos_ra;
        this.imagenes_ra = imagenes_ra;
        this.listPts_ra = listPts_ra;
        this.listPJ_ra = listPJ_ra;
        this.listGF_ra = listGF_ra;
    }

    @Override
    public int getCount() {
        return equipos_ra.length;
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
        TextView txtequipos_ra;
        ImageView imgImg_ra;
        TextView txtListPts_ra;
        TextView txtListPJ_ra;
        TextView txtListGF_ra;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.lv_estilo_ranking, parent, false);

        // Aqui se llama a los items que construyen la lista de miembros
        txtequipos_ra = (TextView) itemView.findViewById(R.id.txt_equipos_r);
        imgImg_ra = (ImageView) itemView.findViewById(R.id.ima_equipo_r);
        txtListPts_ra = (TextView) itemView.findViewById(R.id.txt_pts_r);
        txtListPJ_ra = (TextView) itemView.findViewById(R.id.txt_pj_r);
        txtListGF_ra = (TextView) itemView.findViewById(R.id.txt_gf_r);

        // Muestra los arreglos
        txtequipos_ra.setText(equipos_ra[position]);
        imgImg_ra.setImageResource(imagenes_ra[position]);
        txtListPts_ra.setText(listPts_ra[position]);
        txtListPJ_ra.setText(listPJ_ra[position]);
        txtListGF_ra.setText(listGF_ra[position]);

        return itemView;
    }
}