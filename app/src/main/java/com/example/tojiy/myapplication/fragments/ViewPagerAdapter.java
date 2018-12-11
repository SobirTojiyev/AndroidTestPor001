package com.example.tojiy.myapplication.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<String> tabItems = new ArrayList<>();


    public void addFragments(Fragment fragment, String titles) {

        this.fragments.add(fragment);
        this.tabItems.add(titles);

    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }




    @Override
    public int getCount() {
        return fragments.size();
    }

    public CharSequence getPageTitle(int position){
        return tabItems.get(position);
    }
}
