package com.example.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        // Initialize views
        ImageView imageView = findViewById(R.id.settingsback);
        TextView rewardsTextView = findViewById(R.id.rewardsbt);  // Correctly initialize rewardsTextView

        // Set the onClickListener for the back button (imageView)
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this, Homepage.class);
                startActivity(intent);
            }
        });

        // Set an OnClickListener to the rewards TextView
        rewardsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to navigate to RewardsActivity
                Intent intent = new Intent(SettingsActivity.this, Rewards.class);
                startActivity(intent); // Start the activity
            }
        });

        rewardsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent to navigate to RewardsActivity
                Intent intent = new Intent(SettingsActivity.this, ProfileActivity.class);
                startActivity(intent); // Start the activity
            }
        });
    }
}


