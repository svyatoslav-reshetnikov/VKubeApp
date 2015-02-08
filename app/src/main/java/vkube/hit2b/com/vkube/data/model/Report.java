package vkube.hit2b.com.vkube.data.model;

/**
 * Created by svyat on 31.01.15.
 */

import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;

public class Report implements Parcelable {

    public String name;
    public String date;
    public String description;
    public ArrayList<String> images;

    public Report(){

    }

    // Parcelable management
    private Report(Parcel in) {
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
        dest.writeInt(images.size());
        dest.writeList(images);
    }

    public static final Parcelable.Creator<Report> CREATOR = new Parcelable.Creator<Report>() {
        public Report createFromParcel(Parcel in) {
            return new Report(in);
        }

        public Report[] newArray(int size) {
            return new Report[size];
        }
    };

}