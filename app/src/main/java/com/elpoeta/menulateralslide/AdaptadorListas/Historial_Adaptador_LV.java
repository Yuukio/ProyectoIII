package com.elpoeta.menulateralslide.AdaptadorListas;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.elpoeta.menulateralslide.R;

/**
 * Created by Luis on 04/11/14.
 */
public class Historial_Adaptador_LV extends BaseAdapter {
    // Declare Variables
    Context context;
    String[] ganador;
    int[] imagenes1;
    int[] imagenes2;
    String[] listGF;
    String[] listGC;
    String[] listPts;
    LayoutInflater inflater;

    public Historial_Adaptador_LV(Context context, String[] ganador, int[] imagenes1, int[] imagenes2, String[] listGF, String[] listGC, String[] listPts) {
        this.context = context;
        this.ganador = ganador;
        this.imagenes1 = imagenes1;
        this.imagenes2 = imagenes2;
        this.listGF = listGF;
        this.listGC = listGC;
        this.listPts = listPts;
    }

    @Override
    public int getCount() {
        return ganador.length;
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
        TextView txtGanador;
        ImageView imgImg1;
        ImageView imgImg2;
        TextView txtListGF;
        TextView txtListGC;
        TextView txtListPts;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.lv_estilo_historial, parent, false);

        // Aqui se llama a los items que construyen la lista de miembros
        txtGanador = (TextView) itemView.findViewById(R.id.txt_ganador);
        imgImg1 = (ImageView) itemView.findViewById(R.id.ima1);
        imgImg2 = (ImageView) itemView.findViewById(R.id.ima2);
        txtListGF = (TextView) itemView.findViewById(R.id.txt_gf);
        txtListGC = (TextView) itemView.findViewById(R.id.txt_gc);
        txtListPts = (TextView) itemView.findViewById(R.id.txt_pts);

        // Muestra los arreglos
        txtGanador.setText(ganador[position]);
        imgImg1.setImageResource(imagenes1[position]);
        imgImg2.setImageResource(imagenes2[position]);
        txtListGF.setText(listGF[position]);
        txtListGC.setText(listGC[position]);
        txtListPts.setText(listPts[position]);

        /*
        if(position%2 == 0) {
            itemView.setBackgroundColor(Color.argb(255, 227, 227, 227));
        }else{
            itemView.setBackgroundColor(Color.argb(255, 255, 255, 255));
        }
        */

        if(txtGanador.getText() == "VICTORIA"){
            txtGanador.setBackgroundColor(Color.argb(255, 0, 128, 0));
            txtGanador.setTextColor(Color.argb(255, 0, 128, 0));
        }else {
            txtGanador.setBackgroundColor(Color.argb(255, 192, 0, 0));
            txtGanador.setTextColor(Color.argb(255, 192, 0, 0));
        }

        return itemView;
    }
}
