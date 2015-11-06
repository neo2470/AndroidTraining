package com.alex.androidtraining;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.TextView;

/**
 * Created by alex on 15-11-6.
 */
public class RunningInBackgroundService extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.running_in_background_service);

        mText = (TextView) findViewById(R.id.content);

        IntentFilter intentFilter = new IntentFilter(PullService.Constants.BROADCAST_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(new ResponseReceiver(), intentFilter);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, PullService.class);
        intent.putExtra("url", "https://www.baidu.com/");
        startService(intent);
    }

    private class ResponseReceiver extends BroadcastReceiver {

        private ResponseReceiver() {
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            mText.setText(intent.getStringExtra("content"));
        }
    }

    private TextView mText;
}
