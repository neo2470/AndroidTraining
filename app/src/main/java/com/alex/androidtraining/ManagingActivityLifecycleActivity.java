package com.alex.androidtraining;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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
        lifeCycle = (TextView) findViewById(R.id.lifeCycle);
        stringBuilder = new StringBuilder();
        stringBuilder.append("1.onCreate()");
        lifeCycle.setText(stringBuilder.toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        stringBuilder.append("\n2.onStart()");
        lifeCycle.setText(stringBuilder.toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        stringBuilder.append("\n3.onRestoreInstanceState()");
        lifeCycle.setText(stringBuilder.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        stringBuilder.append("\n4.onResume()");
        lifeCycle.setText(stringBuilder.toString());
    }

    @Override
    protected void onPause() {
        super.onPause();
        stringBuilder.append("\n5.onPause()");
        lifeCycle.setText(stringBuilder.toString());
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(this, "6.onSaveInstanceState()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "7.onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "8.onDestroy()", Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.alertDialog:
                new AlertDialog.Builder(this)
                        .setMessage("An Alert Dialog")
                        .setCancelable(true)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
                break;
            case R.id.startActivity:
                Intent intent = new Intent(this, DialogActivity.class);
                startActivity(intent);
                break;
        }
    }

    private StringBuilder stringBuilder;
    private TextView lifeCycle;
}
