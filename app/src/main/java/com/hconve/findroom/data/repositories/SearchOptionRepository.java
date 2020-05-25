package com.hconve.findroom.data.repositories;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hconve.findroom.R;
import com.hconve.findroom.data.models.AreaSearchOption;
import com.hconve.findroom.data.models.DistrictSearchOption;
import com.hconve.findroom.data.models.PriceSearchOption;
import com.hconve.findroom.data.models.ProvinceSearchOption;
import com.hconve.findroom.data.models.WardSearchOption;
import com.hconve.findroom.utils.ResourceUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public interface SearchOptionRepository {

    Single<ArrayList<ProvinceSearchOption>> getProvinceSearchOptions();

    Single<ArrayList<DistrictSearchOption>> getDistrictSearchOptions(int provinceId);

    Single<ArrayList<WardSearchOption>> getWardSearchOptions(int districtId);

    Single<ArrayList<AreaSearchOption>> getAreaSearchOptions();

    Single<ArrayList<PriceSearchOption>> getPriceSearchOptions();

    class SearchOptionRepositoryImpl implements SearchOptionRepository {

        Context context;
        Gson gson;

        ArrayList<DistrictSearchOption> districtListCache = null;
        ArrayList<WardSearchOption> wardListCache = null;

        @Inject
        public SearchOptionRepositoryImpl(Context context) {
            this.context = context;
            this.gson = new Gson();
        }

        @Override
        public Single<ArrayList<ProvinceSearchOption>> getProvinceSearchOptions() {
            return Single.create(new SingleOnSubscribe<ArrayList<ProvinceSearchOption>>() {
                @Override
                public void subscribe(SingleEmitter<ArrayList<ProvinceSearchOption>> emitter) throws Exception {
                    emitter.onSuccess(new ArrayList<ProvinceSearchOption>() {{
                        add(new ProvinceSearchOption(1, "Hà Nội", "HN"));
                        add(new ProvinceSearchOption(48, "Đà Nẵng", "DN"));
                        add(new ProvinceSearchOption(79, "Hồ Chí Minh", "HCM"));
                    }});
                }
            });
        }

        @Override
        public Single<ArrayList<DistrictSearchOption>> getDistrictSearchOptions(final int provinceId) {
            return Single.create(new SingleOnSubscribe<ArrayList<DistrictSearchOption>>() {
                @Override
                public void subscribe(SingleEmitter<ArrayList<DistrictSearchOption>> emitter) throws Exception {
                    ArrayList<DistrictSearchOption> districts;
                    if (districtListCache != null) {
                        districts = districtListCache;
                    } else {
                        try {
                            String text = ResourceUtils.readAllText(context, R.raw.district);
                            districts = gson.fromJson(text, new TypeToken<ArrayList<DistrictSearchOption>>() {
                            }.getType());
                        } catch (Exception e) {
                            emitter.onError(e);
                            return;
                        }
                    }
                    ArrayList<DistrictSearchOption> result = new ArrayList<>();
                    for (DistrictSearchOption district : districts) {
                        if (district.provinceId == provinceId) {
                            result.add(district);
                        }
                    }
                    emitter.onSuccess(result);
                }
            });
        }

        @Override
        public Single<ArrayList<WardSearchOption>> getWardSearchOptions(final int districtId) {
            return Single.create(new SingleOnSubscribe<ArrayList<WardSearchOption>>() {
                @Override
                public void subscribe(SingleEmitter<ArrayList<WardSearchOption>> emitter) throws Exception {
                    ArrayList<WardSearchOption> wards;
                    if (wardListCache != null) {
                        wards = wardListCache;
                    } else {
                        try {
                            String text = ResourceUtils.readAllText(context, R.raw.ward);
                            wards = gson.fromJson(text, new TypeToken<ArrayList<WardSearchOption>>() {
                            }.getType());
                        } catch (Exception e) {
                            emitter.onError(e);
                            return;
                        }
                    }
                    ArrayList<WardSearchOption> result = new ArrayList<>();
                    for (WardSearchOption ward : wards) {
                        if (ward.districtId == districtId) {
                            result.add(ward);
                        }
                    }
                    emitter.onSuccess(result);
                }
            });
        }

        @Override
        public Single<ArrayList<AreaSearchOption>> getAreaSearchOptions() {
            return Single.create(new SingleOnSubscribe<ArrayList<AreaSearchOption>>() {
                @Override
                public void subscribe(SingleEmitter<ArrayList<AreaSearchOption>> emitter) throws Exception {
                    ArrayList<AreaSearchOption> options = new ArrayList<>();
                    options.add(new AreaSearchOption(0, 20));
                    options.add(new AreaSearchOption(20, 40));
                    options.add(new AreaSearchOption(40, 60));
                    options.add(new AreaSearchOption(60, -1));
                    emitter.onSuccess(options);
                }
            });
        }

        @Override
        public Single<ArrayList<PriceSearchOption>> getPriceSearchOptions() {
            return Single.create(new SingleOnSubscribe<ArrayList<PriceSearchOption>>() {
                @Override
                public void subscribe(SingleEmitter<ArrayList<PriceSearchOption>> emitter) throws Exception {
                    ArrayList<PriceSearchOption> options = new ArrayList<>();
                    options.add(new PriceSearchOption(0, 1000000));
                    options.add(new PriceSearchOption(1000000, 2000000));
                    options.add(new PriceSearchOption(2000000, 4000000));
                    options.add(new PriceSearchOption(4000000, -1));
                    emitter.onSuccess(options);

                }
            });
        }
    }
}
