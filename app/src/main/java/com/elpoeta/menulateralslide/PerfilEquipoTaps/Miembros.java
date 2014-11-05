package com.elpoeta.menulateralslide.PerfilEquipoTaps;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.elpoeta.menulateralslide.R;

public class Miembros extends Fragment {
    View rootView;

    M_Adaptador_LV adapter;

    String[] nombres = new String[]{
            "Luis Solano",
            "Ermis Luna",
            "Kenneth Aguilar",
            "Sebastian Rey",
    };

    int[] imagenes = {
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher
    };

    String[] goles = {
            "12 goles",
            "19 goles",
            "14 goles",
            "7 goles"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fm_pe_miembros, container, false);

        final ListView lista = (ListView) rootView.findViewById(R.id.lista_miembros);
        adapter = new M_Adaptador_LV(getActivity(), nombres, imagenes, goles);
        lista.setAdapter(adapter);

        return rootView;
    }
}