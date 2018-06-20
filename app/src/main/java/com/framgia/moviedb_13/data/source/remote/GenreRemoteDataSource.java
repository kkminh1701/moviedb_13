package com.framgia.moviedb_13.data.source.remote;

import com.framgia.moviedb_13.data.source.RemoteGenreSource;
import com.framgia.moviedb_13.data.source.RequestDataCallBack;
import com.framgia.moviedb_13.util.Constant;
import com.framgia.moviedb_13.restapi.FetchGenreFromUrl;

public class GenreRemoteDataSource implements RemoteGenreSource {
    private static GenreRemoteDataSource sInstance;

    private GenreRemoteDataSource() {
    }

    public static GenreRemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new GenreRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void loadGenres(RequestDataCallBack callback) {
        new FetchGenreFromUrl(callback).execute(Constant.RequestUrl.API_GENRES_REQUEST);
    }
}
