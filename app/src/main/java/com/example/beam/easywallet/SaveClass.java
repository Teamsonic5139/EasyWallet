package com.example.beam.easywallet;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Dell on 5/12/2560.
 */


public class SaveClass extends AppCompatActivity{
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.savelayout);


        ImageView img = findViewById(R.id.output_view);
        img.setImageResource(R.drawable.ic_income);
    }




    }

