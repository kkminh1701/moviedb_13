package com.framgia.moviedb_13.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String mId;
    private String mTitle;
    private String mVoteAverage;
    private String mPosterPath;
    private String mBackdropPath;
    private String mOverview;
    private String mReleaseDate;
    private boolean mIsFavourite;

    public Movie() {
    }

    protected Movie(Parcel in) {
        mId = in.readString();
        mTitle = in.readString();
        mVoteAverage = in.readString();
        mPosterPath = in.readString();
        mBackdropPath = in.readString();
        mOverview = in.readString();
        mReleaseDate = in.readString();
        mIsFavourite = in.readByte() != 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getVoteAverage() {
        return mVoteAverage;
    }

    public void setVoteAverage(String voteAverage) {
        mVoteAverage = voteAverage;
    }

    public String getPosterPath() {
        return mPosterPath;
    }

    public void setPosterPath(String posterPath) {
        mPosterPath = posterPath;
    }

    public String getBackdropPath() {
        return mBackdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        mBackdropPath = backdropPath;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public String getReleaseDate() {
        return mReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        mReleaseDate = releaseDate;
    }

    public boolean isFavourite() {
        return mIsFavourite;
    }

    public void setFavourite(boolean favourite) {
        mIsFavourite = favourite;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mId);
        parcel.writeString(mTitle);
        parcel.writeString(mVoteAverage);
        parcel.writeString(mPosterPath);
        parcel.writeString(mBackdropPath);
        parcel.writeString(mOverview);
        parcel.writeString(mReleaseDate);
        parcel.writeByte((byte) (mIsFavourite ? 1 : 0));
    }

    private Movie(Builder builder) {
        mId = builder.mId;
        mTitle = builder.mTitle;
        mVoteAverage = builder.mVoteAverage;
        mPosterPath = builder.mPosterPath;
        mBackdropPath = builder.mBackdropPath;
        mOverview = builder.mOverview;
        mReleaseDate = builder.mReleaseDate;
    }

    public static class Builder {
        private String mId;
        private String mTitle;
        private String mVoteAverage;
        private String mPosterPath;
        private String mBackdropPath;
        private String mOverview;
        private String mReleaseDate;

        public Builder() {
        }

        public Movie build() {
            return new Movie(this);
        }

        public Builder setId(String id) {
            mId = id;
            return this;
        }

        public Builder setTitle(String title) {
            mTitle = title;
            return this;
        }

        public Builder setVoteAverage(String voteAverage) {
            mVoteAverage = voteAverage;
            return this;
        }

        public Builder setPosterPath(String posterPath) {
            mPosterPath = posterPath;
            return this;
        }

        public Builder setBackdropPath(String backdropPath) {
            mBackdropPath = backdropPath;
            return this;
        }

        public Builder setOverview(String overview) {
            mOverview = overview;
            return this;
        }

        public Builder setReleaseDate(String releaseDate) {
            mReleaseDate = releaseDate;
            return this;
        }
    }
}
