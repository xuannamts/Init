package com.hconve.findroom.ui.home.popupsearch;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hconve.findroom.R;
import com.hconve.findroom.data.models.AreaSearchOption;
import com.hconve.findroom.data.models.DistrictSearchOption;
import com.hconve.findroom.data.models.PriceSearchOption;
import com.hconve.findroom.data.models.WardSearchOption;
import com.hconve.findroom.ui.common.selectitemdialog.SelectItemFragment;
import com.hconve.findroom.widgets.loadingbutton.LoadingButton;
import com.hconve.findroom.widgets.textwithicon.TextWithIcon;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.android.support.DaggerDialogFragment;

public class PopupSearchFragment extends DaggerDialogFragment implements PopupSearchContract.View, SelectItemFragment.OnSelectItemListener {

    @Inject
    public PopupSearchContract.Presenter presenter;

    private ArrayList<DistrictSearchOption> mDistrictSearchOptions;
    private ArrayList<WardSearchOption> mWardSearchOptions;
    private ArrayList<AreaSearchOption> mAreaSearchOptions;
    private ArrayList<PriceSearchOption> mPriceSearchOptions;

    private int mDistrictSearchOptionIndex = -1;
    private int mWardSearchOptionIndex = -1;
    private int mAreaSearchOptionIndex = -1;
    private int mPriceSearchOptionIndex = -1;

    private LoadingButton searchLoadingButton;
    private TextWithIcon districtButton;
    private TextWithIcon wardButton;
    private TextWithIcon areaButton;
    private TextWithIcon priceButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        Window window = dialog.getWindow();
        if (window != null) window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popup_search, container, false);
        bindingUI(view);
        initViews();
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void onGetDistrictSearchOptionsSuccess(ArrayList<DistrictSearchOption> options) {
        mDistrictSearchOptions = options;
        goToSelectDistrict();
    }

    @Override
    public void onGetWardSearchOptionsSuccess(ArrayList<WardSearchOption> options) {
        mWardSearchOptions = options;
        goToSelectWard();
    }

    @Override
    public void onGetAreaSearchOptionsSuccess(ArrayList<AreaSearchOption> options) {
        mAreaSearchOptions = options;
        goToSelectArea();
    }

    @Override
    public void onGetPriceSearchOptionsSuccess(ArrayList<PriceSearchOption> options) {
        mPriceSearchOptions = options;
        goToSelectPrice();
    }

    @Override
    public void onGetError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSelectItem(String key, int selectedIndex) {
        if (key.equals(SELECT_DISTRICT_OPTION)) {
            mDistrictSearchOptionIndex = selectedIndex;
            districtButton.setText(mDistrictSearchOptions.get(selectedIndex).name);
        } else if (key.equals(SELECT_WARD_OPTION)) {
            mWardSearchOptionIndex = selectedIndex;
            wardButton.setText(mWardSearchOptions.get(selectedIndex).name);
        } else if (key.equals(SELECT_AREA_OPTION)) {
            mAreaSearchOptionIndex = selectedIndex;
            areaButton.setText(mAreaSearchOptions.get(selectedIndex).getDescription(getContext()));
        } else if (key.equals(SELECT_PRICE_OPTION)) {
            mPriceSearchOptionIndex = selectedIndex;
            priceButton.setText(mPriceSearchOptions.get(selectedIndex).getDescription(getContext()));
        }
    }

    private void goToSelectDistrict() {
        ArrayList<String> items = new ArrayList<>();
        for (DistrictSearchOption district : mDistrictSearchOptions) {
            items.add(district.name);
        }
        SelectItemFragment fragment = SelectItemFragment.newInstance(SELECT_DISTRICT_OPTION, items);
        fragment.setOnSelectItemListener(this);
        fragment.show(getChildFragmentManager(), SelectItemFragment.TAG);
    }

    private void goToSelectWard() {
        ArrayList<String> items = new ArrayList<>();
        for (WardSearchOption ward : mWardSearchOptions) {
            items.add(ward.name);
        }
        SelectItemFragment fragment = SelectItemFragment.newInstance(SELECT_WARD_OPTION, items);
        fragment.setOnSelectItemListener(this);
        fragment.show(getChildFragmentManager(), SelectItemFragment.TAG);
    }

    private void goToSelectArea() {
        ArrayList<String> items = new ArrayList<>();
        for (AreaSearchOption area : mAreaSearchOptions) {
            items.add(area.getDescription(getContext()));
        }
        SelectItemFragment fragment = SelectItemFragment.newInstance(SELECT_AREA_OPTION, items);
        fragment.setOnSelectItemListener(this);
        fragment.show(getChildFragmentManager(), SelectItemFragment.TAG);
    }

    private void goToSelectPrice() {
        ArrayList<String> items = new ArrayList<>();
        for (PriceSearchOption price : mPriceSearchOptions) {
            items.add(price.getDescription(getContext()));
        }
        SelectItemFragment fragment = SelectItemFragment.newInstance(SELECT_PRICE_OPTION, items);
        fragment.setOnSelectItemListener(this);
        fragment.show(getChildFragmentManager(), SelectItemFragment.TAG);
    }

    private void bindingUI(View view) {
        searchLoadingButton = view.findViewById(R.id.searchLoadingButton);
        districtButton = view.findViewById(R.id.districtButton);
        wardButton = view.findViewById(R.id.wardButton);
        areaButton = view.findViewById(R.id.areaButton);
        priceButton = view.findViewById(R.id.priceButton);
    }

    private void initViews() {
        initButtons();
        initSearchView();
    }

    private void initButtons() {
        districtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDistrictSearchOptions == null) {
                    presenter.getDistrictSearchOptions(79);
                } else {
                    goToSelectDistrict();
                }
            }
        });

        wardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDistrictSearchOptionIndex == -1) return;
                presenter.getWardSearchOptions(mDistrictSearchOptions.get(mDistrictSearchOptionIndex).id);
            }
        });

        areaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAreaSearchOptions == null) {
                    presenter.getAreaSearchOptions();
                } else {
                    goToSelectArea();
                }
            }
        });

        priceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPriceSearchOptions == null) {
                    presenter.getPriceSearchOptions();
                } else {
                    goToSelectPrice();
                }
            }
        });
    }

    private void initSearchView() {
        searchLoadingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchLoadingButton.showLoading();
            }
        });
    }

    public static String TAG = PopupSearchFragment.class.getName();
    private static String SELECT_DISTRICT_OPTION = "SELECT_DISTRICT_OPTION";
    private static String SELECT_WARD_OPTION = "SELECT_WARD_OPTION";
    private static String SELECT_AREA_OPTION = "SELECT_AREA_OPTION";
    private static String SELECT_PRICE_OPTION = "SELECT_PRICE_OPTION";

    public static PopupSearchFragment newInstance() {
        return new PopupSearchFragment();
    }
}
