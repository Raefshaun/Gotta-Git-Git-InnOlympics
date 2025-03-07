package com.example.hackathon;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class TransactionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_transactions);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView home = findViewById(R.id.home);
        home.setOnClickListener(v -> {
            startActivity(new Intent(TransactionsActivity.this, Homepage.class));
            this.overridePendingTransition(0, 0);

        });

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager view = findViewById(R.id.pager);

        final TransactionsAdapter transactionsAdapter = new TransactionsAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        view.setAdapter(transactionsAdapter);

        view.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                view.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        ImageView settings = findViewById(R.id.settings);
        settings.setOnClickListener(v -> {
            startActivity(new Intent(TransactionsActivity.this, SettingsActivity.class));
            this.overridePendingTransition(0, 0);
        });
    }
}