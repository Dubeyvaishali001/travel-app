package com.example.voyageverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Kashi extends AppCompatActivity {

    Button kashinext;
    LinearLayoutManager manager;
    ArrayList<RecyclerViewModel> list = new ArrayList<>();
    RecyclerViewItemDecoration decoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kashi);

        kashinext = findViewById(R.id.kashinext);
        kashinext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Kashi.this, Rammandir.class);
                startActivity(intent);
            }
        });
    }
}
