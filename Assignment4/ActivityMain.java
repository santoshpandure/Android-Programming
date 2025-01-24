//Create an Android application which examine, that a phone number, which a user has entered is
//in the given format. * Area code should be one of the following: 040, 041, 050, 0400, 044 *
//There should 6- 8 numbers in telephone number (+ area code).

package com.example.phonenumbervalidator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        EditText phoneNumberInput = findViewById(R.id.editTextPhoneNumber);
        Button validateButton = findViewById(R.id.buttonValidate);
        TextView resultView = findViewById(R.id.textViewResult);

        // Set a click listener for the validate button
        validateButton.setOnClickListener(view -> {
            // Get the input phone number as a string
            String phoneNumber = phoneNumberInput.getText().toString();

            // Validate the phone number and display the result
            if (isValidPhoneNumber(phoneNumber)) {
                resultView.setText("Valid phone number");
            } else {
                resultView.setText("Invalid phone number");
            }
        });
    }

    /**
     * Validates if the given phone number matches the required format.
     *
     * @param phoneNumber The phone number entered by the user.
     * @return True if the phone number is valid, otherwise false.
     */
    private boolean isValidPhoneNumber(String phoneNumber) {
        // Define valid area codes
        String[] validAreaCodes = {"040", "041", "050", "0400", "044"};

        // Check if the phone number starts with a valid area code
        boolean validAreaCode = false;
        for (String areaCode : validAreaCodes) {
            if (phoneNumber.startsWith(areaCode)) {
                validAreaCode = true;
                break;
            }
        }

        // If the area code is not valid, return false
        if (!validAreaCode) {
            return false;
        }

        // Extract the rest of the phone number by removing the area code
        for (String areaCode : validAreaCodes) {
            if (phoneNumber.startsWith(areaCode)) {
                phoneNumber = phoneNumber.substring(areaCode.length());
                break;
            }
        }

        // Check if the remaining part has 6-8 digits
        return phoneNumber.matches("\\d{6,8}");
    }
}
