package com.example.voyageverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Partition extends AppCompatActivity {

    Button partionext;
    LinearLayoutManager manager;
    ArrayList<RecyclerViewModel> list = new ArrayList<>();
    RecyclerViewItemDecoration decoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_paritionmusium);

        partionext = findViewById(R.id.partitionnext);
        partionext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Partition.this, Ramtirath.class);
                startActivity(intent);
            }
        });
    }
}
