package com.alex.androidtraining;

import android.os.Bundle;

/**
 * Created by alex on 15-4-15.
 * Getting Started / Managing the Activity Lifecycle
 */
public class ManagingActivityLifecycleActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managing_activity_lifecycle);
        changeTitle();
    }
}
