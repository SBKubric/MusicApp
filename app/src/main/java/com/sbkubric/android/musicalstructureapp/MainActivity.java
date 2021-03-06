package com.sbkubric.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View hview = navigationView.getHeaderView(0);
        Button signIn = (Button) hview.findViewById(R.id.text_nav_header_register);
        Button settingsImg = (Button) hview.findViewById(R.id.imageView);
        signIn.setOnClickListener(this);
        settingsImg.setOnClickListener(this);
        ((Button) findViewById(R.id.btn_now_playing)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_playlist)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_collection)).setOnClickListener(this);

        this.setTitle(getString(R.string.popular_name));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_popular) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_search) {
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_tracks) {
            Intent intent = new Intent(this, PlaylistActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_albums) {
            Intent intent = new Intent(this, CollectionActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_artists) {
            Intent intent = new Intent(this, CollectionActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_playlists) {
            Intent intent = new Intent(this, CollectionActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View hview = navigationView.getHeaderView(0);
        Button signIn = (Button) hview.findViewById(R.id.text_nav_header_register);
        Button settingsImg = (Button) hview.findViewById(R.id.imageView);

        if (view.getId() == signIn.getId()) {
            Intent intent = new Intent(this, SignInActivity.class);
            startActivity(intent);
        } else if (view.getId() == settingsImg.getId()) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }
        switch (view.getId()) {
            default:
                break;
            case R.id.btn_now_playing:
                Intent intentNP = new Intent(this, NowPlayingActivity.class);
                startActivity(intentNP);
                break;
            case R.id.btn_playlist:
                Intent intentP = new Intent(this, PlaylistActivity.class);
                startActivity(intentP);
                break;
            case R.id.btn_collection:
                Intent intentC = new Intent(this, CollectionActivity.class);
                startActivity(intentC);
                break;
        }

    }
}
