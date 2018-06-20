package com.framgia.moviedb_13.data.source.remote;

import com.framgia.moviedb_13.data.source.RemoteMovieSource;
import com.framgia.moviedb_13.data.source.RequestDataCallBack;
import com.framgia.moviedb_13.util.Constant;
import com.framgia.moviedb_13.restapi.FetchMovieFromUrl;

public class MovieRemoteDataSource implements RemoteMovieSource {
    private static MovieRemoteDataSource sInstance;

    private MovieRemoteDataSource() {
    }

    public static MovieRemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new MovieRemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getMoviesByCategories(String categories, String language, int page,
            RequestDataCallBack callback) {
        new FetchMovieFromUrl(callback).execute(
                String.format(Constant.RequestUrl.API_URL_REQUEST, categories, language, page));
    }

    @Override
    public void getMoviesByUrl(String id, String url, RequestDataCallBack callback) {
        new FetchMovieFromUrl(callback).execute(String.format(id, url));
    }
}
