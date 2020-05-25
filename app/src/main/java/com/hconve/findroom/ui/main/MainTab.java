package com.hconve.findroom.ui.main;

public enum MainTab {
    TAB_HOME(0), TAB_AROUND(1), TAB_EXCHANGE(3), TAB_ACCOUNT(4);

    private int value;

    MainTab(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }
}
