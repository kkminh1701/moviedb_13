package com.framgia.moviedb_13.restapi;

import android.os.AsyncTask;
import android.util.Log;
import com.framgia.moviedb_13.data.model.Movie;
import com.framgia.moviedb_13.data.source.RequestDataCallBack;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;

public class FetchMovieFromUrl extends AsyncTask<String, Void, List<Movie>> {

    private final String LOG_TAG = FetchMovieFromUrl.class.getSimpleName();

    private RequestApi mInstance;

    public RequestApi getInstance() {
        if (mInstance == null) {
            mInstance = new RequestApi();
        }
        return mInstance;
    }

    private RequestDataCallBack mCallBack;

    public FetchMovieFromUrl(RequestDataCallBack callback) {
        mCallBack = callback;
    }

    @Override
    protected List<Movie> doInBackground(String... strings) {
        try {
            return getInstance().parseJsonToMovie(getInstance().getJsonStringFromUrl(strings[0]));
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error ", e);
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Movie> movies) {
        if (mCallBack == null) {
            return;
        }
        if (movies == null || movies.size() == 0) {
            mCallBack.onFail();
        } else {
            mCallBack.onSuccess(movies);
        }
    }
}
