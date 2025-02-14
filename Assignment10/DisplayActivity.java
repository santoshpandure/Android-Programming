package com.example.assignment10;
// DisplayActivity.java
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        TextView displayTextView = findViewById(R.id.displayTextView);

        String playerName = getIntent().getStringExtra("PLAYER_NAME");
        String playerPoints = getIntent().getStringExtra("PLAYER_POINTS");

        displayTextView.setText("Player: " + playerName + "\nPoints: " + playerPoints);
    }
}


