package com.example.bankapp;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private double balance = 1000.0;
    private TextView balanceTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        balanceTextView = findViewById(R.id.balanceTextView);
        Button withdrawButton = findViewById(R.id.withdrawButton);
        Button depositButton = findViewById(R.id.depositButton);
        Button checkBalanceButton = findViewById(R.id.checkBalanceButton);

        withdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                withdraw(100);
            }
        });

        depositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deposit(200);
            }
        });

        checkBalanceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBalance();
            }
        });
    }

    private void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            Toast.makeText(this, "Withdrawn: $" + amount, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Insufficient balance", Toast.LENGTH_SHORT).show();
        }
        checkBalance();
    }

    private void deposit(double amount) {
        balance += amount;
        Toast.makeText(this, "Deposited: $" + amount, Toast.LENGTH_SHORT).show();
        checkBalance();
    }

    private void checkBalance() {
        balanceTextView.setText("Balance: $" + balance);
    }
}
