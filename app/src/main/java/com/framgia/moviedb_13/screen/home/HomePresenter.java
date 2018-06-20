package com.framgia.moviedb_13.screen.home;

import com.framgia.moviedb_13.data.model.Movie;
import com.framgia.moviedb_13.data.repository.GenreRepository;
import com.framgia.moviedb_13.data.repository.MovieRepository;
import com.framgia.moviedb_13.data.source.RequestDataCallBack;
import com.framgia.moviedb_13.data.source.remote.GenreRemoteDataSource;
import com.framgia.moviedb_13.util.Constant;
import java.util.List;

public class HomePresenter implements HomeContract.Presenter {
    private HomeContract.View mView;
    private MovieRepository mMovieRepository;
    private GenreRepository mGenreRepository;
    private String mUrlMovie;

    public HomePresenter(MovieRepository movieRepository) {
        mMovieRepository = movieRepository;
        mGenreRepository = GenreRepository.getsInstance(GenreRemoteDataSource.getInstance());
    }

    @Override
    public void loadCategoryMovies(final int typeMovie, int page) {
        onCheckUrlMovie(typeMovie);
        mMovieRepository.getMoviesByCategories(mUrlMovie, Constant.API_URL_LANGUAGE, page,
                new RequestDataCallBack<Movie>() {

                    @Override
                    public void onSuccess(List<Movie> movies) {
                        mView.onGetMoviesSuccess(movies, typeMovie);
                    }

                    @Override
                    public void onFail() {
                        mView.onGetMoviesFail(typeMovie);
                    }
                });
    }

    private void onCheckUrlMovie(int typeMovie) {
        if (typeMovie == Constant.TypeMovie.POPULAR_MOVIE) {
            mUrlMovie = Constant.TypeUrl.API_URL_MOVIE_POPULAR;
        } else if (typeMovie == Constant.TypeMovie.NOW_PLAYING_MOVIE) {
            mUrlMovie = Constant.TypeUrl.API_URL_MOVIE_NOW_PLAYING;
        } else if (typeMovie == Constant.TypeMovie.UP_COMING_MOVIE) {
            mUrlMovie = Constant.TypeUrl.API_URL_MOVIE_UPCOMING;
        } else if (typeMovie == Constant.TypeMovie.TOP_RATE_MOVIE) {
            mUrlMovie = Constant.TypeUrl.API_URL_MOVIE_TOP_RATED;
        }
    }

    @Override
    public void setView(HomeContract.View view) {
        mView = view;
    }
}
