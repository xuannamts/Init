package com.hconve.findroom.ui.home.popupsearch;

import com.hconve.findroom.data.models.AreaSearchOption;
import com.hconve.findroom.data.models.DistrictSearchOption;
import com.hconve.findroom.data.models.PriceSearchOption;
import com.hconve.findroom.data.models.WardSearchOption;
import com.hconve.findroom.data.repositories.SearchOptionRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PopupSearchPresenter implements PopupSearchContract.Presenter {

    private PopupSearchContract.View view;
    private SearchOptionRepository searchOptionRepository;

    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    @Inject
    public PopupSearchPresenter(PopupSearchContract.View view, SearchOptionRepository searchOptionRepository) {
        this.view = view;
        this.searchOptionRepository = searchOptionRepository;
    }

    @Override
    public void getDistrictSearchOptions(int provinceId) {
        Disposable disposable = searchOptionRepository.getDistrictSearchOptions(provinceId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ArrayList<DistrictSearchOption>>() {
                    @Override
                    public void accept(ArrayList<DistrictSearchOption> districts) throws Exception {
                        view.onGetDistrictSearchOptionsSuccess(districts);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.onGetError(throwable.getMessage());
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void getWardSearchOptions(int districtId) {
        Disposable disposable = searchOptionRepository.getWardSearchOptions(districtId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ArrayList<WardSearchOption>>() {
                    @Override
                    public void accept(ArrayList<WardSearchOption> wards) throws Exception {
                        view.onGetWardSearchOptionsSuccess(wards);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.onGetError(throwable.getMessage());
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void getAreaSearchOptions() {
        Disposable disposable = searchOptionRepository.getAreaSearchOptions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ArrayList<AreaSearchOption>>() {
                    @Override
                    public void accept(ArrayList<AreaSearchOption> options) throws Exception {
                        view.onGetAreaSearchOptionsSuccess(options);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.onGetError(throwable.getMessage());
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void getPriceSearchOptions() {
        Disposable disposable = searchOptionRepository.getPriceSearchOptions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ArrayList<PriceSearchOption>>() {
                    @Override
                    public void accept(ArrayList<PriceSearchOption> options) throws Exception {
                        view.onGetPriceSearchOptionsSuccess(options);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        view.onGetError(throwable.getMessage());
                    }
                });
        mCompositeDisposable.add(disposable);
    }

    @Override
    public void onStart() {
        // No-op
    }

    @Override
    public void onDestroy() {
        mCompositeDisposable.clear();
    }
}
