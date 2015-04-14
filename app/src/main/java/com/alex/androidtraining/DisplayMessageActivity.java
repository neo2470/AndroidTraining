package com.alex.androidtraining;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by alex on 15-4-13.
 */
public class DisplayMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String msg = intent.getStringExtra(BuildingFirstAppActivity.EXTRA_MESSAGE);
        TextView tv = new TextView(this);
        tv.setTextSize(40);
        tv.setText(msg);

        setContentView(tv);
        getActionBar().setDisplayHomeAsUpEnabled(false);
    }
}
