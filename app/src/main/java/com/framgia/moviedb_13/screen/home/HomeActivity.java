package com.framgia.moviedb_13.screen.home;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.framgia.moviedb_13.R;
import com.framgia.moviedb_13.data.model.Movie;
import com.framgia.moviedb_13.screen.BaseActivity;
import com.framgia.moviedb_13.util.Constant;
import com.framgia.moviedb_13.util.EndRecyclerOnScroll;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity implements HomeContract.View {
    private HomeContract.Presenter mPresenter;

    private int mPageMovie = 1;

    private HomeAdapter mPopularMoviesAdapter;
    private HomeAdapter mNowPlayingMoviesAdapter;
    private HomeAdapter mUpComingMoviesAdapter;
    private HomeAdapter mTopRateMoviesAdapter;

    private ProgressBar mProgressBarPopular;
    private ProgressBar mProgressBarNowPlaying;
    private ProgressBar mProgressBarUpComing;
    private ProgressBar mProgressBarTopRate;

    private EndRecyclerOnScroll mPopularOnScrollListener;
    private EndRecyclerOnScroll mNowPlayingOnScrollListener;
    private EndRecyclerOnScroll mUpcomingOnScrollListener;
    private EndRecyclerOnScroll mTopRateOnScrollListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mPresenter = new HomePresenter(getMovieRepository());
        mPresenter.setView(this);
        initMoviesAdapters();
        loadMoviesOnScreen();
    }

    private void loadMoviesOnScreen() {
        ArrayList listType = new ArrayList();
        listType.add(Constant.TypeMovie.POPULAR_MOVIE);
        listType.add(Constant.TypeMovie.NOW_PLAYING_MOVIE);
        listType.add(Constant.TypeMovie.UP_COMING_MOVIE);
        listType.add(Constant.TypeMovie.TOP_RATE_MOVIE);
        for (int i = 0; i <= listType.size(); i++) {
            initLayout(i);
            loadMovies(i);
        }
    }

    private void initMoviesAdapters() {
        mPopularMoviesAdapter = new HomeAdapter(this);
        mNowPlayingMoviesAdapter = new HomeAdapter(this);
        mUpComingMoviesAdapter = new HomeAdapter(this);
        mTopRateMoviesAdapter = new HomeAdapter(this);
    }

    private void initLayoutPopular(final int type) {
        View include = findViewById(R.id.include_popular);
        TextView textView = include.findViewById(R.id.text_title_recycler_view);
        textView.setText(R.string.title_popular);
        mProgressBarPopular = include.findViewById(R.id.progressbar_recycler_view);
        mProgressBarPopular.setVisibility(View.VISIBLE);
        RecyclerView recyclerView = include.findViewById(R.id.recycler_view_movies);
        recyclerView.setAdapter(mPopularMoviesAdapter);
        mPopularOnScrollListener =
                new EndRecyclerOnScroll(new EndRecyclerOnScroll.LoadMoreMovies() {
                    @Override
                    public void loadMoreMovies() {
                        mPresenter.loadCategoryMovies(type, mPageMovie);
                        mProgressBarPopular.setVisibility(View.VISIBLE);
                    }
                });
        recyclerView.addOnScrollListener(mPopularOnScrollListener);
    }

    private void initLayoutNowPlaying(final int type) {
        View include = findViewById(R.id.include_now_playing);
        TextView textView = include.findViewById(R.id.text_title_recycler_view);
        textView.setText(R.string.title_now_playing);
        mProgressBarNowPlaying = include.findViewById(R.id.progressbar_recycler_view);
        mProgressBarNowPlaying.setVisibility(View.VISIBLE);
        RecyclerView recyclerView = include.findViewById(R.id.recycler_view_movies);
        recyclerView.setAdapter(mNowPlayingMoviesAdapter);
        mNowPlayingOnScrollListener =
                new EndRecyclerOnScroll(new EndRecyclerOnScroll.LoadMoreMovies() {
                    @Override
                    public void loadMoreMovies() {
                        mPresenter.loadCategoryMovies(type, mPageMovie);
                        mProgressBarNowPlaying.setVisibility(View.VISIBLE);
                    }
                });
        recyclerView.addOnScrollListener(mNowPlayingOnScrollListener);
    }

    private void initLayoutUpComing(final int type) {
        View include = findViewById(R.id.include_upcoming);
        TextView textView = include.findViewById(R.id.text_title_recycler_view);
        textView.setText(R.string.title_upcoming);
        mProgressBarUpComing = include.findViewById(R.id.progressbar_recycler_view);
        mProgressBarUpComing.setVisibility(View.VISIBLE);
        RecyclerView recyclerView = include.findViewById(R.id.recycler_view_movies);
        recyclerView.setAdapter(mUpComingMoviesAdapter);
        mUpcomingOnScrollListener =
                new EndRecyclerOnScroll(new EndRecyclerOnScroll.LoadMoreMovies() {
                    @Override
                    public void loadMoreMovies() {
                        mPresenter.loadCategoryMovies(type, mPageMovie);
                        mProgressBarUpComing.setVisibility(View.VISIBLE);
                    }
                });
        recyclerView.addOnScrollListener(mUpcomingOnScrollListener);
    }

    private void initLayoutTopRate(final int type) {
        View include = findViewById(R.id.include_top_rate);
        TextView textView = include.findViewById(R.id.text_title_recycler_view);
        textView.setText(R.string.title_top_rate);
        mProgressBarTopRate = include.findViewById(R.id.progressbar_recycler_view);
        mProgressBarTopRate.setVisibility(View.VISIBLE);
        RecyclerView recyclerView = include.findViewById(R.id.recycler_view_movies);
        recyclerView.setAdapter(mTopRateMoviesAdapter);
        mTopRateOnScrollListener =
                new EndRecyclerOnScroll(new EndRecyclerOnScroll.LoadMoreMovies() {
                    @Override
                    public void loadMoreMovies() {
                        mPresenter.loadCategoryMovies(type, mPageMovie);
                        mProgressBarTopRate.setVisibility(View.VISIBLE);
                    }
                });
        recyclerView.addOnScrollListener(mTopRateOnScrollListener);
    }

    private void loadMovies(int type) {
        if (type == Constant.TypeMovie.POPULAR_MOVIE) {
            mPresenter.loadCategoryMovies(type, mPageMovie);
        }
        if (type == Constant.TypeMovie.NOW_PLAYING_MOVIE) {
            mPresenter.loadCategoryMovies(type, mPageMovie);
        }
        if (type == Constant.TypeMovie.UP_COMING_MOVIE) {
            mPresenter.loadCategoryMovies(type, mPageMovie);
        }
        if (type == Constant.TypeMovie.TOP_RATE_MOVIE) {
            mPresenter.loadCategoryMovies(type, mPageMovie);
        }
    }

    @Override
    public void onGetMoviesSuccess(List<Movie> movies, int typeMovie) {
        if (typeMovie == Constant.TypeMovie.POPULAR_MOVIE) {
            mProgressBarPopular.setVisibility(View.GONE);
            mPopularMoviesAdapter.updateData(movies);
            mPageMovie++;
        }
        if (typeMovie == Constant.TypeMovie.NOW_PLAYING_MOVIE) {
            mProgressBarNowPlaying.setVisibility(View.GONE);
            mNowPlayingMoviesAdapter.updateData(movies);
            mPageMovie++;
        }
        if (typeMovie == Constant.TypeMovie.UP_COMING_MOVIE) {
            mProgressBarUpComing.setVisibility(View.GONE);
            mUpComingMoviesAdapter.updateData(movies);
            mPageMovie++;
        }
        if (typeMovie == Constant.TypeMovie.TOP_RATE_MOVIE) {
            mProgressBarTopRate.setVisibility(View.GONE);
            mTopRateMoviesAdapter.updateData(movies);
            mPageMovie++;
        }
    }

    @Override
    public void onGetMoviesFail(int typeMovie) {
        if (typeMovie == Constant.TypeMovie.POPULAR_MOVIE) {
            mPopularOnScrollListener.setLoadingStatus(false);
        }
        if (typeMovie == Constant.TypeMovie.NOW_PLAYING_MOVIE) {
            mNowPlayingOnScrollListener.setLoadingStatus(false);
        }
        if (typeMovie == Constant.TypeMovie.NOW_PLAYING_MOVIE) {
            mUpcomingOnScrollListener.setLoadingStatus(false);
        }
        if (typeMovie == Constant.TypeMovie.NOW_PLAYING_MOVIE) {
            mTopRateOnScrollListener.setLoadingStatus(false);
        }
    }

    private void initLayout(final int typeMovie) {
        if (typeMovie == Constant.TypeMovie.POPULAR_MOVIE) {
            initLayoutPopular(typeMovie);
        } else if (typeMovie == Constant.TypeMovie.NOW_PLAYING_MOVIE) {
            initLayoutNowPlaying(typeMovie);
        } else if (typeMovie == Constant.TypeMovie.UP_COMING_MOVIE) {
            initLayoutUpComing(typeMovie);
        } else if (typeMovie == Constant.TypeMovie.TOP_RATE_MOVIE) {
            initLayoutTopRate(typeMovie);
        }
    }
}
