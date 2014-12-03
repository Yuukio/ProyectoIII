package com.elpoeta.menulateralslide.MenuLateral;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.elpoeta.menulateralslide.R;


public class SpinnerConfiguracion extends Activity {

    String[] spinnerValues = {"Blur", "NFS", "Burnout", "GTA IV", "Racing",};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner_configuracion);
        mySpinner.setAdapter(new MyAdapter(this, R.layout.lv_estilo_menu_notificaciones, spinnerValues));
    }

    public class MyAdapter extends ArrayAdapter<String> {

        public MyAdapter(Context ctx, int txtViewResourceId, String[] objects) {

            super(ctx, txtViewResourceId, objects);
        }

        @Override
        public View getDropDownView(int position, View cnvtView, ViewGroup prnt) {
            return getCustomView(position, cnvtView, prnt);
        }

        @Override
        public View getView(int pos, View cnvtView, ViewGroup prnt) {
            return getCustomView(pos, cnvtView, prnt);
        }

        public View getCustomView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = getLayoutInflater();
            View mySpinner = inflater.inflate(R.layout.lv_estilo_menulateral_spinner, parent, false);

            TextView subSpinner = (TextView) mySpinner.findViewById(R.id.txtSpinnerConfig);
            subSpinner.setText(spinnerValues[position]);

            return mySpinner;
        }
    }
}



