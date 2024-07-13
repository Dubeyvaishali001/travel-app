package com.example.voyageverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Rishikesh extends AppCompatActivity {

    Button rishikeshnext;
    LinearLayoutManager manager;
    ArrayList<RecyclerViewModel> list = new ArrayList<>();
    RecyclerViewItemDecoration decoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rishikesh);

        rishikeshnext = findViewById(R.id.rishikeshnext);
        rishikeshnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rishikesh.this, Dehradun.class);
                startActivity(intent);
            }
        });
    }
}
