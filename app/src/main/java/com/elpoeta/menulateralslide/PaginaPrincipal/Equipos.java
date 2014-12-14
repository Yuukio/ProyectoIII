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
import com.elpoeta.menulateralslide.MenuLateral.PaginaPrincipal;
import com.elpoeta.menulateralslide.R;


public class Equipos extends ActionBarActivity{

    Equipos_Adaptador_LV adapter;
    int i;


    String[] listaNombreEquipos() {

        String[] listaEquipos= new String[PaginaPrincipal.nombreEquipo.length];

        for (i=0; i<listaEquipos.length; i++){

            listaEquipos[i]=PaginaPrincipal.nombreEquipo[i];
        }

        return listaEquipos;
    }

    public int[] listaImagenes(){
        int[] listaImagenes = new int[PaginaPrincipal.nombreEquipo.length];
        for (i=0; i<listaImagenes.length; i++){
            listaImagenes[i] = R.drawable.ic_launcher;
        }
        return listaImagenes;
    }

    String[] listaNombreLider = new String[]{
            "Hola Mundo",
            "Luis Solano",
            "Ermis Luna",
            "Kenneth Aguilar",
            "Sebastian Rey",
            "Esteban Sanabria",
            "Abel Pacheco",
            "Keylor Navas",
            "Ermis Luna",
            "Kenneth Aguilar",
            "Sebastian Rey",
            "Esteban Sanabria",
            "Abel Pacheco",
            "Keylor Navas"
    };

    Spinner listaPais;
    Spinner listaCiudad;

    public String[] listPais() {

        String[] listaEquiposPais= new String[PaginaPrincipal.paisEquipo.length];

        for (i=0; i<listaEquiposPais.length; i++){

            listaEquiposPais[i]=PaginaPrincipal.paisEquipo[i];
        }

        return listaEquiposPais;
    }

    public String[] listCiudad() {

        String[] listaEquiposCiudad= new String[PaginaPrincipal.ciudadEquipo.length];

        for (i=0; i<listaEquiposCiudad.length; i++){

            listaEquiposCiudad[i]= PaginaPrincipal.ciudadEquipo[i];
        }

        return listaEquiposCiudad;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fm_pg_equipos);

        final ListView lista = (ListView) findViewById(R.id.lista_equipos);
        adapter = new Equipos_Adaptador_LV(this, listaImagenes(), listaNombreEquipos(), listaNombreLider);
        lista.setAdapter(adapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        /**INDICAR TITULO Y SUBTITULO**/
        actionBar.setTitle("Equipos");

        /*****SPINNER*****/
        listaPais = (Spinner) findViewById(R.id.lista_provincias);


        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, listPais());
        listaPais.setAdapter(adaptador);



        listaPais.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                listaCiudad = (Spinner) findViewById(R.id.lista_cantones);

                ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(getBaseContext(), R.layout.support_simple_spinner_dropdown_item, listCiudad());
                listaCiudad.setAdapter(adaptador2);
                listaCiudad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                        /*Switch de campos y metodos*/
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}