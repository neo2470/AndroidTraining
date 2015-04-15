package com.alex.androidtraining;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(position);
            }
        });
    }

    private void startActivity(int id) {
        Class act = null;
        switch (id) {
            case 1:
                act = BuildingFirstAppActivity.class;
                break;
            case 2:
                act = AddingActionBarActivity.class;
                break;
            case 3:
                act = SupportingDifferentDevicesActivity.class;
                break;
            case 4:
                act = ManagingActivityLifecycleActivity.class;
                break;
        }

        if (null != act) {
            Intent intent = new Intent(this, act);
            intent.putExtra(TOPIC, data[id]);
            startActivity(intent);
        }
    }

    public final static String TOPIC = "com.alex.androidtraining.TOPIC";

    private final String[] data = {

            "Getting Started",
            "           Building Your First App",
            "           Adding the Action Bar",
            "           Supporting Different Devices",
            "           Managing the Activity Lifecycle",
            "           Building a Dynamic UI with Fragment",
            "           Saving Data",
            "           Interacting with Other Apps",

            "Content Sharing",
            "           Sharing Simple Data",
            "           Sharing Files",
            "           Sharing Files with NFC",

            "Multimedia",
            "           Managing Audio Playback",
            "           Capturing Photos",
            "           Printing Content",

            "Graphic & Animation",
            "           Displaying Bitmaps Efficiently",
            "           Displaying Graphics with OpenGL ES",
            "           Animating Views Using Scenes and Transitions",
            "           Adding Animations",

            "Connectivity & the Cloud",

            "User info & Location",
    };
}
