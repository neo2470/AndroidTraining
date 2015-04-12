package com.alex.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alex.androidtraining.R;

/**
 * Created by alex on 15-4-11.
 * As ths APP's TitleBar
 */

public class TitleBar extends RelativeLayout {

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_bar, this);

        // TODO handle element in the TitleBar
    }

    public void setTitle(String text) {
        TextView title = (TextView) findViewById(R.id.title);
        title.setText(text);
    }
}
