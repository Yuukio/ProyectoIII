package com.elpoeta.menulateralslide.PaginaPrincipal;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.elpoeta.menulateralslide.AdaptadorListas.Ranking_Adaptador_LV;
import com.elpoeta.menulateralslide.R;


public class Ranking extends ActionBarActivity {


    Ranking_Adaptador_LV adapter;


    public String[] listEquipo() {
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
        return listaEquipos;
    }

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
        adapter = new Ranking_Adaptador_LV(this, listEquipo(), listaImagenes, listPts_ranking, listPuesto_ranking);
        lista.setAdapter(adapter);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        /**INDICAR TITULO Y SUBTITULO**/
        actionBar.setTitle("Ranking");
    }

    /**public class TareaWSListar extends AsyncTask<String,Integer,Boolean> {

         Ranking r = new Ranking();
         String[] clientes = r.listEquipo();

         protected Boolean doInBackground(String... params) {

             boolean resul = true;

             HttpClient httpClient = new DefaultHttpClient();

             HttpGet del =
             new HttpGet("http://192.168.43.167:8080/Service/ws/equipo/ranking");

             del.setHeader("content-type", "application/json");

             try {
                 HttpResponse resp = httpClient.execute(del);
                 String respStr = EntityUtils.toString(resp.getEntity());

                 JSONArray respJSON = new JSONArray(respStr);

                 clientes = new String[respJSON.length()];

                 for (int i = 0; i < respJSON.length(); i++) {
                 JSONObject obj = respJSON.getJSONObject(i);

                 String nombCli = obj.getString("nombre");

                 clientes[i] = nombCli;
             }
             } catch (Exception ex) {
                 Log.e("ServicioRest", "Error!", ex);
                 resul = false;
             }

         return resul;
         }

     protected void onPostExecute(Boolean result) {

         if (result) {
             //Rellenamos la lista con los nombres de los clientes
             //Rellenamos la lista con los resultados
             ArrayAdapter<String> adaptador =
             new ArrayAdapter<String>(Ranking.this,
             android.R.layout.simple_list_item_1, clientes);
         }
     }

     }**/

}
