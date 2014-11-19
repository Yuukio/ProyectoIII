package com.elpoeta.menulateralslide.PaginaPrincipal;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.elpoeta.menulateralslide.AdaptadorListas.Historial_Adaptador_LV;
import com.elpoeta.menulateralslide.AdaptadorListas.Ranking_Adaptador_LV;
import com.elpoeta.menulateralslide.R;


public class Ranking extends ActionBarActivity {


    Ranking_Adaptador_LV adapter;


    String[] listaEquipos = new String[]{
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

    String[] listPts_ranking = {"327", "312", "291", "237", "129", "69", "51", "12"};

    String[] listPuesto_ranking = {"1", "2", "3", "4", "5", "6", "7", "8"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fm_pg_ranking);


        final ListView lista = (ListView) findViewById(R.id.lista_ranking);
        adapter = new Ranking_Adaptador_LV(this, listaEquipos, listaImagenes, listPts_ranking, listPuesto_ranking);
        lista.setAdapter(adapter);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        /**INDICAR TITULO Y SUBTITULO**/
        actionBar.setTitle("Ranking");
    }
}
