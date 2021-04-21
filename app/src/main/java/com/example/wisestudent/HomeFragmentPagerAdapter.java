package com.example.wisestudent;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.wisestudent.ui.gallery.GalleryFragment;
import com.example.wisestudent.ui.home.HomeFragment;
import com.example.wisestudent.ui.slideshow.SlideshowFragment;

public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {


    public HomeFragmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return 4 ;
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return new HomeFragment();
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return new SlideshowFragment();
            case 2: // Fragment # 1 - This will show SecondFragment
                return new GalleryFragment();
            default:
                return null;
        }
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }

}

