package com.elpoeta.menulateralslide.PaginaPrincipal;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.elpoeta.menulateralslide.MenuLateral.PaginaPrincipal;
import com.elpoeta.menulateralslide.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;


public class Canchas extends FragmentActivity {
    /**
     * Local variables *
     */
    GoogleMap mapa;
    LatLng latLng;
    MarkerOptions markerOptions;


    int i;
    private LatLng ULT = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fm_pg_canchas);

        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.mapView);

        // Obteniendo referencia del mapa
        mapa = supportMapFragment.getMap();

        // Referenciamos el boton "Buscar" del Layout fm_pg_canchas
        Button btn_find = (Button) findViewById(R.id.btn_find);


        //Mi LOCALIZACION
        mapa.setMyLocationEnabled(true);
        myLocation();


        //Crear los marks
        crearMarks();

        // Definiendo el boton onClickListener
        OnClickListener findClickListener = new OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obteniendo la localización insertada
                EditText etLocation = (EditText) findViewById(R.id.etLocation);
                // Nombrando un atributo para utilizar la ubicación
                String location = etLocation.getText().toString();
                if(location!=null && !location.equals("")){
                    new GeocoderTask().execute(location);
                }
            }
        };

        // Activando el boton "Buscar" para realizar la misma
        btn_find.setOnClickListener(findClickListener);
    }

    /*Metodos*/
    private class GeocoderTask extends AsyncTask<String, Void, List<Address>> {

        @Override
        protected List<Address> doInBackground(String... locationName) {
            // Creando la instancia "GEOCODER"
            Geocoder geocoder = new Geocoder(getBaseContext());
            List<Address> addresses = null;

            try {
                // Buscando 3 puntos cercanos a la localización
                addresses = geocoder.getFromLocationName(locationName[0], 3);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return addresses;
        }

        @Override
        protected void onPostExecute(List<Address> addresses) {

            try {
                if (addresses == null || addresses.size() == 0) {
                    Toast.makeText(getBaseContext(), "Localización no encontrada", Toast.LENGTH_SHORT).show();
                }

                // Creando conexiones de ubicación
                for (int i = 0; i < addresses.size(); i++) {

                    Address address = (Address) addresses.get(i);

                    // Creando instancia "GEOPOINT" para presentarlo en el mapa
                    latLng = new LatLng(address.getLatitude(), address.getLongitude());

                    String addressText = String.format("%s, %s",
                            address.getMaxAddressLineIndex() > 0 ? address.getAddressLine(0) : "",
                            address.getCountryName());

                    mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));

                    // Localiza el primer punto del mapa "EN MEDIO"
                    if (i == 0)
                        mapa.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                }
            }catch(Exception e){
                Toast.makeText(getBaseContext(), "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        }
    }

    //ESTE METODO SE VA A ENCARGAR DE CREAR TODOS LOS MARKS DEL MAPA

    public void crearMarks(){

        String[] nombCancha = new String[PaginaPrincipal.nombreCancha.length];
        String[] telCancha = new String[PaginaPrincipal.telefonoCancha.length];
        double[] latCancha = new double[PaginaPrincipal.latitudCancha.length];
        double[] longCancha = new double[PaginaPrincipal.longitudCancha.length];

        for (i=0; i<nombCancha.length; i++) {
            nombCancha[i] = PaginaPrincipal.nombreCancha[i];
            longCancha[i] = PaginaPrincipal.longitudCancha[i];
            latCancha[i] = PaginaPrincipal.latitudCancha[i];
            telCancha[i] = PaginaPrincipal.telefonoCancha[i];

            ULT = new LatLng(latCancha[i],longCancha[i]);

            MarkerOptions marcador1 =  new MarkerOptions();//Se crea el MARK
            marcador1.position(ULT); //Para este campo creamos una nueva variable con Lat y Lon antes de entrar al <FOR> para crear el mark
            marcador1.title(nombCancha[i]);//Este campo se llena con <NOMBRE> de la base de datos
            marcador1.snippet(telCancha[i]);//Este campo se llena con <TELEFONO> de la base de datos
            marcador1.anchor(0.5f, 0.5f);
            mapa.addMarker(marcador1);
        }
    }

    public void myLocation(){
        mapa.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            MarkerOptions localization = new MarkerOptions();
            @Override
            public void onMyLocationChange(Location arg0) {
                localization.position(new LatLng(arg0.getLatitude(), arg0.getLongitude())).title("¡Aquí Estoy!")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                mapa.addMarker(localization);
            }
        });
    }
}