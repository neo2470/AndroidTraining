package com.alex.androidtraining;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alex.entity.Contacts;
import com.alex.util.SQLiteHelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
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

        dbHelper = new SQLiteHelper(this);
        operation = (TextView) findViewById(R.id.operation);
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
            case R.id.writeExternalStorage:
                writeString2ExternalStorage();
                break;
            case R.id.readExternalStorage:
                readStringFromExternalStorage();
                break;
            case R.id.dbInsert:
                insertContacts();
                break;
            case R.id.dbDelete:
                ;
                break;
            case R.id.dbUpdate:
                ;
                break;
            case R.id.dbQuery:
                ;
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

    private void writeString2ExternalStorage() {
        EditText editText = (EditText) findViewById(R.id.fileExternalValue);
        String value = editText.getText().toString().trim();

        File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),EXTERNAL_FILE_NAME);

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(value.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != outputStream) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void readStringFromExternalStorage() {

        File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), EXTERNAL_FILE_NAME);
        FileInputStream inputStream = null;
        StringBuilder builder = new StringBuilder();

        try {
            inputStream = new FileInputStream(file);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while (null != (line=buffer.readLine())) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != inputStream) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Toast.makeText(this,builder.toString(), Toast.LENGTH_SHORT).show();
    }

    private void insertContacts() {
        EditText name = (EditText) findViewById(R.id.name);
        EditText age = (EditText) findViewById(R.id.age);
        final String nameValue = name.getText().toString().trim();
        final int ageValue = Integer.parseInt(age.getText().toString().trim());

        if("".equals(nameValue)) {
            Toast.makeText(this, "Name can not be null", Toast.LENGTH_SHORT).show();
            return;
        }

        new AsyncTask<Void, Void, Boolean>() {

            @Override
            protected Boolean doInBackground(Void... params) {

                SQLiteDatabase db = dbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(Contacts.Column.NAME, nameValue);
                values.put(Contacts.Column.AGE, ageValue);

                long flag = db.insert(Contacts.TABLE_NAME, null, values);

                return -1 != flag;
            }

            @Override
            protected void onPostExecute(Boolean flag) {
                super.onPostExecute(flag);

                if(flag) {
                    operation.setText("Insert Success");
                } else {
                    operation.setText("Insert Failure");
                }
            }
        }.execute();
        SQLiteDatabase db = dbHelper.getWritableDatabase();

    }


    private static final String KEY = "com.alex.androidtraining.TEST_KEY";
    private static final String PREFS_FILE_NAME = "com.alex.androidtraining.";
    private static final String INTERNAL_FILE_NAME = "internal_test_file";
    private static final String EXTERNAL_FILE_NAME = "external_test_file.txt";

    private SQLiteHelper dbHelper;
    private TextView operation;
}
