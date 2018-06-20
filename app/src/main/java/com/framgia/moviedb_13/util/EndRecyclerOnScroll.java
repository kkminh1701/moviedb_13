package com.framgia.moviedb_13.util;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class EndRecyclerOnScroll extends RecyclerView.OnScrollListener {
    private boolean mLoading;
    private LoadMoreMovies mCallback;

    public EndRecyclerOnScroll(LoadMoreMovies callback) {
        mCallback = callback;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int visibleItemCount = recyclerView.getChildCount();
        int totalItemCount = recyclerView.getLayoutManager().getItemCount();
        int firstVisibleItemPosition =
                ((LinearLayoutManager) recyclerView.getLayoutManager())
                        .findFirstVisibleItemPosition();
        if ((firstVisibleItemPosition + visibleItemCount) == totalItemCount) {
            mLoading = true;
            mCallback.loadMoreMovies();
        }
    }

    public void setLoadingStatus(boolean status) {
        mLoading = status;
    }

    public interface LoadMoreMovies {
        void loadMoreMovies();
    }
}
