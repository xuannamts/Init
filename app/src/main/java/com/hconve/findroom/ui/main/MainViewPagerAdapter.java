package com.hconve.findroom.ui.main;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private Fragment mCurrentFragment = null;
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    public MainViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        mCurrentFragment = (Fragment) object;
        super.setPrimaryItem(container, position, object);
    }

    public void addFragment(Fragment fragment) {
        mFragments.add(fragment);
    }
}
