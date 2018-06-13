package com.framgia.moviedb_13.util;

import android.os.AsyncTask;
import com.framgia.moviedb_13.data.model.Movie;
import com.framgia.moviedb_13.data.source.RequestDataCallBack;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;

public class FetchMovieFromUrl extends AsyncTask<String, Void, List<Movie>> {

    private RequestAPI mInstance;

    public RequestAPI getmInstance(){
        if(mInstance == null){
            mInstance = new RequestAPI();
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
            return mInstance.parseJsonToMovie(mInstance.getJsonStringFromUrl(strings[0]));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Movie> movies) {
        if (mCallBack == null){
            return;
        }
        if (movies == null || movies.size() == 0) {
            mCallBack.onFail();
        } else {
            mCallBack.onSuccess(movies);
        }
    }
}
