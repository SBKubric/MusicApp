package com.sbkubric.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.btn_now_playing)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_playlist)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_collection)).setOnClickListener(this);
        ((Button) findViewById(R.id.btn_search)).setOnClickListener(this);

        this.setTitle(getString(R.string.popular_name));
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
            case R.id.btn_search:
                Intent intentS = new Intent(this, SearchActivity.class);
                startActivity(intentS);
                break;
        }

    }
}
