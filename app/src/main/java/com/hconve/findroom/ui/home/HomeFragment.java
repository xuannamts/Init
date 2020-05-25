package com.hconve.findroom.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.hconve.findroom.R;
import com.hconve.findroom.data.models.FindTrending;
import com.hconve.findroom.data.models.Room;
import com.hconve.findroom.ui.home.popupsearch.PopupSearchFragment;
import com.hconve.findroom.ui.home.recyclerview.item.FindTrendingListItem;
import com.hconve.findroom.ui.home.recyclerview.item.RoomItem;
import com.hconve.findroom.widgets.recyclerview.CustomRecyclerView;
import com.hconve.findroom.widgets.recyclerview.item.TitleItem;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private HomeAdapter homeAdapter;

    private ViewPager slidingImageViewPager;
    private CircleIndicator circleIndicator;
    private RecyclerView homeRecyclerView;
    private View searchView;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindingUI(view);
        initViews();
    }

    private void bindingUI(View view) {
        slidingImageViewPager = view.findViewById(R.id.slidingImageViewPager);
        circleIndicator = view.findViewById(R.id.circleIndicator);
        homeRecyclerView = view.findViewById(R.id.homeRecyclerView);
        searchView = view.findViewById(R.id.searchView);
    }

    private void initViews() {
        initBanner();
        initRecyclerView();
        initSearchView();
    }

    private void initBanner() {
        SlidingImageViewPagerAdapter adapter = new SlidingImageViewPagerAdapter(getContext());
        // Fake data
        adapter.addImage(R.color.colorPrimary);
        adapter.addImage(R.color.colorPrimaryDark);
        adapter.addImage(R.color.colorAccent);

        slidingImageViewPager.setAdapter(adapter);
        circleIndicator.setViewPager(slidingImageViewPager);
    }

    private void initRecyclerView() {
        final ArrayList<CustomRecyclerView.Item> items = new ArrayList<>();
        items.add(new TitleItem(getContext().getString(R.string.find_trending)));
        items.add(new FindTrendingListItem(new ArrayList<FindTrending>()));
        items.add(new TitleItem(getContext().getString(R.string.list_of_rooms)));
        homeAdapter = new HomeAdapter(items);

        homeRecyclerView.setAdapter(homeAdapter);
        homeRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        homeViewModel.getFindTrendingList().observe(getViewLifecycleOwner(), new Observer<ArrayList<FindTrending>>() {
            @Override
            public void onChanged(ArrayList<FindTrending> items) {
                homeAdapter.updateFindTrendingList(items);
            }
        });
        homeViewModel.getRoomList().observe(getViewLifecycleOwner(), new Observer<ArrayList<Room>>() {
            @Override
            public void onChanged(ArrayList<Room> rooms) {
                ArrayList<RoomItem> roomItems = new ArrayList<>();
                for (Room room : rooms) roomItems.add(new RoomItem(room));
                items.addAll(roomItems);
                homeAdapter.notifyItemRangeChanged(items.size() - rooms.size(), rooms.size());
            }
        });
    }

    private void initSearchView() {
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupSearchFragment.newInstance()
                        .show(getChildFragmentManager(), PopupSearchFragment.TAG);
            }
        });
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
}
