package com.hconve.findroom.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hconve.findroom.R;
import com.hconve.findroom.data.models.FindTrending;
import com.hconve.findroom.data.models.Room;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<ArrayList<FindTrending>> mFindTrendingList;
    private MutableLiveData<ArrayList<Room>> mRoomList;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

        mFindTrendingList = new MutableLiveData<>();
        ArrayList<FindTrending> items = new ArrayList<>();
        items.add(new FindTrending(R.color.colorPrimary, "Quận 1"));
        items.add(new FindTrending(R.color.colorPrimaryDark, "Quận 2"));
        items.add(new FindTrending(R.color.colorAccent, "Quận 3"));
        items.add(new FindTrending(R.color.colorPrimary, "Quận 4"));
        items.add(new FindTrending(R.color.colorPrimaryDark, "Quận 5"));
        items.add(new FindTrending(R.color.colorAccent, "Quận 6"));
        items.add(new FindTrending(R.color.colorPrimary, "Quận 7"));
        items.add(new FindTrending(R.color.colorPrimaryDark, "Quận 8"));
        items.add(new FindTrending(R.color.colorAccent, "Quận 9"));
        items.add(new FindTrending(R.color.colorPrimary, "Quận 10"));
        mFindTrendingList.setValue(items);

        mRoomList = new MutableLiveData<>();
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(R.color.colorPrimary));
        rooms.add(new Room(R.color.colorPrimaryDark));
        rooms.add(new Room(R.color.colorAccent));
        rooms.add(new Room(R.color.colorPrimary));
        rooms.add(new Room(R.color.colorPrimaryDark));
        rooms.add(new Room(R.color.colorAccent));
        mRoomList.setValue(rooms);
    }

    public MutableLiveData<String> getText() {
        return mText;
    }

    public MutableLiveData<ArrayList<FindTrending>> getFindTrendingList() {
        return mFindTrendingList;
    }

    public MutableLiveData<ArrayList<Room>> getRoomList() {
        return mRoomList;
    }
}