package com.elpoeta.menulateralslide.MenuLateral;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.elpoeta.menulateralslide.PerfilEquipoTaps.Datos;
import com.elpoeta.menulateralslide.PerfilEquipoTaps.Favoritos;
import com.elpoeta.menulateralslide.PerfilEquipoTaps.Miembros;
import com.elpoeta.menulateralslide.R;
import com.elpoeta.menulateralslide.Settings.S_Configuracion;


public class PerfilEquipo2 extends ActionBarActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs_swipe);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        /**INDICAR TITULO Y SUBTITULO**/
        actionBar.setTitle("Perfil de equipo");

        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(adapter);

        mViewPager.setOnPageChangeListener(this);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tab = actionBar.newTab().setText("Datos").setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Miembros").setTabListener(this);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setText("Favoritos").setTabListener(this);
        actionBar.addTab(tab);

    }


    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int arg0) {
            switch (arg0) {
                case 0:
                    return new Datos();
                case 1:
                    return new Miembros();
                case 2:
                    return new Favoritos();
                default:
                    return null;
            }
        }
        public int getCount() {
            return 3;
        }
    }

    //implements on pager selected
    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    @Override
    public void onPageSelected(int i) {
        getSupportActionBar().setSelectedNavigationItem(i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }


    //implements tab listener
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.perfil_equipo, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.miembro_equipo:

                /**********Programar aqui el metodo de agregar miembros de facebook**********/



                Intent intent = new Intent(getApplicationContext(), S_Configuracion.class);
                startActivity(intent);



                /*****************************************************************************/

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}