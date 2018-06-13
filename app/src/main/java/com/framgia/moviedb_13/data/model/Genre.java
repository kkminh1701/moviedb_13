package com.framgia.moviedb_13.data.model;

public class Genre {
    private String mId;
    private String mName;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    private Genre(Builder builder) {
        mId = builder.mId;
        mName = builder.mName;
    }

    public static class Builder {
        private String mId;
        private String mName;

        public Builder() {
        }

        public Genre build() {
            return new Genre(this);
        }

        public Builder setId(String id) {
            mId = id;
            return this;
        }

        public Builder setName(String name) {
            mName = name;
            return this;
        }
    }
}
