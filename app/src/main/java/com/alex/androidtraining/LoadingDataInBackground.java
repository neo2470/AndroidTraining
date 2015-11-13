package com.alex.androidtraining;

import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

/**
 * Created by alex on 15-11-9.
 */
public class LoadingDataInBackground extends BaseActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_data_in_background);

        mListView = (ListView) findViewById(R.id.listView);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private ListView mListView;
}
