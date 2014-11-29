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
    Spinner listaCantones;

    String[] listProv = {
            "San José",
            "Alajuela",
            "Cartago",
            "Guanacaste",
            "Heredia",
            "Limón",
            "Puntarenas"
    };

    String[] listaCantonSanJose = {"San José", "Escazú", "Desamparados", "Puriscal", "Tarrazú",
            "Aserrí", "Mora", "Goicoechea", "Santa Ana", "Alajuelita", "Vázquez de Coronado",
            "Acosta", "Tibás", "Moravia", "Montes de Oca", "Turrubares"};

    String[] listaCantonAlajuela = {"Alajuela", "San Ramón", "Grecia", "San Mateo", "Atenas",
            "Naranjo", "Palmares", "Poás", "Orotina", "San Carlos", "Zarcero", "Valverde Vega",
            "Upala", "Los Chiles", "Guatuso"};

    String[] listaCantonHeredia = {"Heredia", "Barva", "Santo Domingo", "Santa Barbara",
            "San Isidro", "Belén", "Flores", "San Pablo", "Sarapiquí"};

    String[] listaCantonCartago = {"Cartago", "Paraíso", "La Unión", "Jiménez", "Turrialba",
            "Alvarado", "Oreamuno", "El Guarco"};

    String[] listaCantonPuntarenas = {"Puntarenas", "Esparza", "Buenos Aires", "Montes de Oro",
            "Osa", "Aguirre", "Golfito", "Coto Brus", "Parrita", "Corredores", "Garabito"};

    String[] listaCantonGuanacaste = {"Liberia", "Nicoya", "Snta Cruz", "Bagaces", "Carrillo",
            "Cañas", "Abangares", "Tilarán", "Nandayure", "La Cruz", "Hojancha"};

    String[] listaCantonLimon = {"Limón", "Pococí", "Siquirres", "Talamanca", "Matina", "Guácimo"};

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

        /*****SPINNER*****/
        listaProvincias = (Spinner) findViewById(R.id.lista_provincias);


        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, listProv);
        listaProvincias.setAdapter(adaptador);



        listaProvincias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){

/***San Jose***/    case 0:

                        listaCantones = (Spinner) findViewById(R.id.lista_cantones);
                        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(getBaseContext(), R.layout.support_simple_spinner_dropdown_item, listaCantonSanJose);
                        listaCantones.setAdapter(adaptador2);
                        listaCantones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                /*Switch de campos y metodos*/
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {}});
                        break;

/***Alajuela***/    case 1:

                        listaCantones = (Spinner) findViewById(R.id.lista_cantones);
                        ArrayAdapter<String> adaptador3 = new ArrayAdapter<String>(getBaseContext(), R.layout.support_simple_spinner_dropdown_item, listaCantonAlajuela);
                        listaCantones.setAdapter(adaptador3);
                        listaCantones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                /*Switch de campos y metodos*/
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {}});

                        break;
/***Cartago***/     case 2:

                        listaCantones = (Spinner) findViewById(R.id.lista_cantones);
                        ArrayAdapter<String> adaptador4 = new ArrayAdapter<String>(getBaseContext(), R.layout.support_simple_spinner_dropdown_item, listaCantonCartago);
                        listaCantones.setAdapter(adaptador4);
                        listaCantones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                /*Switch de campos y metodos*/
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {}});

                        break;
/***Guanacaste***/  case 3:

                        listaCantones = (Spinner) findViewById(R.id.lista_cantones);
                        ArrayAdapter<String> adaptador5 = new ArrayAdapter<String>(getBaseContext(), R.layout.support_simple_spinner_dropdown_item, listaCantonGuanacaste);
                        listaCantones.setAdapter(adaptador5);
                        listaCantones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                /*Switch de campos y metodos*/
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {}});

                        break;
/***Heredia***/     case 4:

                        listaCantones = (Spinner) findViewById(R.id.lista_cantones);
                        ArrayAdapter<String> adaptador6 = new ArrayAdapter<String>(getBaseContext(), R.layout.support_simple_spinner_dropdown_item, listaCantonHeredia);
                        listaCantones.setAdapter(adaptador6);
                        listaCantones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                /*Switch de campos y metodos*/
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {}});

                        break;
/***Limon***/       case 5:

                        listaCantones = (Spinner) findViewById(R.id.lista_cantones);
                        ArrayAdapter<String> adaptador7 = new ArrayAdapter<String>(getBaseContext(), R.layout.support_simple_spinner_dropdown_item, listaCantonLimon);
                        listaCantones.setAdapter(adaptador7);
                        listaCantones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                /*Switch de campos y metodos*/
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {}});

                        break;
/***Puntarenas***/  case 6:

                        listaCantones = (Spinner) findViewById(R.id.lista_cantones);
                        ArrayAdapter<String> adaptador8 = new ArrayAdapter<String>(getBaseContext(), R.layout.support_simple_spinner_dropdown_item, listaCantonPuntarenas);
                        listaCantones.setAdapter(adaptador8);
                        listaCantones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                /*Switch de campos y metodos*/
                            }
                            @Override
                            public void onNothingSelected(AdapterView<?> adapterView) {}});

                        break;

                    default:
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
