package com.example.hackathon;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HomepageAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public HomepageAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new home();
            case 1:
                return new listing();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Your Feed";
            case 1:
                return "Your Listings";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
