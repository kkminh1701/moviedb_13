package com.framgia.moviedb_13.util;

import android.graphics.Bitmap;
import com.framgia.moviedb_13.BuildConfig;
import com.framgia.moviedb_13.R;

public class Constant {

    private static final String API_KEY = "api_key=" + BuildConfig.API_KEY;
    public static final int URL_REQUEST_TIMEOUT = 10000;
    public static final int URL_CONNECT_TIMEOUT = 15000;

    public static class RequestUrl {
        public static final String API_REQUEST_METHOD = "GET";
    }

    public static class ApiResultKey {
        public static final String API_KEY_GENRES = "genres";
        public static final String API_KEY_GENRES_ID = "id";
        public static final String API_KEY_GENRES_NAME = "name";
        public static final String API_KEY_RESULTS = "results";
        public static final String API_MOVIE_KEY_ID = "id";
        public static final String API_MOVIE_KEY_TITLE = "title";
        public static final String API_MOVIE_KEY_POSTER_PATH = "poster_path";
        public static final String API_MOVIE_KEY_VOTE_AVERAGE = "vote_average";
        public static final String API_MOVIE_KEY_BACKDROP_PATH = "backdrop_path";
        public static final String API_MOVIE_KEY_OVERVIEW = "overview";
        public static final String API_MOVIE_KEY_RELEASE_DATE = "release_date";
        public static final String API_KEY_PRODUCTION_RESULTS = "production_companies";
        public static final String API_PRODUCTION_KEY_ID = "id";
        public static final String API_PRODUCTION_KEY_NAME = "name";
        public static final String API_TRAILER_ID = "id";
        public static final String API_TRAILER_KEY = "key";
        public static final String API_TRAILER_NAME = "name";
    }
}
