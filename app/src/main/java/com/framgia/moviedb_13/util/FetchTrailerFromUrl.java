package com.framgia.moviedb_13.util;

import android.os.AsyncTask;
import com.framgia.moviedb_13.data.model.Trailer;
import com.framgia.moviedb_13.data.source.RequestDataCallBack;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;

public class FetchTrailerFromUrl extends AsyncTask<String, Void, List<Trailer>> {

    private RequestAPI mInstance;

    public RequestAPI getmInstance(){
        if (mInstance == null){
            mInstance = new RequestAPI();
        }
        return mInstance;
    }

    private RequestDataCallBack mCallBack;

    public FetchTrailerFromUrl(RequestDataCallBack callBack) {
        mCallBack = callBack;
    }

    @Override
    protected List<Trailer> doInBackground(String... strings) {
        try{
            return mInstance.parseJsonToTrailer(mInstance.getJsonStringFromUrl(strings[0]));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } return null;
    }

    @Override
    protected void onPostExecute(List<Trailer> trailers) {
        if(mCallBack == null) {
            return;
        }
        if(trailers == null || trailers.size() == 0){
            mCallBack.onFail();
        }else {
            mCallBack.onSuccess(trailers);
        }
    }
}
