package com.alex.androidtraining;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by alex on 15-4-16.
 */
public class DialogActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("An Activity in style of dialog");
        textView.setTextSize(20);
        setContentView(textView);
    }
}
