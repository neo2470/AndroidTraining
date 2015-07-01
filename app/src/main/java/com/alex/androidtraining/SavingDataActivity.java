package com.alex.androidtraining;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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
            case R.id.writeInternalStorage:
                writeString2InternalStorage();
                break;
            case R.id.readInternalStorage:
                readStringFromInternalStorage();
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

    private void writeString2InternalStorage() {
        EditText editText = (EditText) findViewById(R.id.fileInternalValue);
        String value = editText.getText().toString().trim();

        FileOutputStream outputStream = null;
        try {
            outputStream = openFileOutput(INTERNAL_FILE_NAME, Context.MODE_PRIVATE);
            outputStream.write(value.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (null != outputStream) {
                    outputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readStringFromInternalStorage() {
        FileInputStream inputStream = null;
        StringBuilder builder = new StringBuilder();
        try {
            inputStream = openFileInput(INTERNAL_FILE_NAME);

            // TODO read string form internal storage
            BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while (null != (line=buffer.readLine())) {
                builder.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != inputStream) {

                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Toast.makeText(this,builder.toString(), Toast.LENGTH_SHORT).show();
    }


    private static final String KEY = "com.alex.androidtraining.TEST_KEY";
    private static final String PREFS_FILE_NAME = "com.alex.androidtraining.";
    private static final String INTERNAL_FILE_NAME = "internal_test_file";
}
