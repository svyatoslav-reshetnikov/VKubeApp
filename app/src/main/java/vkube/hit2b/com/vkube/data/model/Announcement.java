package vkube.hit2b.com.vkube.data.model;

/**
 * Created by svyat on 31.01.15.
 */

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class Announcement implements Parcelable {

    public String name;
    public String date;
    public String description;
    public ArrayList<String> images;

    public Announcement(){

    }

    // Parcelable management
    private Announcement(Parcel in) {
        name = in.readString();
        date = in.readString();
        description = in.readString();
        in.readList(images, String.class.getClassLoader());
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
        dest.writeList(images);
    }

    public static final Parcelable.Creator<Announcement> CREATOR = new Parcelable.Creator<Announcement>() {
        public Announcement createFromParcel(Parcel in) {
            return new Announcement(in);
        }

        public Announcement[] newArray(int size) {
            return new Announcement[size];
        }
    };

}