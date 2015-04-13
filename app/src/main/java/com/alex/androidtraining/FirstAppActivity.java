package com.alex.androidtraining;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by alex on 15-4-13.
 * Getting Started / Building Your First App
 */
public class FirstAppActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_app);
        changeTitle();
    }

    public void sendMessage(View view) {
        EditText msg = (EditText) findViewById(R.id.msg);
        Intent intent = new Intent(this,DisplayMessageActivity.class);
        intent.putExtra(EXTRA_MESSAGE, msg.getText().toString().trim());
        startActivity(intent);
    }

    public final static String EXTRA_MESSAGE = "com.alex.androidtraining.MESSAGE";
}
