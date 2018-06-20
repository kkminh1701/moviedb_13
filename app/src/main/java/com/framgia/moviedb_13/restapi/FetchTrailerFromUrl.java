package com.framgia.moviedb_13.restapi;

import android.os.AsyncTask;
import android.util.Log;
import com.framgia.moviedb_13.data.model.Trailer;
import com.framgia.moviedb_13.data.source.RequestDataCallBack;
import java.io.IOException;
import java.util.List;
import org.json.JSONException;

public class FetchTrailerFromUrl extends AsyncTask<String, Void, List<Trailer>> {

    private final String LOG_TAG = FetchTrailerFromUrl.class.getSimpleName();

    private RequestApi mInstance;

    public RequestApi getInstance() {
        if (mInstance == null) {
            mInstance = new RequestApi();
        }
        return mInstance;
    }

    private RequestDataCallBack mCallBack;

    public FetchTrailerFromUrl(RequestDataCallBack callBack) {
        mCallBack = callBack;
    }

    @Override
    protected List<Trailer> doInBackground(String... strings) {
        try {
            return mInstance.parseJsonToTrailer(mInstance.getJsonStringFromUrl(strings[0]));
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error ", e);
        } catch (JSONException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Trailer> trailers) {
        if (mCallBack == null) {
            return;
        }
        if (trailers == null || trailers.size() == 0) {
            mCallBack.onFail();
        } else {
            mCallBack.onSuccess(trailers);
        }
    }
}
