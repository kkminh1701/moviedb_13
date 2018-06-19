package com.framgia.moviedb_13.util;

import android.support.annotation.StringDef;
import com.framgia.moviedb_13.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.framgia.moviedb_13.util.Constant.TypeUrl.API_URL_GENRES;
import static com.framgia.moviedb_13.util.Constant.TypeUrl.API_URL_MOVIE_DETAIL;
import static com.framgia.moviedb_13.util.Constant.TypeUrl.API_URL_MOVIE_GENRE;
import static com.framgia.moviedb_13.util.Constant.TypeUrl.API_URL_MOVIE_NOW_PLAYING;
import static com.framgia.moviedb_13.util.Constant.TypeUrl.API_URL_MOVIE_POPULAR;
import static com.framgia.moviedb_13.util.Constant.TypeUrl.API_URL_MOVIE_TOP_RATED;
import static com.framgia.moviedb_13.util.Constant.TypeUrl.API_URL_MOVIE_UPCOMING;

public class Constant {
    private static final String API_KEY = "api_key=" + BuildConfig.API_KEY;
    public static final int URL_REQUEST_TIMEOUT = 10000;
    public static final int URL_CONNECT_TIMEOUT = 15000;

    @StringDef({
            API_URL_MOVIE_POPULAR, API_URL_MOVIE_NOW_PLAYING, API_URL_MOVIE_UPCOMING,
            API_URL_MOVIE_TOP_RATED, API_URL_MOVIE_GENRE,API_URL_MOVIE_DETAIL
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface TypeUrl{
        String API_URL_MOVIE_POPULAR = "movie/popular";
        String API_URL_MOVIE_NOW_PLAYING = "movie/now_playing";
        String API_URL_MOVIE_UPCOMING = "movie/upcoming";
        String API_URL_MOVIE_TOP_RATED = "movie/top_rated";
        String API_URL_MOVIE_GENRE = "genre/movie/list";
        String API_URL_MOVIE_DETAIL = "movie/";
        String API_URL_GENRES = "genre/movie/list?";
    }

    public static class RequestUrl {
        public static final String API_REQUEST_METHOD = "GET";
        private static final String API_URL = "https://api.themoviedb.org/3/";
        public static final String API_URL_REQUEST = API_URL + "%s?" + API_KEY + "&language=%s&page=%s";
        public static final String API_GENRES_REQUEST = API_URL + API_URL_GENRES + API_KEY;
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
