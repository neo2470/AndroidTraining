package com.alex.androidtraining;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * Created by alex on 15-7-9.
 */
public class InteractingWithOtherApp extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interacting_with_other_app);
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.phoneCall :
                Uri number = Uri.parse("tel:13632915937");
                Intent call = new Intent(Intent.ACTION_DIAL, number);
                startActivity(call);
                break;
            case R.id.surfInternet :
                Uri url = Uri.parse("http://www.baidu.com/");
                Intent internet = new Intent(Intent.ACTION_VIEW, url);
                startActivity(internet);
                break;
        }

    }
}
