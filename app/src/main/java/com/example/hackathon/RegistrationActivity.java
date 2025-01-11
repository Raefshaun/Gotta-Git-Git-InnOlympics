package com.example.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistrationActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

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

        mAuth = FirebaseAuth.getInstance();mAuth = FirebaseAuth.getInstance();

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

        mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        finish();
                    }
                    else {
                        Intent intent = new Intent(this, Homepage.class);
                    }
                });
    }
}