package com.framgia.moviedb_13.restapi;

import android.os.AsyncTask;
import android.util.Log;
import com.framgia.moviedb_13.data.model.Genre;
import com.framgia.moviedb_13.data.source.RequestDataCallBack;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;

public class FetchGenreFromUrl extends AsyncTask<String, Void, List<Genre>> {

    private final String LOG_TAG = FetchGenreFromUrl.class.getSimpleName();

    private RequestApi mInstance;

    public RequestApi getInstance() {
        if (mInstance == null) {
            mInstance = new RequestApi();
        }
        return mInstance;
    }

    private RequestDataCallBack mCallBack;

    public FetchGenreFromUrl(RequestDataCallBack callback) {
        mCallBack = callback;
    }

    @Override
    protected List<Genre> doInBackground(String... strings) {
        try {
            return getInstance().parseJsonToGenre(getInstance().getJsonStringFromUrl(strings[0]));
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error ", e);
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Genre> genres) {
        if (mCallBack == null) {
            return;
        }
        if (genres == null) {
            mCallBack.onFail();
        } else {
            mCallBack.onSuccess(genres);
        }
    }
}
