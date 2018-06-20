package com.framgia.moviedb_13.restapi;

import com.framgia.moviedb_13.data.model.Genre;
import com.framgia.moviedb_13.data.model.Movie;
import com.framgia.moviedb_13.data.model.Production;
import com.framgia.moviedb_13.data.model.Trailer;
import com.framgia.moviedb_13.util.Constant;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RequestApi {

    public String getJsonStringFromUrl(String urlString) throws IOException {
        HttpURLConnection urlConnection;
        URL url = new URL(urlString);
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod(Constant.RequestUrl.API_REQUEST_METHOD);
        urlConnection.setReadTimeout(Constant.URL_REQUEST_TIMEOUT);
        urlConnection.setConnectTimeout(Constant.URL_CONNECT_TIMEOUT);
        urlConnection.setDoInput(true);
        urlConnection.connect();
        InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line).append("\n");
        }
        bufferedReader.close();
        String jsonString = stringBuilder.toString();
        urlConnection.disconnect();
        return jsonString;
    }

    public List<Genre> parseJsonToGenre(String json) throws JSONException {
        List<Genre> genres = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArrayGenres = jsonObject.getJSONArray(Constant.ApiResultKey.API_KEY_GENRES);
        for (int i = 0; i < jsonArrayGenres.length(); i++) {
            Genre.Builder builder = new Genre.Builder();
            Genre genre = builder.setId(jsonArrayGenres.getJSONObject(i)
                    .getString(Constant.ApiResultKey.API_KEY_GENRES_ID))
                    .setName(jsonArrayGenres.getJSONObject(i)
                            .getString(Constant.ApiResultKey.API_KEY_GENRES_NAME))
                    .build();
            genres.add(genre);
        }
        return genres;
    }

    public List<Movie> parseJsonToMovie(String json) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArrayMovies = jsonObject.getJSONArray(Constant.ApiResultKey.API_KEY_RESULTS);
        for (int i = 0; i < jsonArrayMovies.length(); i++) {
            Movie.Builder builder = new Movie.Builder();
            Movie movie = builder.setId(jsonArrayMovies.getJSONObject(i)
                    .getString(Constant.ApiResultKey.API_MOVIE_KEY_ID))
                    .setTitle(jsonArrayMovies.getJSONObject(i)
                            .getString(Constant.ApiResultKey.API_MOVIE_KEY_TITLE))
                    .setPosterPath(jsonArrayMovies.getJSONObject(i)
                            .getString(Constant.ApiResultKey.API_MOVIE_KEY_POSTER_PATH))
                    .setVoteAverage(jsonArrayMovies.getJSONObject(i)
                            .getString(Constant.ApiResultKey.API_MOVIE_KEY_VOTE_AVERAGE))
                    .setBackdropPath(jsonArrayMovies.getJSONObject(i)
                            .getString(Constant.ApiResultKey.API_MOVIE_KEY_BACKDROP_PATH))
                    .setOverview(jsonArrayMovies.getJSONObject(i)
                            .getString(Constant.ApiResultKey.API_MOVIE_KEY_OVERVIEW))
                    .setReleaseDate(jsonArrayMovies.getJSONObject(i)
                            .getString(Constant.ApiResultKey.API_MOVIE_KEY_RELEASE_DATE))
                    .build();
            movies.add(movie);
        }
        return movies;
    }

    public List<Production> parseJsonToProductions(String json) throws JSONException {
        List<Production> productions = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArrayProduction =
                jsonObject.getJSONArray(Constant.ApiResultKey.API_KEY_PRODUCTION_RESULTS);
        for (int i = 0; i < jsonArrayProduction.length(); i++) {
            Production.Builder builder = new Production.Builder();
            Production production = builder.setId(jsonArrayProduction.getJSONObject(i)
                    .getString(Constant.ApiResultKey.API_PRODUCTION_KEY_ID))
                    .setName(jsonArrayProduction.getJSONObject(i)
                            .getString(Constant.ApiResultKey.API_PRODUCTION_KEY_NAME))
                    .build();
            productions.add(production);
        }
        return productions;
    }

    public List<Trailer> parseJsonToTrailer(String json) throws JSONException {
        List<Trailer> trailers = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArrayTrailer = jsonObject.getJSONArray(Constant.ApiResultKey.API_KEY_RESULTS);
        for (int i = 0; i < jsonArrayTrailer.length(); i++) {
            Trailer.Builder builder = new Trailer.Builder();
            Trailer trailer = builder.setId(jsonArrayTrailer.getJSONObject(i)
                    .getString(Constant.ApiResultKey.API_TRAILER_ID))
                    .setKey(jsonArrayTrailer.getJSONObject(i)
                            .getString(Constant.ApiResultKey.API_TRAILER_KEY))
                    .setName(jsonArrayTrailer.getJSONObject(i)
                            .getString(Constant.ApiResultKey.API_TRAILER_NAME))
                    .build();
            trailers.add(trailer);
        }
        return trailers;
    }
}
