package com.example.viewpageapp;



import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

// Aqui se inicializan los fragmentos de los tabs
public class PagerAdapter extends FragmentPagerAdapter {
    private int numTabs;
    public PagerAdapter(FragmentManager fm, int numTabs){
        super(fm);
        this.numTabs = numTabs;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        System.out.println("Adapter Position: " + position);
        switch (position){
            case 0: return TabFragment.newInstance(0);
            case 1: return TabFragment.newInstance(1);
            case 2: return TabFragment.newInstance(2);
            case 3: return TabFragment.newInstance(3);
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
