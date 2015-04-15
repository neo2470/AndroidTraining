package com.alex.androidtraining;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by alex on 15-4-14.
 * Getting Started / Adding the Action Bar
 */
public class AddingActionBarActivity extends Activity implements CompoundButton.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_action_bar);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        Switch switchBtn = (Switch) findViewById(R.id.switchBtn);
        switchBtn.setOnCheckedChangeListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.adding_action_bar_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search :
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
                return  true;
            case R.id.settings :
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked) {
            getActionBar().show();
        } else {
            getActionBar().hide();
        }
    }
}
