package com.framgia.moviedb_13.data.source;

import java.util.List;

public interface RequestDataCallBack<T> {
    void onSuccess(List<T> data);

    void onFail();
}
