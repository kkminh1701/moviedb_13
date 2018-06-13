package com.framgia.moviedb_13.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Trailer implements Parcelable {
    private String mId;
    private String mKey;
    private String mName;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getKey() {
        return mKey;
    }

    public void setKey(String key) {
        mKey = key;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public static Creator<Trailer> getCREATOR() {
        return CREATOR;
    }

    public Trailer() {
    }

    protected Trailer(Parcel in) {
        mId = in.readString();
        mKey = in.readString();
        mName = in.readString();
    }

    public static final Creator<Trailer> CREATOR = new Creator<Trailer>() {
        @Override
        public Trailer createFromParcel(Parcel in) {
            return new Trailer(in);
        }

        @Override
        public Trailer[] newArray(int size) {
            return new Trailer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
        dest.writeString(mKey);
        dest.writeString(mName);
    }

    private Trailer(Builder builder) {
        mId = builder.mId;
        mKey = builder.mKey;
        mName = builder.mName;
    }

    public static class Builder {
        private String mId;
        private String mKey;
        private String mName;

        public Builder() {
        }

        public Trailer build() {
            return new Trailer(this);
        }

        public Builder setId(String id) {
            mId = id;
            return this;
        }

        public Builder setKey(String key) {
            mKey = key;
            return this;
        }

        public Builder setName(String name) {
            mName = name;
            return this;
        }
    }
}
