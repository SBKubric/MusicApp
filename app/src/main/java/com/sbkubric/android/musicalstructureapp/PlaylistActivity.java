package com.sbkubric.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class PlaylistActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((Button) findViewById(R.id.btn_now_playing)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_playlist)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_collection)).setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            default:
                finish();
                return true;
        }
    }

    @Override
    public void onClick(View view) {
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
