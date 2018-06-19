package com.framgia.moviedb_13.data.repository;

import com.framgia.moviedb_13.data.source.RemoteMovieSource;
import com.framgia.moviedb_13.data.source.RequestDataCallBack;
import com.framgia.moviedb_13.data.source.remote.MovieRemoteDataSource;

public class MovieRepository implements RemoteMovieSource {
    private MovieRepository mInstance;
    private MovieRemoteDataSource mMovieRemoteDataSource;

    public MovieRepository(MovieRemoteDataSource movieRemoteDataSource) {
        mMovieRemoteDataSource = movieRemoteDataSource;
    }

    public MovieRepository getInstance(MovieRemoteDataSource movieRemoteDataSource) {
        if (mInstance == null) {
            mInstance = new MovieRepository(movieRemoteDataSource);
        }
        return mInstance;
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
