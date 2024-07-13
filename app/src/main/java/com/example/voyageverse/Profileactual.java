package com.example.voyageverse;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Profileactual extends AppCompatActivity {

    private ImageView profileImageView;
    private TextView nameTextView;
    private TextView emailTextView;
    private SharedPreferences sharedPreferences;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profileactual);

        profileImageView = findViewById(R.id.profileImageView);
        nameTextView = findViewById(R.id.nameTextView);
        emailTextView = findViewById(R.id.emailTextView);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("ProfileData", MODE_PRIVATE);

        // Load saved profile data
        loadProfileData();
    }

    private void loadProfileData() {
        String name = sharedPreferences.getString("name", "");
        String email = sharedPreferences.getString("email", "");
        String imageUriString = sharedPreferences.getString("imageUri", "");

        // Display name and email
        nameTextView.setText(name);
        emailTextView.setText(email);

        // Display profile image if available
        if (!imageUriString.isEmpty()) {
            Uri imageUri = Uri.parse(imageUriString);
            profileImageView.setImageURI(imageUri);
        }
    }
}
