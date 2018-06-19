package com.framgia.moviedb_13.data.source;

public interface RemoteMovieSource {
    void getMoviesByCategories(String categories, String language, int page,
            RequestDataCallBack callback);

    void getMoviesByUrl(String id, String url, RequestDataCallBack callback);
}
