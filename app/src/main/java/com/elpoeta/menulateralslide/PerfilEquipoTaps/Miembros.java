package com.elpoeta.menulateralslide.PerfilEquipoTaps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.elpoeta.menulateralslide.AdaptadorListas.Miembros_Adaptador_LV;
import com.elpoeta.menulateralslide.R;

public class Miembros extends Fragment {
    View rootView;

    Miembros_Adaptador_LV adapter;

    String[] nombres = new String[]{
            "Hola Mundo",
            "Luis Solano",
            "Ermis Luna",
            "Kenneth Aguilar",
            "Sebastian Rey",
            "Esteban Sanabria",
            "Abel Pacheco",
            "Keylor Navas",
            "Son Goku",
            "Light Yagami",
            "Tokuchi Toua",
            "El Porcionzon",
            "German Garmendia",
            "Patrick Jane",
            "Lie Man"
    };

    int[] imagenes = {
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

    String[] goles = {"12 goles", "19 goles", "14 goles", "7 goles", "12 goles", "19 goles", "14 goles",
            "7 goles", "12 goles", "19 goles", "14 goles", "7 goles", "12 goles", "19 goles", "14 goles"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fm_pe_miembros, container, false);

        final ListView lista = (ListView) rootView.findViewById(R.id.lista_miembros);
        adapter = new Miembros_Adaptador_LV(getActivity(), nombres, imagenes, goles);
        lista.setAdapter(adapter);

        return rootView;
    }
}