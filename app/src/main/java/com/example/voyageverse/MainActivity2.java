
package com.example.voyageverse;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize Firebase
        FirebaseApp.initializeApp(this);

        // Get references to the UI elements
        EditText usernameInput = findViewById(R.id.username_input);
        EditText passwordInput = findViewById(R.id.password_input);
        TextView signupText = findViewById(R.id.signup_text);
        Button loginButton = findViewById(R.id.login_button);

        // Initialize Firebase Database reference
        reference = FirebaseDatabase.getInstance().getReference("users");

        // Set the login button click listener
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
                } else {
                    checkUser(username, password);
                }
            }
        });

        // Set the sign-up text click listener
        signupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

    }

    private void checkUser(String username, String password) {
        Log.d(TAG, "Checking user: " + username);
        DatabaseReference userRef = reference.child(username);
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Log.d(TAG, "User exists in database");
                    String passwordFromDB = dataSnapshot.child("password").getValue(String.class);
                    if (Objects.equals(passwordFromDB, password)) {
                        Log.d(TAG, "Password matches");
                        Intent intent = new Intent(MainActivity2.this, Homepage.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Log.d(TAG, "Password does not match");
                        Toast.makeText(MainActivity2.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.d(TAG, "User does not exist in database");
                    Toast.makeText(MainActivity2.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, "Database error: " + databaseError.getMessage());
                Toast.makeText(MainActivity2.this, "Database error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}















































































//package com.example.voyageverse;
//
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//
//public class MainActivity2 extends AppCompatActivity {
//
//    private static final String TAG = "MainActivity2";
//    private DatabaseReference reference;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main2);
//
//        // Initialize Firebase
//        FirebaseApp.initializeApp(this);
//
//        EditText usernameInput = findViewById(R.id.username_input);
//        EditText passwordInput = findViewById(R.id.password_input);
//        TextView signupText = findViewById(R.id.signup_text);
//        Button loginButton = findViewById(R.id.login_button);
//
//
//        reference = FirebaseDatabase.getInstance().getReference("users");
//
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String username = usernameInput.getText().toString().trim();
//                String password = passwordInput.getText().toString().trim();
//
//                if (username.isEmpty() || password.isEmpty()) {
//                    Toast.makeText(MainActivity2.this, "Please enter username and password", Toast.LENGTH_SHORT).show();
//                } else {
//                    checkUser(username, password);
//                }
//            }
//        });
//
//        signupText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
//                startActivity(intent);
//            }
//        });
//
//    }
//
//    private void checkUser(String username, String password) {
//        Log.d(TAG, "Checking user: " + username);
//        DatabaseReference userRef = reference.child(username);
//        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//                    Log.d(TAG, "User exists in database");
//                    String passwordFromDB = dataSnapshot.child("password").getValue(String.class);
//                    if (Objects.equals(passwordFromDB, password)) {
//                        Log.d(TAG, "Password matches");
//                        Intent intent = new Intent(MainActivity2.this, Homepage.class);
//                        startActivity(intent);
//                        finish();
//                    } else {
//                        Log.d(TAG, "Password does not match");
//                        Toast.makeText(MainActivity2.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Log.d(TAG, "User does not exist in database");
//                    showCreateUserDialog(username, password);
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.d(TAG, "Database error: " + databaseError.getMessage());
//                Toast.makeText(MainActivity2.this, "Database error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    private void showCreateUserDialog(String username, String password) {
//        new AlertDialog.Builder(this)
//                .setTitle("User not found")
//                .setMessage("User not found. Do you want to create a new account?")
//                .setPositiveButton("Create", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        createUser(username, password);
//                    }
//                })
//                .setNegativeButton("Cancel", null)
//                .show();
//    }
//
//    private void createUser(String username, String password) {
//        Map<String, String> userData = new HashMap<>();
//        userData.put("username", username);
//        userData.put("password", password);
//
//        reference.child(username).setValue(userData).addOnCompleteListener(task -> {
//            if (task.isSuccessful()) {
//                Toast.makeText(MainActivity2.this, "User created successfully", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity2.this, Homepage.class);
//                startActivity(intent);
//                finish();
//            } else {
//                Toast.makeText(MainActivity2.this, "Failed to create user", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}
