package com.elpoeta.menulateralslide.MenuLateral;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.elpoeta.menulateralslide.R;

public class Disponibilidad extends ActionBarActivity{

    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.fm_ml_disponibilidad);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        /**INDICAR TITULO Y SUBTITULO**/
        actionBar.setTitle("Disponibilidad");

        tabHost = (TabHost) findViewById(R.id.th);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("tag1"); //creamos la variable para agregar un tab

        //llenamos pestana por pestana.
        spec.setIndicator("d");//nombreamos la pestana
        spec.setContent(R.id.D);//le indicamos asia cual pestana va dirigida
        tabHost.addTab(spec);//la agregamos

        spec = tabHost.newTabSpec("tag2");//aqui estamos reutilizando la misma variable spec, es lo mismo decir = TabHost.TabSpec spec2 = tabHost.newTabSpec("tag2");
        spec.setIndicator("l");
        spec.setContent(R.id.l);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("tag3");
        spec.setIndicator("k");
        spec.setContent(R.id.k);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("tag4");
        spec.setIndicator("m");
        spec.setContent(R.id.m);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("tag5");
        spec.setIndicator("j");
        spec.setContent(R.id.j);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("tag6");
        spec.setIndicator("v");
        spec.setContent(R.id.v);
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("tag7");
        spec.setIndicator("s");
        spec.setContent(R.id.s);
        tabHost.addTab(spec);


    }
}