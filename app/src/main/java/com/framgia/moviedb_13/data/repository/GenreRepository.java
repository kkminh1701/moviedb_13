package com.framgia.moviedb_13.data.repository;

import com.framgia.moviedb_13.data.source.RemoteGenreSource;
import com.framgia.moviedb_13.data.source.RequestDataCallBack;
import com.framgia.moviedb_13.data.source.remote.GenreRemoteDataSource;

public class GenreRepository implements RemoteGenreSource {
    private GenreRepository mInstance;
    private GenreRemoteDataSource mGenreRemoteDataSource;

    public GenreRepository(GenreRemoteDataSource genreRemoteDataSource) {
        mGenreRemoteDataSource = genreRemoteDataSource;
    }

    public GenreRepository getsInstance(GenreRemoteDataSource genreRemoteDataSource) {
        if (mInstance == null) {
            mInstance = new GenreRepository(genreRemoteDataSource);
        }
        return mInstance;
    }

    @Override
    public void loadGenres(RequestDataCallBack callback) {
        mGenreRemoteDataSource.loadGenres(callback);
    }
}
