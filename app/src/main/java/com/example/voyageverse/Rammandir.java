package com.example.voyageverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Rammandir extends AppCompatActivity {

    Button ramnext;;
    LinearLayoutManager manager;
    ArrayList<RecyclerViewModel> list = new ArrayList<>();
    RecyclerViewItemDecoration decoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rammandir);

         ramnext= findViewById(R.id.ramnext);
        ramnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rammandir.this, Agraredfort.class);
                startActivity(intent);
            }
        });
    }
}
