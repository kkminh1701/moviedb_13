package com.framgia.moviedb_13.data.repository;

import com.framgia.moviedb_13.data.source.RemoteGenreSource;
import com.framgia.moviedb_13.data.source.RequestDataCallBack;
import com.framgia.moviedb_13.data.source.remote.GenreRemoteDataSource;

public class GenreRepository implements RemoteGenreSource {
    private static GenreRepository sInstance;
    private GenreRemoteDataSource mGenreRemoteDataSource;

    private GenreRepository(GenreRemoteDataSource genreRemoteDataSource) {
        mGenreRemoteDataSource = genreRemoteDataSource;
    }

    public static synchronized GenreRepository getsInstance(
            GenreRemoteDataSource genreRemoteDataSource) {
        if (sInstance == null) {
            sInstance = new GenreRepository(genreRemoteDataSource);
        }
        return sInstance;
    }

    @Override
    public void loadGenres(RequestDataCallBack callback) {
        mGenreRemoteDataSource.loadGenres(callback);
    }
}
