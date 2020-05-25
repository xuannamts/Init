package com.hconve.findroom.ui.room.post;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.hconve.findroom.R;
import com.hconve.findroom.widgets.selectableicon.SelectableIcon;

/**
 * <p>A fragment that shows a list of items as a modal bottom sheet.</p>
 * <p>You can show this modal bottom sheet from your activity like this:</p>
 * <pre>
 *     ItemListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
 * </pre>
 */
public class PostRoomInformationFragment extends BottomSheetDialogFragment {
    FlexboxLayout convenientLayout;
    FlexboxLayout imageLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post_room_information, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        convenientLayout = view.findViewById(R.id.convenientLayout);

        convenientLayout.addView(new SelectableIcon(getContext(), R.drawable.ic_wifi));
        convenientLayout.addView(new SelectableIcon(getContext(), R.drawable.ic_directions_bike));
        convenientLayout.addView(new SelectableIcon(getContext(), R.drawable.ic_access_time));
        convenientLayout.addView(new SelectableIcon(getContext(), R.drawable.ic_air_conditioner));
        convenientLayout.addView(new SelectableIcon(getContext(), R.drawable.ic_refrigerator));

        imageLayout = view.findViewById(R.id.imageLayout);
        imageLayout.addView(new SelectableIcon(getContext(), R.color.colorPrimary));
        imageLayout.addView(new SelectableIcon(getContext(), R.color.colorPrimaryDark));
        imageLayout.addView(new SelectableIcon(getContext(), R.color.colorAccent));
    }

    public static PostRoomInformationFragment newInstance() {
        return new PostRoomInformationFragment();
    }
}
