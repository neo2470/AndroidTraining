package com.alex.androidtraining;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by alex on 15-6-29.
 */
public class SavingDataActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saving_data);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.writePref:
                writeSharedPreference();
                break;
            case R.id.readPref:
                readSharedPreference();
                break;
        }
    }

    private void writeSharedPreference() {

        EditText editText = (EditText) findViewById(R.id.inputValue);
        String value = editText.getText().toString().trim();

        SharedPreferences prefs = getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY, value);
        editor.apply();
    }

    private void readSharedPreference() {
        SharedPreferences prefs = getSharedPreferences(PREFS_FILE_NAME, Context.MODE_PRIVATE);
        String value = prefs.getString(KEY, "null");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
    }

    private static final String KEY = "com.alex.androidtraining.TEST_KEY";
    private static final String PREFS_FILE_NAME = "com.alex.androidtraining.";
}
