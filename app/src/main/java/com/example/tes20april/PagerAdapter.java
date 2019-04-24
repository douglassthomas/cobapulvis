package com.example.tes20april;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> listFragment = new ArrayList<>();

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    void addFragment(Fragment f){
        listFragment.add(f);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }


}
