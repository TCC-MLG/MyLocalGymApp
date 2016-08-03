package gym.com.br.mylocalgym;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Configurações para mapa
        fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.conteiner, new MapsFragment(), "MapsFragment");
        transaction.commitAllowingStateLoss();

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id)
        {
            case R.id.mn_login:
                //Chama outra Activity
                       Intent Login = new Intent(MainActivity.this, Loginactivity.class);
                        MainActivity.this.startActivity(Login);
                break;
            case R.id.mn_buscar:
                break;
            case R.id.mn_statusexame:
                break;
            case R.id.mn_favoritos:
                break;
            case R.id.mn_treinos:
                break;
            case R.id.mnSaldo:
                break;
            case R.id.mnRecarga:
                break;
            case R.id.mnUacadem:
                break;
            case R.id.mnUtreinos:
                break;
            case R.id.mnDpessoais:
                break;
            case R.id.mnOpesquisa:
                break;
        }

//        if (id == R.id.mn_login) {
//
//        } else if (id == R.id.mn_buscar) {
//
//        } else if (id == R.id.mn_statusexame) {
//
//        } else if (id == R.id.mn_favoritos) {
//
//        } else if (id == R.id.mn_treinos) {
//
//        } else if (id == R.id.mnSaldo) {
//
//        } else if (id == R.id.mnRecarga) {
//
//        } else if (id == R.id.mnUacadem) {
//
//        } else if (id == R.id.mnUtreinos) {
//
//        } else if (id == R.id.mnDpessoais) {
//
//        } else if (id == R.id.mnOpesquisa) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
