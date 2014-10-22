package com.elpoeta.menulateralslide;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.elpoeta.menulateralslide.MenuLateral.Calendario;
import com.elpoeta.menulateralslide.MenuLateral.Disponibilidad;
import com.elpoeta.menulateralslide.MenuLateral.Historial;
import com.elpoeta.menulateralslide.MenuLateral.PaginaPrincipal;
import com.elpoeta.menulateralslide.MenuLateral.PerfilEquipo;
import com.elpoeta.menulateralslide.MenuLateral.Resenas;
import com.elpoeta.menulateralslide.MenuPersonalizado.NavDrawerItem;
import com.elpoeta.menulateralslide.MenuPersonalizado.NavDrawerListAdapter;

import java.util.ArrayList;


public class MyActivity extends Activity {

    /****************************/
    //Solo los taps, sin el menu lateral
    /*
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //setContentView(R.layout.activity_my);  //se saca porque sino se solapan

            ActionBar actionBar = getSupportActionBar();

            //INDICAR TITULO Y SUBTITULO
            actionBar.setTitle("Perfil de equipo");


            //MODO TABS EN ACTIONBAR
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

            //CREAR TABS
            ActionBar.Tab tab = actionBar.newTab().setText("Datos").setTabListener(new TabsListener(this, "datos", Datos.class));
            actionBar.addTab(tab);

            tab = actionBar.newTab().setText("Miembros").setTabListener(new TabsListener(this, "Miembros", Miembros.class));
            actionBar.addTab(tab);

            tab = actionBar.newTab().setText("Favoritos").setTabListener(new TabsListener(this, "Favoritos", Favoritos.class));
            actionBar.addTab(tab);


        }

        public class TabsListener  implements ActionBar.TabListener {

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
*/

/*****************************************************/

//Menu lateral sin taps, hay que conectarlos


    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;

    // nav drawer title
    private CharSequence mDrawerTitle;

    // used to store app title
    private CharSequence mTitle;

    // slide menu items
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;

    private ArrayList<NavDrawerItem> navDrawerItems;
    private NavDrawerListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mTitle = mDrawerTitle = getTitle();

        // load slide menu items
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        // nav drawer icons from resources
        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

        navDrawerItems = new ArrayList<NavDrawerItem>();

        // agregar un nuevo item al menu deslizante
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[6], navMenuIcons.getResourceId(6, -1)));

        // Recycle the typed array
        navMenuIcons.recycle();

        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

        // setting the nav drawer list adapter
        adapter = new NavDrawerListAdapter(getApplicationContext(),
                navDrawerItems);
        mDrawerList.setAdapter(adapter);

        // enabling action bar app icon and behaving it as toggle button
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0);
        }
    }


     //Slide menu item click listener

    private class SlideMenuClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


     //Called when invalidateOptionsMenu() is triggered

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }


    //Diplaying fragment view for selected nav drawer list item

    private void displayView(int position) {

    //private void onItemClick(AdapterView adapterView, View view, int position, long l){

        // update the main content by replacing fragments
        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new PaginaPrincipal();
                break;
            case 1:
                Intent intent = new Intent(getApplicationContext(), PerfilEquipo.class);
                startActivity(intent);
                break;
            case 2:
                Intent intent1 = new Intent(getApplicationContext(), Disponibilidad.class);
                startActivity(intent1);
                break;
            case 3:
                fragment = new Calendario();
                break;
            case 4:
                fragment = new Historial();
                break;
            case 5:
                fragment = new Resenas();
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();

            // update selected item and title, then close the drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            // error in creating fragment
            Log.e("FC'Sport", "MainActivity - Error cuando se creo el fragment");
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getActionBar().setTitle(mTitle);
    }


     //When using the ActionBarDrawerToggle, you must call it during
     //onPostCreate() and onConfigurationChanged()...


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }



}
