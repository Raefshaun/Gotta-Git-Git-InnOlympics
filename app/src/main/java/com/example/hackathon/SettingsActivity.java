package com.example.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize views
        ImageView imageView = findViewById(R.id.settingsback); // Back button
        TextView profileSettings = findViewById(R.id.profile);
        TextView rewardsTextView = findViewById(R.id.rewardsbt); // Rewards button
        TextView notificationTextView = findViewById(R.id.notifications); // Notification button
        TextView privacyPolicyTrigger = findViewById(R.id.privacy); // Privacy policy button

        // Set onClickListener for the back button
        imageView.setOnClickListener(view -> {
            Intent intent = new Intent(SettingsActivity.this, Homepage.class);
            startActivity(intent);
        });

        // Set onClickListener for the rewards button
        profileSettings.setOnClickListener(view -> {
            Intent intent = new Intent(SettingsActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        rewardsTextView.setOnClickListener(view -> {
            Intent intent = new Intent(SettingsActivity.this, Rewards.class);
            startActivity(intent);
        });

        // Set onClickListener for the notification button
        notificationTextView.setOnClickListener(view -> {
            Intent intent = new Intent(SettingsActivity.this, NotificationActivity.class);
            startActivity(intent);
        });

        // Set onClickListener for the privacy policy button
        privacyPolicyTrigger.setOnClickListener(view -> showPrivacyPolicyDialog());
    }

    private void showPrivacyPolicyDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.privacypolicy, null);
        builder.setView(dialogView);

        AlertDialog dialog = builder.create();

        // Close button in privacy policy dialog
//        Button closeButton = dialogView.findViewById(R.id.closeButton);
//        closeButton.setOnClickListener(view -> dialog.dismiss());

        dialog.show();
    }
}