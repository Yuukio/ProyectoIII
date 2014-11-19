package com.elpoeta.menulateralslide.MenuLateral;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;

import com.elpoeta.menulateralslide.PerfilEquipoTaps.Datos;
import com.elpoeta.menulateralslide.PerfilEquipoTaps.Favoritos;
import com.elpoeta.menulateralslide.PerfilEquipoTaps.Miembros;

public class PerfilEquipo extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_my);  //se saca porque sino se solapan

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        /**INDICAR TITULO Y SUBTITULO**/
        actionBar.setTitle("Perfil de equipo");


        /**MODO TABS EN ACTIONBAR**/
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        /**CREAR TABS**/
        ActionBar.Tab tab = actionBar.newTab().setText("Datos").setTabListener(new TabsListener(this, "datos", Datos.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Miembros").setTabListener(new TabsListener(this, "Miembros", Miembros.class));
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Favoritos").setTabListener(new TabsListener(this, "Favoritos", Favoritos.class));
        actionBar.addTab(tab);


    }

    public class TabsListener implements ActionBar.TabListener {

        private Fragment fragment;
        private final String tag;

        public TabsListener(Activity activity, String tag, Class cls) {
            this.tag = tag;
            fragment = Fragment.instantiate(activity, cls.getName());
        }

        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.replace(android.R.id.content, fragment, tag);

        }

        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.remove(fragment);
        }

        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {}
    }

}