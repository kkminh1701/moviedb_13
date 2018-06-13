package com.framgia.moviedb_13.util;

import android.os.AsyncTask;
import com.framgia.moviedb_13.data.model.Genre;
import com.framgia.moviedb_13.data.source.RequestDataCallBack;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;

public class FetchGenreFromUrl extends AsyncTask<String, Void, List<Genre>>{

    private RequestAPI mInstance;

    public RequestAPI getmInstance(){
        if(mInstance == null){
            mInstance = new RequestAPI();
        }
        return mInstance;
    }

    private RequestDataCallBack mCallBack;

    public FetchGenreFromUrl(RequestDataCallBack callback) {
        mCallBack = callback;
    }

    @Override
    protected List<Genre> doInBackground(String... strings) {
        try{
            return mInstance.parseJsonToGenre(mInstance.getJsonStringFromUrl(strings[0]));
        }catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Genre> genres) {
        if (mCallBack == null) {
            return;
        }
        if (genres == null){
            mCallBack.onFail();
        }else {
            mCallBack.onSuccess(genres);
        }
    }
}
