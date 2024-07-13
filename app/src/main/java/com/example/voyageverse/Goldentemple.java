package com.example.voyageverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Goldentemple extends AppCompatActivity {

    Button goldennext;
    LinearLayoutManager manager;
    ArrayList<RecyclerViewModel> list = new ArrayList<>();
    RecyclerViewItemDecoration decoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.golden_temple);

        goldennext = findViewById(R.id.goldennext);
        goldennext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Goldentemple.this, Jallianwala.class);
                startActivity(intent);
            }
        });
    }
}
