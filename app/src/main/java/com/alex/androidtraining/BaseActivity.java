package com.alex.androidtraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.alex.view.TitleBar;

/**
 * Created by alex on 15-4-12.
 * All of the activity classes in this app extend this activity.
 */
public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    protected void changeTitle() {
        Intent intent = getIntent();
        TitleBar titleBar = (TitleBar) findViewById(R.id.titleBar);
        titleBar.setTitle(intent.getStringExtra(MainActivity.TOPIC));
    }
}
