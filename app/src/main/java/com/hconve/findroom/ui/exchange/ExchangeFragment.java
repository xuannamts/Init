package com.hconve.findroom.ui.exchange;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hconve.findroom.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExchangeFragment extends Fragment {

    public ExchangeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exchange, container, false);
    }

    public static ExchangeFragment newInstance() {
        return new ExchangeFragment();
    }
}
