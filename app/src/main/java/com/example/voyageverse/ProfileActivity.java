package com.example.voyageverse;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private EditText nameEditText, phoneEditText, areaEditText;
    private Button saveButton;
    private DatabaseHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize views
        nameEditText = findViewById(R.id.nameEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        areaEditText = findViewById(R.id.areaEditText);
        saveButton = findViewById(R.id.saveButton);

        // Initialize DatabaseHelper
        dbHelper = new DatabaseHelper(this);

        // Save button click listener
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String email = phoneEditText.getText().toString().trim();
                String area = areaEditText.getText().toString().trim(); // Retrieve area text

                if (!name.isEmpty() && !email.isEmpty() && !area.isEmpty()) {
                    long result = dbHelper.addProfile(name, email, area); // Pass area to addProfile
                    if (result != -1) {
                        Toast.makeText(ProfileActivity.this, "Profile saved successfully", Toast.LENGTH_SHORT).show();
                        // Clear EditText fields after successful save
                        nameEditText.setText("");
                        phoneEditText.setText("");
                        areaEditText.setText("");
                    } else {
                        Toast.makeText(ProfileActivity.this, "Failed to save profile", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ProfileActivity.this, "Please enter name, email, and area", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
