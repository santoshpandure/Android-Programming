package com.example.myapplication;

import android.os.Bundle; // Import necessary classes for Android app development
import android.text.TextUtils; // For checking if input fields are empty
import android.view.View; // For handling view events
import android.widget.Button; // Button class to create buttons
import android.widget.EditText; // EditText class to create input fields
import android.widget.TextView; // TextView class to display results
import android.widget.Toast; // Toast class to show messages to the user

import androidx.appcompat.app.AppCompatActivity; // Base class for modern activities

public class MainActivity extends AppCompatActivity {

    // Declare UI elements
    private EditText number1Field;
    private EditText number2Field;
    private Button addButton;
    private Button subtractButton;
    private Button multiplyButton;
    private Button divideButton;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Call the parent class's onCreate method
        setContentView(R.layout.activity_main); // Set the layout for the activity

        // Initialize UI elements
        number1Field = findViewById(R.id.editTextNumber1); // Input field for first number
        number2Field = findViewById(R.id.editTextNumber2); // Input field for second number
        addButton = findViewById(R.id.buttonAdd); // Button for addition operation
        subtractButton = findViewById(R.id.buttonSubtract); // Button for subtraction operation
        multiplyButton = findViewById(R.id.buttonMultiply); // Button for multiplication operation
        divideButton = findViewById(R.id.buttonDivide); // Button for division operation
        resultView = findViewById(R.id.textViewResult); // TextView to display the result

        // Set click listeners for buttons
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("add"); // Call method to perform addition
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("subtract"); // Call method to perform subtraction
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("multiply"); // Call method to perform multiplication
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("divide"); // Call method to perform division
            }
        });
    }

    // Method to perform the selected operation
    private void performOperation(String operation) {
        // Get text from input fields
        String num1Text = number1Field.getText().toString().trim();
        String num2Text = number2Field.getText().toString().trim();

        // Check if inputs are empty
        if (TextUtils.isEmpty(num1Text) || TextUtils.isEmpty(num2Text)) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show(); // Show error message
            return; // Stop further execution
        }

        // Parse inputs to double
        double num1 = Double.parseDouble(num1Text);
        double num2 = Double.parseDouble(num2Text);
        double result = 0;

        // Perform the appropriate operation based on user selection
        switch (operation) {
            case "add":
                result = num1 + num2; // Add the numbers
                break;
            case "subtract":
                result = num1 - num2; // Subtract the numbers
                break;
            case "multiply":
                result = num1 * num2; // Multiply the numbers
                break;
            case "divide":
                if (num2 != 0) {
                    result = num1 / num2; // Divide the numbers
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show(); // Show error message
                    return; // Stop further execution
                }
                break;
        }

        // Display the result
        resultView.setText("Result: " + result);
    }
}
