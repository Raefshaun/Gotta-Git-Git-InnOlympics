package com.example.hackathon;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TransactionsAdapter extends FragmentPagerAdapter {
    private Context myContext;
    int totalTabs;

    public TransactionsAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new LentFragment();
            case 1:
                return new LentFragment();
            default:
                return new LentFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Lent";
            case 1:
                return "Borrowed";
            case 2:
                return "Paid";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
