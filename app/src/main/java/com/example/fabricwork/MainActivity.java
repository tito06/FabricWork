package com.example.fabricwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageList[] myImageList = new ImageList[]{
                new ImageList( R.drawable.titlea),
                new ImageList(R.drawable.titleb),
                new ImageList(R.drawable.titlec),
                new ImageList(R.drawable.titled)

        };

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        ImageAdapter imageAdapter = new ImageAdapter(myImageList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(imageAdapter);



    }
}
