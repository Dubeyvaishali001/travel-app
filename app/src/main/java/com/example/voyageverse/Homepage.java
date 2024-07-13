package com.example.voyageverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.ImageView;

import java.util.ArrayList;

public class Homepage extends AppCompatActivity {
    ImageView sidebartoguide;
    static final int PICK_IMAGE = 1;
    private ImageView profileImageView;
    private Uri imageUri;

    @SuppressLint("MissingInflatedId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {   super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);


        AdapterViewFlipper flipper = findViewById(R.id.adapter_flipper_home);


        ArrayList<AdapterFlipperModel> flipper_data = new ArrayList<>();

        // Add items to the flipper data list
        flipper_data.add(new AdapterFlipperModel("Taj Mahal", "Agra", R.drawable.agra_taj_mahal));
        flipper_data.add(new AdapterFlipperModel("Akshardham Temple", "Delhi", R.drawable.new_delhi_akshardham_temple));
        flipper_data.add(new AdapterFlipperModel("Amritsar Golden Temple", "Amritsar", R.drawable.amritsar_golden_temple));
        flipper_data.add(new AdapterFlipperModel("Lake Pichola", "Udaipur", R.drawable.udaipur_lake_pichola));
        flipper_data.add(new AdapterFlipperModel("Victoria Memorial Hall", "Kolkata", R.drawable.kolkata_victoria_memorial_hall));

        // Set the adapter for the flipper
        AdapterFlipper_BaseAdapter flipper_baseadapter = new AdapterFlipper_BaseAdapter(this, flipper_data);
        flipper.setAdapter(flipper_baseadapter);

        // Configure the flipper
        flipper.setAutoStart(true);
        flipper.setFlipInterval(3000);

        // Initialize and set the click listener for the Amritsar card
        CardView amritsar = findViewById(R.id.amritsar_home);
        amritsar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this, Goamritsar.class));
            }
        });
        CardView newdelhi = findViewById(R.id.newdel);
        newdelhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this, Delhchalo.class));
            }
        });

        CardView apnaup = findViewById(R.id.apnaup);
        apnaup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this, Apnaup.class));
            }
        });
        CardView uk = findViewById(R.id.uk);
        uk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this, Gouttarakhand.class));
            }
        });
        CardView kolkatacard = findViewById(R.id.kolkatacard);
        kolkatacard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this, Gokolkata.class));
            }
        });
        CardView keralacard = findViewById(R.id.keralacard);
        keralacard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this, Gokerala.class));
            }
        });

        ImageView sidebartoguide = findViewById(R.id.sidebartoguide);
        sidebartoguide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this, sms.class));
            }
        });
        ImageView imageView2 = findViewById(R.id.imageView2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Homepage.this, ProfileActivity.class));
            }
        });


    }
}
