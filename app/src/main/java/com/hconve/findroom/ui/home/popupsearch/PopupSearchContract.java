package com.hconve.findroom.ui.home.popupsearch;

import com.hconve.findroom.data.models.AreaSearchOption;
import com.hconve.findroom.data.models.DistrictSearchOption;
import com.hconve.findroom.data.models.PriceSearchOption;
import com.hconve.findroom.data.models.WardSearchOption;
import com.hconve.findroom.ui.BasePresenter;

import java.util.ArrayList;

public interface PopupSearchContract {
    interface Presenter extends BasePresenter {
        void getDistrictSearchOptions(int provinceId);

        void getWardSearchOptions(int districtId);

        void getAreaSearchOptions();

        void getPriceSearchOptions();
    }

    interface View {
        void onGetDistrictSearchOptionsSuccess(ArrayList<DistrictSearchOption> options);

        void onGetWardSearchOptionsSuccess(ArrayList<WardSearchOption> options);

        void onGetAreaSearchOptionsSuccess(ArrayList<AreaSearchOption> options);

        void onGetPriceSearchOptionsSuccess(ArrayList<PriceSearchOption> options);

        void onGetError(String message);
    }
}
