package com.ilhamrofiqi.submission1;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private int poster;
    private String name;
    private String description;
    private String director;
    private String release;
    private String durasi;

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.poster);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.director);
        dest.writeString(this.release);
        dest.writeString(this.durasi);
    }

    public Film() {
    }

    protected Film(Parcel in) {
        this.poster = in.readInt();
        this.name = in.readString();
        this.description = in.readString();
        this.director = in.readString();
        this.release = in.readString();
        this.durasi = in.readString();
    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}
