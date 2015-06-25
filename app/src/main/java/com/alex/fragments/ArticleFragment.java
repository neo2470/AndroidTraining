package com.alex.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alex.androidtraining.R;

/**
 * Created by alex on 15-6-25.
 */
public class ArticleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.article_view, container, false);
        article = (TextView) view.findViewById(R.id.article);

        Bundle bundle = getArguments();

        int position = 0;
        if(null != bundle) {
            position = bundle.getInt(ARG_POSITION);
        }

        updateArticleView(position);

        return view;
    }

    public void updateArticleView(int position) {
        String[] data = getActivity().getResources().getStringArray(R.array.article_headlines);
        article.setText(data[position]);
    }

    public static final String ARG_POSITION = "position";
    private TextView article;
}
