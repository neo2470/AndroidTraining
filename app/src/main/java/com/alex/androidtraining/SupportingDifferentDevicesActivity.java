package com.alex.androidtraining;

import android.os.Bundle;

/**
 * Created by alex on 15-4-15.
 * Getting Started / Supporting Different Devices
 */
public class SupportingDifferentDevicesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supporting_different_deviecs);
        changeTitle();
    }
}
