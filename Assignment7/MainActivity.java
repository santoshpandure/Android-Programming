//Construct an app to display the image on date wise.
package com.example.datewiseimages;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        // Get today's date as a number (e.g., 1 for the 1st, 2 for the 2nd, etc.)
        int dayOfMonth = getCurrentDay();

        // Select the corresponding image
        int imageResource = getImageForDate(dayOfMonth);

        // Set the image in ImageView
        imageView.setImageResource(imageResource);
    }

    // Function to get the current day of the month
    private int getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    // Function to get an image based on the day
    private int getImageForDate(int day) {
        switch (day) {
            case 1: return R.drawable.image_01;
            case 2: return R.drawable.image_02;
            case 3: return R.drawable.image_03;
            case 4: return R.drawable.image_04;
            case 5: return R.drawable.image_05;
            default: return R.drawable.default_image; // Default image if no match
        }
    }
}
