package com.alex.androidtraining;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.alex.fragments.ArticleFragment;
import com.alex.fragments.HeadlinesFragment;

/**
 * Created by alex on 15-6-25.
 */
public class DynamicUIWithFragmentActivity extends FragmentActivity implements HeadlinesFragment.OnHeadlineSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_articles);

        if(null != findViewById(R.id.container)) {

            if(null != savedInstanceState) {
                return ;
            }

            HeadlinesFragment headlinesFragment = new HeadlinesFragment();
            headlinesFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, headlinesFragment)
                    .commit();
        }
    }

    @Override
    public void onSelected(int position) {

        ArticleFragment articleFragment = (ArticleFragment) getSupportFragmentManager().findFragmentById(R.id.article_fragment);

        if(null != articleFragment) {
            articleFragment.updateArticleView(position);
        } else {
            ArticleFragment newFragment = new ArticleFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ArticleFragment.ARG_POSITION, position);
            newFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, newFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
