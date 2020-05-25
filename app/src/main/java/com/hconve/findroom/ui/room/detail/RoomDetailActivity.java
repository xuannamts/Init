package com.hconve.findroom.ui.room.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.hconve.findroom.R;

public class RoomDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);
    }

    public static Intent getInstance(Context context) {
        return new Intent(context, RoomDetailActivity.class);
    }
}
