package com.alex.androidtraining;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by alex on 15-11-6.
 */
public class PullService extends IntentService {

    public PullService() {
        super("PullService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String content = getWebContent(intent.getStringExtra("url"), null, "utf-8");
        Intent intent1 = new Intent(Constants.BROADCAST_ACTION);
        intent1.putExtra("content", content);

        LocalBroadcastManager.getInstance(this).sendBroadcast(intent1);
    }


    public final class Constants {
        public static final String BROADCAST_ACTION = "com.alex.androidtraining.BROADCAST";
        public static final String EXTENDED_DATA_STATUS = "com.alex.androidtraining.STATUS";
    }

    private String getWebContent(String webUrl, HashMap<String, String> header, String charset) {
        HttpURLConnection urlConnection = null;
        StringBuilder builder = new StringBuilder();
        try {
            URL url = new URL(webUrl);
            urlConnection = (HttpURLConnection) url.openConnection();

            if(null != header) {
                for(String key : header.keySet()) {
                    urlConnection.setRequestProperty(key, header.get(key));
                }
            }

            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, charset));

            String line;
            while (null != (line=bufferedReader.readLine())) {
                builder.append(line);
            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(null != urlConnection) {
                urlConnection.disconnect();
            }
        }
        return builder.toString();
    }
}
