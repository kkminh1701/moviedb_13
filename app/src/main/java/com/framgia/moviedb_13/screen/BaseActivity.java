package com.framgia.moviedb_13.screen;

import android.support.v7.app.AppCompatActivity;
import com.framgia.moviedb_13.data.repository.MovieRepository;
import com.framgia.moviedb_13.data.source.remote.MovieRemoteDataSource;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
    }

    public MovieRepository getMovieRepository() {
        return MovieRepository.getInstance(MovieRemoteDataSource.getInstance());
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
