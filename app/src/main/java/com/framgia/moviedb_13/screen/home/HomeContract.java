package com.framgia.moviedb_13.screen.home;

import com.framgia.moviedb_13.data.model.Movie;
import com.framgia.moviedb_13.screen.BasePresenter;
import java.util.List;

public interface HomeContract {

    interface View {

        void onGetMoviesSuccess(List<Movie> movies, int typeMovie);

        void onGetMoviesFail(int typeMovie);
    }

    interface Presenter extends BasePresenter<View> {

        void loadCategoryMovies(int typeMovie, int page);
    }
}
