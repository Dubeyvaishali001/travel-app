package com.example.voyageverse;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {
    private EditText usernameEditText, passwordEditText, confirmPasswordEditText;
    private Button createUserButton;

    private long lastClickTime = 0;
    private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        // Apply window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Find Username, Password, and Confirm Password EditText fields
        usernameEditText = findViewById(R.id.Username);
        passwordEditText = findViewById(R.id.Password);
        confirmPasswordEditText = findViewById(R.id.cnfpwd);
        createUserButton = findViewById(R.id.create_user);

        // Set OnTouchListener for Username EditText
        usernameEditText.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // Handle touch event for username EditText
                Toast.makeText(MainActivity3.this, "Username touched", Toast.LENGTH_SHORT).show();
            }
            return false; // Return false to allow other touch events to be handled
        });

        // Set OnTouchListener for Password EditText
        passwordEditText.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // Handle touch event for password EditText
                Toast.makeText(MainActivity3.this, "Password touched", Toast.LENGTH_SHORT).show();
            }
            return false; // Return false to allow other touch events to be handled
        });

        // Set OnTouchListener for Confirm Password EditText
        confirmPasswordEditText.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                // Handle touch event for confirm password EditText
                Toast.makeText(MainActivity3.this, "Confirm Password touched", Toast.LENGTH_SHORT).show();
            }
            return false; // Return false to allow other touch events to be handled
        });

        // Set OnClickListener for create_user button
        createUserButton.setOnClickListener(view -> {
            long clickTime = System.currentTimeMillis();
            if (clickTime - lastClickTime < 500) {
                // Double click detected
                Toast.makeText(MainActivity3.this, "Create User button double-clicked", Toast.LENGTH_SHORT).show();
            } else {
                lastClickTime = clickTime;
                registerUser();
            }
        });
    }

    private void registerUser() {
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("users");

        String username = usernameEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();
        String confirmPassword = confirmPasswordEditText.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(confirmPassword)) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        Helper user = new Helper(username, password, confirmPassword);
        reference.child(username).setValue(user).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(MainActivity3.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                // Clear the input fields
                usernameEditText.setText("");
                passwordEditText.setText("");
                confirmPasswordEditText.setText("");
            } else {
                Toast.makeText(MainActivity3.this, "Failed to register user", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
