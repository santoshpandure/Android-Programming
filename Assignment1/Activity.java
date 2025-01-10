//Assignment No.1 Java Android Program to demonstrate login form with validation.
package com.example.helloworld;

import android.os.Bundle; // Importing necessary classes for Android
import android.text.TextUtils; // For checking if text fields are empty
import android.view.View; // For handling button click events
import android.widget.Button; // Button class to create buttons
import android.widget.EditText; // EditText class to create input fields
import android.widget.Toast; // Toast class to display messages to the user

import androidx.appcompat.app.AppCompatActivity; // Base class for activities that use modern Android features

public class MainActivity extends AppCompatActivity {

    // Declare variables for UI elements
    private EditText usernameField;
    private EditText passwordField;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Call the parent class's onCreate method
        setContentView(R.layout.activity_main); // Set the layout file for the activity

        // Initialize UI elements by finding them in the layout
        usernameField = findViewById(R.id.editTextUsername); // Input field for username
        passwordField = findViewById(R.id.editTextPassword); // Input field for password
        loginButton = findViewById(R.id.buttonLogin); // Button to initiate login

        // Set an OnClickListener to handle button click events
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin(); // Call method to handle login logic
            }
        });
    }

    // Method to handle login logic
    private void handleLogin() {
        // Get text entered by the user in the username and password fields
        String username = usernameField.getText().toString().trim();
        String password = passwordField.getText().toString().trim();

        // Check if username field is empty
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Please enter your username", Toast.LENGTH_SHORT).show(); // Show error message
            return; // Stop further execution
        }

        // Check if password field is empty
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show(); // Show error message
            return; // Stop further execution
        }

        // Validate the username and password (hardcoded for demonstration purposes)
        if (username.equals("admin") && password.equals("1234")) {
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show(); // Show success message
        } else {
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show(); // Show error message
        }
    }
}

