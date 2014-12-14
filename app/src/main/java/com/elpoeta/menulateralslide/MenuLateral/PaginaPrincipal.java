package com.elpoeta.menulateralslide.MenuLateral;

import android.app.Fragment;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.elpoeta.menulateralslide.PaginaPrincipal.Canchas;
import com.elpoeta.menulateralslide.PaginaPrincipal.Equipos;
import com.elpoeta.menulateralslide.PaginaPrincipal.Publicidad;
import com.elpoeta.menulateralslide.PaginaPrincipal.Ranking;
import com.elpoeta.menulateralslide.R;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Luis on 19/10/14.
 */
public class PaginaPrincipal extends Fragment{

    Publicidad p = new Publicidad();

    public static String[] nombreEquipo = new String[1];
    public static String[] puntosEquipo = new String[1];
    public static String[] paisEquipo = new String[1];
    public static String[] ciudadEquipo = new String[1];
    public static boolean[] capitanEquipo = new boolean[1];
    public static String[] miembrosEquipo = new String[1];
    public static String[] nombreCancha = new String[1];
    public static String[] telefonoCancha = new String[1];
    public static Double[] latitudCancha = new Double[1];
    public static Double[] longitudCancha = new Double[1];


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fm_ml_paginaprincipal, container, false);

        MostrarRanking mostrarRanking = new MostrarRanking();
        mostrarRanking.execute();

        MostrarMarks mostrarMarks = new MostrarMarks();
        mostrarMarks.execute();

        MostrarEquipoPosicion mostrarEquipoPosicion = new MostrarEquipoPosicion();
        mostrarEquipoPosicion.execute();

        PerfilEquipoMiembros perfilEquipoMiembros = new PerfilEquipoMiembros();
        perfilEquipoMiembros.execute();


        if(rootView != null){
            Button btn1 = (Button) rootView.findViewById(R.id.btn_canchas);
            Button btn2 = (Button) rootView.findViewById(R.id.btn_equipos);
            Button btn3 = (Button) rootView.findViewById(R.id.btn_ranking);
            Button btn4 = (Button) rootView.findViewById(R.id.btn_eventos);

            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(rootView.getContext(), Canchas.class);
                    startActivity(intent);
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(rootView.getContext(), Equipos.class);
                    startActivity(intent);
                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(rootView.getContext(), Ranking.class);
                    startActivity(intent);

                }
            });

        }
        return rootView;
    }

    private class MostrarRanking extends AsyncTask<String,Integer,Boolean> {


        protected Boolean doInBackground(String... params) {

            boolean resul = true;

            HttpClient httpClient = new DefaultHttpClient();


            //La Ip debe de cambiarse por la ip local
            HttpGet del =
                    new HttpGet("http://sport.whelastic.net/Service/ws/equipo/ranking");

            //Defino que es un Json lo que le voy a pasar
            del.setHeader("content-type", "application/json");

            try {

                HttpResponse resp = httpClient.execute(del);

                String respStr = EntityUtils.toString(resp.getEntity());

                JSONArray respJSON = new JSONArray(respStr);

                nombreEquipo = new String[respJSON.length()];
                puntosEquipo = new String[respJSON.length()];

                for (int i = 0; i < respJSON.length(); i++) {
                    JSONObject obj = respJSON.getJSONObject(i);

                    String nombEq = obj.getString("nombre");
                    String puntosEq = obj.getString("puntos");

                    nombreEquipo[i] = nombEq;
                    puntosEquipo[i] = puntosEq;
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
                        new ArrayAdapter<String>(PaginaPrincipal.this.getActivity(),
                                android.R.layout.simple_list_item_1, nombreEquipo);

                ArrayAdapter<String> adaptador2 =
                        new ArrayAdapter<String>(PaginaPrincipal.this.getActivity(),
                                android.R.layout.simple_list_item_1, puntosEquipo);

            }
        }
    }




    private class MostrarMarks extends AsyncTask<String,Integer,Boolean> {


        protected Boolean doInBackground(String... params) {

            boolean resul = true;

            HttpClient httpClient = new DefaultHttpClient();


            //La Ip debe de cambiarse por la ip local
            HttpGet del =
                    new HttpGet("http://sport.whelastic.net/Service/ws/cancha/detalle");

            //Defino que es un Json lo que le voy a pasar
            del.setHeader("content-type", "application/json");

            try {

                HttpResponse resp = httpClient.execute(del);

                String respStr = EntityUtils.toString(resp.getEntity());

                JSONArray respJSON = new JSONArray(respStr);

                nombreCancha = new String[respJSON.length()];
                telefonoCancha = new String[respJSON.length()];
                latitudCancha = new Double[respJSON.length()];
                longitudCancha = new Double[respJSON.length()];

                for (int i = 0; i < respJSON.length(); i++) {
                    JSONObject obj = respJSON.getJSONObject(i);

                    String nombCancha = obj.getString("nombre");
                    String telCancha = obj.getString("telefonoDetalle");
                    double latCancha = obj.getDouble("latitud");
                    double logCancha = obj.getDouble("longitud");

                    nombreCancha[i] = nombCancha;
                    telefonoCancha[i] = telCancha;
                    latitudCancha[i] = latCancha;
                    longitudCancha[i] = logCancha;
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
                        new ArrayAdapter<String>(PaginaPrincipal.this.getActivity(),
                                android.R.layout.simple_list_item_1, nombreCancha);

                ArrayAdapter<String> adaptador2 =
                        new ArrayAdapter<String>(PaginaPrincipal.this.getActivity(),
                                android.R.layout.simple_list_item_1, telefonoCancha);

                ArrayAdapter<Double> adaptador3 =
                        new ArrayAdapter<Double>(PaginaPrincipal.this.getActivity(),
                                android.R.layout.simple_list_item_1, latitudCancha);

                ArrayAdapter<Double> adaptador4 =
                        new ArrayAdapter<Double>(PaginaPrincipal.this.getActivity(),
                                android.R.layout.simple_list_item_1, longitudCancha);

            }
        }
    }



    private class MostrarEquipoPosicion extends AsyncTask<String,Integer,Boolean> {


        protected Boolean doInBackground(String... params) {

            boolean resul = true;

            HttpClient httpClient = new DefaultHttpClient();


            //La Ip debe de cambiarse por la ip local
            HttpGet del =
                    new HttpGet("http://sport.whelastic.net/Service/ws/equipo/ranking");

            //Defino que es un Json lo que le voy a pasar
            del.setHeader("content-type", "application/json");

            try {

                HttpResponse resp = httpClient.execute(del);

                String respStr = EntityUtils.toString(resp.getEntity());

                JSONArray respJSON = new JSONArray(respStr);

                nombreEquipo = new String[respJSON.length()];
                paisEquipo = new String[respJSON.length()];
                ciudadEquipo = new String[respJSON.length()];

                for (int i = 0; i < respJSON.length(); i++) {
                    JSONObject obj = respJSON.getJSONObject(i);

                    String nombEq = obj.getString("nombre");
                    String paisEq = obj.getString("pais");
                    String ciudadEq = obj.getString("ciudad");

                    nombreEquipo[i] = nombEq;
                    paisEquipo[i] = paisEq;
                    ciudadEquipo[i] = ciudadEq;
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
                        new ArrayAdapter<String>(PaginaPrincipal.this.getActivity(),
                                android.R.layout.simple_list_item_1, nombreEquipo);

                ArrayAdapter<String> adaptador2 =
                        new ArrayAdapter<String>(PaginaPrincipal.this.getActivity(),
                                android.R.layout.simple_list_item_1, paisEquipo);

                ArrayAdapter<String> adaptador3 =
                        new ArrayAdapter<String>(PaginaPrincipal.this.getActivity(),
                                android.R.layout.simple_list_item_1, ciudadEquipo);

            }
        }
    }



    /**private class MostrarEquipoPosicion extends AsyncTask<String,Integer,Boolean> {


     protected Boolean doInBackground(String... params) {

     boolean resul = true;

     HttpClient httpClient = new DefaultHttpClient();


     //La Ip debe de cambiarse por la ip local
     HttpGet del =
     new HttpGet("http://sport.whelastic.net/Service/ws/equipo/ranking");

     //Defino que es un Json lo que le voy a pasar
     del.setHeader("content-type", "application/json");

     try {

     HttpResponse resp = httpClient.execute(del);

     String respStr = EntityUtils.toString(resp.getEntity());

     JSONArray respJSON = new JSONArray(respStr);

     nombreEquipo = new String[respJSON.length()];
     paisEquipo = new String[respJSON.length()];
     ciudadEquipo = new String[respJSON.length()];

     for (int i = 0; i < respJSON.length(); i++) {
     JSONObject obj = respJSON.getJSONObject(i);

     String nombEq = obj.getString("nombre");
     String paisEq = obj.getString("pais");
     String ciudadEq = obj.getString("ciudad");

     nombreEquipo[i] = nombEq;
     paisEquipo[i] = paisEq;
     ciudadEquipo[i] = ciudadEq;
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
     new ArrayAdapter<String>(PaginaPrincipal.this.getActivity(),
     android.R.layout.simple_list_item_1, nombreEquipo);

     ArrayAdapter<String> adaptador2 =
     new ArrayAdapter<String>(PaginaPrincipal.this.getActivity(),
     android.R.layout.simple_list_item_1, paisEquipo);

     ArrayAdapter<String> adaptador3 =
     new ArrayAdapter<String>(PaginaPrincipal.this.getActivity(),
     android.R.layout.simple_list_item_1, ciudadEquipo);

     }
     }
     }**/


    private class PerfilEquipoMiembros extends AsyncTask<String,Integer,Boolean> {

        protected Boolean doInBackground(String... params) {

            boolean resul = true;

            HttpClient httpClient = new DefaultHttpClient();

            HttpPost post = new HttpPost("http://sport.whelastic.net/Service/ws/equipo/ranking");
            post.setHeader("content-type", "application/json");

            HttpGet del =
                    new HttpGet("http://sport.whelastic.net/Service/ws/equipo/ranking");

            //Defino que es un Json lo que le voy a pasar
            del.setHeader("content-type", "application/json");


            try
            {
                //Construimos el objeto cliente en formato JSON
                JSONObject dato = new JSONObject();

                HttpResponse response = httpClient.execute(del);
                String respString = EntityUtils.toString(response.getEntity());

                JSONArray respJSON = new JSONArray(respString);

                //dato.put("Id", Integer.parseInt(txtId.getText().toString()));
                dato.put("1", params[0]);

                StringEntity entity = new StringEntity(dato.toString());
                post.setEntity(entity);

                HttpResponse resp = httpClient.execute(post);
                String respStr = EntityUtils.toString(resp.getEntity());


                miembrosEquipo = new String[respJSON.length()];

                for (int i = 0; i < respJSON.length(); i++) {
                    JSONObject obj = respJSON.getJSONObject(i);

                    String id = obj.getString("idJugador");
                    boolean capitan = obj.getBoolean("Capitan");
                    int anotaciones = obj.getInt("Anotaciones");

                    miembrosEquipo[i] = id;
                }


                if(!respStr.equals("true"))
                    resul = false;
            }
            catch(Exception ex)
            {
                Log.e("ServicioRest","Error!", ex);
                resul = false;
            }

            return resul;
        }

        protected void onPostExecute(Boolean result) {

            if (result)
            {
                ArrayAdapter<String> adaptador3 =
                        new ArrayAdapter<String>(PaginaPrincipal.this.getActivity(),
                                android.R.layout.simple_list_item_1, ciudadEquipo);
            }
        }
    }



}
