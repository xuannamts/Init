package com.hconve.findroom.ui.main;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.hconve.findroom.R;
import com.hconve.findroom.ui.BaseActivity;
import com.hconve.findroom.ui.room.post.PostRoomInformationFragment;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    public MainViewPagerAdapter mViewPagerAdapter;

    // UI
    private FrameLayout containerLayout;
    private BottomNavigationView bottomView;
    private FloatingActionButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindingUI();
        initViews();
    }

    private void initViews() {
        setupBottomView();
        setupAddButton();
    }

    private void setupBottomView() {
        bottomView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int size = bottomView.getMenu().size();
                for (int i = 0; i < size; i++) {
                    if (i == 2) continue;
                    if (bottomView.getMenu().getItem(i) == item) {
                        int offset = (i >= 3) ? 1 : 0;
                        replaceFragment(R.id.containerLayout,
                                mViewPagerAdapter.getItem(i - offset));
                        break;
                    }
                }
                return true;
            }
        });

        int itemId = bottomView.getMenu().getItem(DEFAULT_TAB.getValue()).getItemId();
        bottomView.setSelectedItemId(itemId);
    }

    private void setupAddButton() {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostRoomInformationFragment bottomSheet = PostRoomInformationFragment.newInstance();
                bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
            }
        });
    }

    private void bindingUI() {
        containerLayout = findViewById(R.id.containerLayout);
        bottomView = findViewById(R.id.bottomView);
        addButton = findViewById(R.id.addButton);
    }

    private static int PAGE_LIMIT = 3;
    private static MainTab DEFAULT_TAB = MainTab.TAB_HOME;
}
