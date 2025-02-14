//Create an Android application, where the user can enter player name and points in one view and
//display it in another view.
package com.example.assignment10;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText playerNameEditText;
    private EditText playerPointsEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerNameEditText = findViewById(R.id.playerNameEditText);
        playerPointsEditText = findViewById(R.id.playerPointsEditText);
        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerName = playerNameEditText.getText().toString();
                String playerPoints = playerPointsEditText.getText().toString();

                Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                intent.putExtra("PLAYER_NAME", playerName);
                intent.putExtra("PLAYER_POINTS", playerPoints);
                startActivity(intent);
            }
        });
    }
}

