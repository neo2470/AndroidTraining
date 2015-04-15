package com.alex.androidtraining;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

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

        Toast.makeText(this, "SDK VERSION: " + Build.VERSION.SDK_INT, Toast.LENGTH_SHORT).show();
    }
}
