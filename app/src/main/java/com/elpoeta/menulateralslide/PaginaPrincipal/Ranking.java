package com.elpoeta.menulateralslide.PaginaPrincipal;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.elpoeta.menulateralslide.AdaptadorListas.Ranking_Adaptador_LV;
import com.elpoeta.menulateralslide.MenuLateral.PaginaPrincipal;
import com.elpoeta.menulateralslide.R;


public class Ranking extends ActionBarActivity {


    Ranking_Adaptador_LV adapter;

    int i;

    public String[] ptsEquipo() {

        String[] listPts_ranking = new String[PaginaPrincipal.puntosEquipo.length];
        for (i=0; i<listPts_ranking.length; i++){
            listPts_ranking[i] = PaginaPrincipal.puntosEquipo[i];
        }
        return listPts_ranking;
    }

    //Aquí lleno la lista con los objetos que recibo del web service...(No se está recibiendo nada)
    public String[] listEquipo() {

        String[] listaEquipos= new String[PaginaPrincipal.nombreEquipo.length];

        for (i=0; i<listaEquipos.length; i++){

            listaEquipos[i]=PaginaPrincipal.nombreEquipo[i];
        }

        return listaEquipos;
    }

    public int[] imagenEquipo(){
        int[] listaImagenes = new int[PaginaPrincipal.nombreEquipo.length];
        for (i=0; i<listaImagenes.length; i++){
            listaImagenes[i] = R.drawable.ic_launcher;
        }
        return listaImagenes;
    }

    public String[] puestoEquipo(){

        String[] listPuesto_ranking = new String[PaginaPrincipal.nombreEquipo.length];

        for (i=0; i<listPuesto_ranking.length; i++)
            listPuesto_ranking[i] = String.valueOf(i+1);

        return listPuesto_ranking;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fm_pg_ranking);


        final ListView lista = (ListView) findViewById(R.id.lista_ranking);
        adapter = new Ranking_Adaptador_LV(this, listEquipo(), imagenEquipo(), ptsEquipo(), puestoEquipo());
        lista.setAdapter(adapter);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        /**INDICAR TITULO Y SUBTITULO**/
        actionBar.setTitle("Ranking");
    }

}