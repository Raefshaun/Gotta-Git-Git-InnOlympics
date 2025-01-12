package com.example.hackathon;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_homepage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Your Feed"));
        tabLayout.addTab(tabLayout.newTab().setText("Your Listing"));
        ViewPager view = findViewById(R.id.viewPager);
        tabLayout.setTabTextColors(ColorStateList.valueOf(getColor(R.color.black)));

        final HomepageAdapter homepageAdapter = new HomepageAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        view.setAdapter(homepageAdapter);

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

        ImageView transactions = findViewById(R.id.wallet);
        transactions.setOnClickListener(v -> {
            startActivity(new Intent(Homepage.this, TransactionsActivity.class));
            this.overridePendingTransition(0, 0);
        });

        ImageView settings = findViewById(R.id.settings);
        settings.setOnClickListener(v -> {
            startActivity(new Intent(Homepage.this, SettingsActivity.class));
            this.overridePendingTransition(0, 0);
        });

    }
}