package com.framgia.moviedb_13.data.source.remote;

import com.framgia.moviedb_13.data.source.RemoteGenreSource;
import com.framgia.moviedb_13.data.source.RequestDataCallBack;
import com.framgia.moviedb_13.util.Constant;
import com.framgia.moviedb_13.util.FetchGenreFromUrl;

public class GenreRemoteDataSource implements RemoteGenreSource {
    private GenreRemoteDataSource mInstance;

    public GenreRemoteDataSource() {
    }

    public GenreRemoteDataSource getInstance() {
        if (mInstance == null) {
            mInstance = new GenreRemoteDataSource();
        }
        return mInstance;
    }

    @Override
    public void loadGenres(RequestDataCallBack callback) {
        new FetchGenreFromUrl(callback).execute(Constant.RequestUrl.API_GENRES_REQUEST);
    }
}
