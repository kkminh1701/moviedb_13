package com.framgia.moviedb_13.restapi;

import android.os.AsyncTask;
import android.util.Log;
import com.framgia.moviedb_13.data.model.Production;
import com.framgia.moviedb_13.data.source.RequestDataCallBack;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;

public class FetchProductionFromUrl extends AsyncTask<String, Void, List<Production>> {

    private final String LOG_TAG = FetchProductionFromUrl.class.getSimpleName();

    private RequestApi mInstance;

    public RequestApi getInstance() {
        if (mInstance == null) {
            mInstance = new RequestApi();
        }
        return mInstance;
    }

    private RequestDataCallBack mCallBack;

    public FetchProductionFromUrl(RequestDataCallBack callBack) {
        mCallBack = callBack;
    }

    @Override
    protected List<Production> doInBackground(String... strings) {
        try {
            return mInstance.parseJsonToProductions(mInstance.getJsonStringFromUrl(strings[0]));
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error ", e);
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Production> productions) {
        if (mCallBack == null) {
            return;
        }
        if (productions == null) {
            mCallBack.onFail();
        } else {
            mCallBack.onSuccess(productions);
        }
    }
}
