package com.example.tojiy.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.tojiy.myapplication.fragments.FragmentBolimlar;
import com.example.tojiy.myapplication.fragments.FragmentYangilik;
import com.example.tojiy.myapplication.fragments.ViewPagerAdapter;
import com.example.tojiy.myapplication.my_flow.Conn_Server;
import com.example.tojiy.myapplication.search.Search123;
import com.kosalgeek.asynctask.AsyncResponse;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar1;
    private DrawerLayout drawer;
    private RecyclerView rv;
    private ActionBarDrawerToggle drawerToggle;
    private Context context;
    private Switch aSwitch;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;
    private SearchView edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.darktheme);
        } else setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar1 = findViewById(R.id.toolBar1);
        setSupportActionBar(toolbar1);

        appId();

    }

    private void appId() {

        drawer = findViewById(R.id.drawerMain);
        rv = findViewById(R.id.recyc_main1);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);

        viewPager = findViewById(R.id.viewPager123);
        tabLayout = findViewById(R.id.tabLayout123);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//        viewPagerAdapter.addFragments(new FragmentYangilik(), "Yangiliklar");
        viewPagerAdapter.addFragments(new FragmentBolimlar(), "Bolimlar");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        if (UNVERSALCLASS.NAVIGATION_OPEN == 0) {
            drawer.openDrawer(GravityCompat.START);


        }

        drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar1, R.string.drawer_open, R.string.drawer_close);
        drawer.setDrawerListener(drawerToggle);

        Conn_Server conn_server = new Conn_Server(MainActivity.this, rv);
        conn_server.execute("buarini123yuklash", "bir");

        aSwitch = findViewById(R.id.switch_main);


        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            aSwitch.setChecked(true);
        }
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartApp();

                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartApp();
                }
            }
        });


    }

    public void restartApp() {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
        UNVERSALCLASS.NAVIGATION_OPEN = 0;
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_rus) {
//            Toast.makeText(context, "rus", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.menu_uzb) {
//            Toast.makeText(context, "uzb", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
