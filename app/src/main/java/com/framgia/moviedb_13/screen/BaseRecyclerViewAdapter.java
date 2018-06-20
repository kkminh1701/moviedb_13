package com.framgia.moviedb_13.screen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

public abstract class BaseRecyclerViewAdapter<V extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<V> {

    private Context mContext;

    public BaseRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }
}
