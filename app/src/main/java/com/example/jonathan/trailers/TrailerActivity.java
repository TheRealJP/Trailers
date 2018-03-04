package com.example.jonathan.trailers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class TrailerActivity extends AppCompatActivity {


    private GridView gvTrailers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);
        gvTrailers = findViewById(R.id.gridView);
        TrailerAdapter adapter = new TrailerAdapter(this, Trailer.getTrailers());
        gvTrailers.setAdapter(adapter);

    }
}
