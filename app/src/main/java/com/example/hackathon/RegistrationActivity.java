package com.example.hackathon;

import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registration);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button backButton = findViewById(R.id.backButton);
        Button signUpButton = findViewById(R.id.signUpButton);

        backButton.setOnClickListener(v -> {
            finish();
        });

        signUpButton.setOnClickListener(v -> createAccount());
    }

    private void createAccount() {
        EditText email = findViewById(R.id.email), password = findViewById(R.id.password), confirmPassword = findViewById(R.id.confirmPassword);

        if (email.getText().toString().isEmpty() || password.getText().toString().isEmpty() || confirmPassword.getText().toString().isEmpty()) {
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            return;
        }

        if (password.getText().toString().length() < 8) {
            return;
        }

        if (!password.getText().toString().equals(confirmPassword.getText().toString())) {
            return;
        }

        Toast.makeText(this, "Create Account", Toast.LENGTH_SHORT).show();
    }
}