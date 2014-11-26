package com.elpoeta.menulateralslide.PaginaPrincipal;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.elpoeta.menulateralslide.AdaptadorListas.Equipos_Adaptador_LV;
import com.elpoeta.menulateralslide.R;


public class Equipos extends ActionBarActivity{

    Equipos_Adaptador_LV adapter;


    String[] listaNombreEquipos = new String[]{
            "Los guerreros Z",
            "Los Vengadores",
            "La Vecindad del Chavo",
            "Los Incautos",
            "League of Legends",
            "Somos un Equipo",
            "El toque del Agel",
            "Los mas Malitos"
    };

    int[] listaImagenes = {
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher
    };

    String[] listaNombreLider = new String[]{
                "Hola Mundo",
                "Luis Solano",
                "Ermis Luna",
                "Kenneth Aguilar",
                "Sebastian Rey",
                "Esteban Sanabria",
                "Abel Pacheco",
                "Keylor Navas"
    };

    Spinner listaProvincias;

    String[] listProv = {
            "Alajuela",
            "Cartago",
            "Guanacaste",
            "Heredia",
            "Limón",
            "Puntarenas",
            "San José"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fm_pg_equipos);

        final ListView lista = (ListView) findViewById(R.id.lista_equipos);
        adapter = new Equipos_Adaptador_LV(this, listaImagenes, listaNombreEquipos, listaNombreLider);
        lista.setAdapter(adapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        /**INDICAR TITULO Y SUBTITULO**/
        actionBar.setTitle("Equipos");

        listaProvincias = (Spinner) findViewById(R.id.lista_provincias);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, listProv);
        listaProvincias.setAdapter(adaptador);

        listaProvincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
