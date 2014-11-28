package com.elpoeta.menulateralslide.MenuLateral;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.elpoeta.menulateralslide.AdaptadorListas.Historial_Adaptador_LV;
import com.elpoeta.menulateralslide.R;

/**
 * Created by user on 26/08/2014.
 */
public class Historial extends Fragment {

    Historial_Adaptador_LV adapter;


    String[] ganador = new String[]{
            "VICTORIA",
            "VICTORIA",
            "DERROTA",
            "VICTORIA",
            "VICTORIA",
            "DERROTA",
            "VICTORIA",
            "VICTORIA",
            "DERROTA",
            "VICTORIA",
            "VICTORIA",
            "DERROTA",
            "VICTORIA",
            "VICTORIA",
            "DERROTA"
    };


    /*
    int[] ganador = {
            R.style.Victoria,
            R.style.Victoria,
            R.style.Derrota,
            R.style.Victoria,
            R.style.Victoria,
            R.style.Derrota,
            R.style.Victoria,
            R.style.Victoria,
            R.style.Derrota,
            R.style.Victoria,
            R.style.Victoria,
            R.style.Derrota,
            R.style.Victoria,
            R.style.Victoria,
            R.style.Derrota
    };
    */

    int[] imagenes1 = {
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher
    };

    int[] imagenes2 = {
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher
    };

    String[] listGF = {"5", "3", "1", "5", "3", "1", "5", "3", "1", "5", "3", "1", "5", "3", "1"};

    String[] listGC = {"2", "1", "3", "2", "1", "3", "2", "1", "3", "2", "1", "3", "2", "1", "3"};

    String[] listPts = {"+3", "+3", "-1", "+3", "+3", "-1", "+3", "+3", "-1", "+3", "+3", "-1", "+3", "+3", "-1"};



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fm_ml_historial, container, false);

        final ListView lista = (ListView) rootView.findViewById(R.id.lista_historial);
        adapter = new Historial_Adaptador_LV(rootView.getContext(), ganador, imagenes1, imagenes2, listGF, listGC, listPts);
        lista.setAdapter(adapter);

        /*
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        /**INDICAR TITULO Y SUBTITULO**
        actionBar.setTitle("Historial");
        */
        return rootView;
    }
}