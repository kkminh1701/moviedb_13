package com.framgia.moviedb_13.data.repository;

import com.framgia.moviedb_13.data.source.RemoteMovieSource;
import com.framgia.moviedb_13.data.source.RequestDataCallBack;
import com.framgia.moviedb_13.data.source.remote.MovieRemoteDataSource;

public class MovieRepository implements RemoteMovieSource {
    private static MovieRepository sInstance;
    private MovieRemoteDataSource mMovieRemoteDataSource;

    private MovieRepository(MovieRemoteDataSource movieRemoteDataSource) {
        mMovieRemoteDataSource = movieRemoteDataSource;
    }

    public static synchronized MovieRepository getInstance(
            MovieRemoteDataSource movieRemoteDataSource) {
        if (sInstance == null) {
            sInstance = new MovieRepository(movieRemoteDataSource);
        }
        return sInstance;
    }

    @Override
    public void getMoviesByCategories(String categories, String language, int page,
            RequestDataCallBack callback) {
        mMovieRemoteDataSource.getMoviesByCategories(categories, language, page, callback);
    }

    @Override
    public void getMoviesByUrl(String id, String url, RequestDataCallBack callback) {
        mMovieRemoteDataSource.getMoviesByUrl(id, url, callback);
    }
}
