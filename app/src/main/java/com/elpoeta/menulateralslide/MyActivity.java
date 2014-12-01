package com.elpoeta.menulateralslide;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.elpoeta.menulateralslide.MenuLateral.Calendario;
import com.elpoeta.menulateralslide.MenuLateral.Disponibilidad;
import com.elpoeta.menulateralslide.MenuLateral.Historial;
import com.elpoeta.menulateralslide.MenuLateral.PaginaPrincipal;
import com.elpoeta.menulateralslide.MenuLateral.PerfilEquipo;
import com.elpoeta.menulateralslide.MenuPersonalizado.NavDrawerItem;
import com.elpoeta.menulateralslide.MenuPersonalizado.NavDrawerListAdapter;
import com.elpoeta.menulateralslide.Settings.S_Configuracion;

import java.util.ArrayList;


public class MyActivity extends FragmentActivity {

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

    /*
    ViewPager vp;
    private List<Fragment> getFragments(){
        List<Fragment> listF = new ArrayList<Fragment>();
        listF.add(ModelFragment.newInstance(R.drawable.ima2));
        listF.add(ModelFragment.newInstance(R.drawable.ima3));
        listF.add(ModelFragment.newInstance(R.drawable.ima4));
        return listF;
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        mTitle = mDrawerTitle = getTitle();

        // load slide menu items
        navMenuTitles = getResources().getStringArray(R.array.lista_nombre_layouts);

        // nav drawer icons from resources
        navMenuIcons = getResources().obtainTypedArray(R.array.lista_nombre_iconos);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

        /*****************************Header y Footer**********************************/
        View footer = getLayoutInflater().inflate(R.layout.lv_estilo_footer, null);
        mDrawerList.addFooterView(footer);

        View header = getLayoutInflater().inflate(R.layout.lv_estilo_header, null);
        mDrawerList.addHeaderView(header);

        /*****************************Header y Footer**********************************/

        navDrawerItems = new ArrayList<NavDrawerItem>();

        // agregar un nuevo item al menu deslizante
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));

        // Recycle the typed array
        navMenuIcons.recycle();

        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

        // setting the nav drawer list adapter
        adapter = new NavDrawerListAdapter(getApplicationContext(),navDrawerItems);
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
            displayView(1);
        }


        /******************************/

        /*
        vp = (ViewPager)findViewById(R.id.vp_biodata);
        ControllerFragment cf = new ControllerFragment(getSupportFragmentManager(), getFragments());
        vp.setAdapter(cf);
        */

        /*************************Programacion menu lateral footer*****************************/

        Button btn1 = (Button) findViewById(R.id.btn_configuracion);
        Button btn2 = (Button) findViewById(R.id.btn_sugerir);
        Button btn3 = (Button) findViewById(R.id.btn_recomendarnos);
        Button btn4 = (Button) findViewById(R.id.btn_valorar);
        Button btn5 = (Button) findViewById(R.id.btn_ayuda);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(getApplicationContext(), S_Configuracion.class);
                startActivity(intent0);
            }
        });

        /*
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = getLayoutInflater();

                View dialoglayout = inflater.inflate(R.layout.s_sugerir_cambio, null);

                final EditText etAsunto = (EditText) dialoglayout.findViewById(R.id.et_EmailAsunto);
                final EditText etMensaje = (EditText) dialoglayout.findViewById(R.id.et_EmailMensaje);

                Button btnEnviarMail = (Button) dialoglayout.findViewById(R.id.btnEnviarMail);
                btnEnviarMail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String subject = etAsunto.getText().toString();
                        String message = etMensaje.getText().toString();

                        Intent email = new Intent(Intent.ACTION_SEND);
                        email.putExtra(Intent.EXTRA_EMAIL, new String[] { "micorre@gmail.com"});
                        email.putExtra(Intent.EXTRA_SUBJECT, subject);
                        email.putExtra(Intent.EXTRA_TEXT, " mensaje " + message);

                        // need this to prompts email client only
                        email.setType("message/rfc822");
                        startActivity(Intent.createChooser(email, "Seleciona un cliente de correo"));

                    }
                });

                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setView(dialoglayout);
                builder.show();

            }
        });

        */
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        /*
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getApplicationContext());
                // Setting Dialog Message
                alertDialog.setTitle("Valorar nuestra aplicacón");
                alertDialog.setMessage("Tu comentario es muy importante, por favor VALORA nuestra aplicación o deja un comentario.");

                alertDialog.setCancelable(true);
                alertDialog.setPositiveButton("Valorar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {

                        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
                        } catch (android.content.ActivityNotFoundException anfe) {}
                    }
                });
                alertDialog.show();
            }
        });
        */

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


     //Slide menu item click listener

    private class SlideMenuClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
            // display view for selected nav drawer item
            displayView(position);
        }
    }




     //Called when invalidateOptionsMenu() is triggered

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.s_configuracion).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }


    //Diplaying fragment view for selected nav drawer list item

    private void displayView(int position) {

    //private void onItemClick(AdapterView adapterView, View view, int position, long l){

        // update the main content by replacing fragments
        Fragment fragment = null;

        switch (position) {
            case 1:
                fragment = new PaginaPrincipal();
                break;
            case 2:
                Intent intent = new Intent(getApplicationContext(), PerfilEquipo.class);
                startActivity(intent);
                break;
            case 3:
                /*
                Intent intent1 = new Intent(getApplicationContext(), Disponibilidad.class);
                startActivity(intent1);
                */
                fragment = new Disponibilidad();
                break;
            case 4:
                fragment = new Calendario();
                break;
            case 5:
                fragment = new Historial();
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

    /**********************Menu settings***********************/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
            case R.id.s_configuracion:
                Intent intent = new Intent(getApplicationContext(), S_Configuracion.class);
                startActivity(intent);
                return true;

            case R.id.s_sugerir_cambios:

                LayoutInflater inflater = getLayoutInflater();

                View dialoglayout = inflater.inflate(R.layout.s_sugerir_cambio, null);

                final EditText etAsunto = (EditText) dialoglayout.findViewById(R.id.et_EmailAsunto);
                final EditText etMensaje = (EditText) dialoglayout.findViewById(R.id.et_EmailMensaje);

                Button btnEnviarMail = (Button) dialoglayout.findViewById(R.id.btnEnviarMail);
                btnEnviarMail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        String subject = etAsunto.getText().toString();
                        String message = etMensaje.getText().toString();

                        Intent email = new Intent(Intent.ACTION_SEND);
                        email.putExtra(Intent.EXTRA_EMAIL, new String[] { "micorre@gmail.com"});
                        email.putExtra(Intent.EXTRA_SUBJECT, subject);
                        email.putExtra(Intent.EXTRA_TEXT, " mensaje " + message);

                        // need this to prompts email client only
                        email.setType("message/rfc822");
                        startActivity(Intent.createChooser(email, "Seleciona un cliente de correo"));

                    }
                });

                AlertDialog.Builder builder = new AlertDialog.Builder(MyActivity.this);
                builder.setView(dialoglayout);
                builder.show();

                return true;

            case R.id.s_recomendarnos:
                return true;

            case R.id.s_valorar_app:

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MyActivity.this);
                // Setting Dialog Message
                alertDialog.setTitle("Valorar aplicacion");
                alertDialog.setMessage("Tu opinión es muy importante, por favor VALORA nuestra aplicación o deja un comentario.");

                alertDialog.setCancelable(true);
                alertDialog.setPositiveButton("Valorar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {

                        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                        try {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
                        } catch (android.content.ActivityNotFoundException anfe) {}
                    }
                });
                alertDialog.show();

                return true;

            case R.id.s_ayuda:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
