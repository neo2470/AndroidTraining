package com.alex.androidtraining;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

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
            case 5:
                act = DynamicUIWithFragmentActivity.class;
                break;
            case 6:
                act = SavingDataActivity.class;
                break;
            case 7:
                act = InteractingWithOtherApp.class;
                break;
            case 24:
                act = RunningInBackgroundService.class;
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

            "Getting Started",// 0
            "           Building Your First App",// 1
            "           Adding the Action Bar",// 2
            "           Supporting Different Devices",// 3
            "           Managing the Activity Lifecycle",// 4
            "           Building a Dynamic UI with Fragment",// 5
            "           Saving Data",// 6
            "           Interacting with Other Apps",// 7

            "Content Sharing",// 8
            "           Sharing Simple Data",// 9
            "           Sharing Files",// 10
            "           Sharing Files with NFC",// 11

            "Multimedia",// 12
            "           Managing Audio Playback",// 13
            "           Capturing Photos",// 14
            "           Printing Content",// 15

            "Graphic & Animation",// 16
            "           Displaying Bitmaps Efficiently",// 17
            "           Displaying Graphics with OpenGL ES",// 18
            "           Animating Views Using Scenes and Transitions",// 19
            "           Adding Animations",// 20

            "Connectivity & the Cloud",// 21

            "User info & Location",// 22

            "Best Practices for Background Jobs",// 23
            "           Running in a Background Service",// 24
            "           Loading data in the Background",// 25
            "           Managing Device Awake State",// 26
    };
}
