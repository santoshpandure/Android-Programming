//Construct image switcher using setFactory().
package com.example.imageswicher;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private int[] images = {R.drawable.image_01, R.drawable.image_02, R.drawable.image_03};
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        Button btnNext = findViewById(R.id.btnNext);

        // Next Button Click
        btnNext.setOnClickListener(v -> {
            currentIndex = (currentIndex + 1) % images.length;
            imageView.setImageResource(images[currentIndex]);
        });
    }
}
