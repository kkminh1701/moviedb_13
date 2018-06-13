package com.framgia.moviedb_13.util;

import android.os.AsyncTask;
import com.framgia.moviedb_13.data.model.Production;
import com.framgia.moviedb_13.data.source.RequestDataCallBack;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;

public class FetchProductionFromUrl extends AsyncTask<String,Void, List<Production>> {

    private RequestAPI mInstance;

    public RequestAPI getmInstance(){
        if(mInstance == null){
            mInstance = new RequestAPI();
        }
        return mInstance;
    }

    private RequestDataCallBack mCallBack;

    public FetchProductionFromUrl(RequestDataCallBack callBack) {
        mCallBack = callBack;
    }

    @Override
    protected List<Production> doInBackground(String... strings) {
        try{
            return mInstance.parseJsonToProductions(mInstance.getJsonStringFromUrl(strings[0]));
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } return null;
    }

    @Override
    protected void onPostExecute(List<Production> productions) {
        if(mCallBack == null) {
            return;
        }
        if(productions == null){
            mCallBack.onFail();
        }else {
            mCallBack.onSuccess(productions);
        }
    }
}
