package vkube.hit2b.com.vkube.data.model;

/**
 * Created by svyat on 31.01.15.
 */

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class Video implements Parcelable {

    public String name;
    public String date;
    public String description;
    public String link;

    public Video(){

    }

    // Parcelable management
    private Video(Parcel in) {
        name = in.readString();
        date = in.readString();
        description = in.readString();
        link = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(date);
        dest.writeString(description);
        dest.writeString(link);
    }

    public static final Parcelable.Creator<Video> CREATOR = new Parcelable.Creator<Video>() {
        public Video createFromParcel(Parcel in) {
            return new Video(in);
        }

        public Video[] newArray(int size) {
            return new Video[size];
        }
    };

}