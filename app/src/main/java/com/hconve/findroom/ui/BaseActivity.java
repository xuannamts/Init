package com.hconve.findroom.ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity {
    public void replaceFragment(int layoutId, Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(layoutId, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
