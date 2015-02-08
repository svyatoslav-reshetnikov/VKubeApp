package vkube.hit2b.com.vkube.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by svyat on 07.02.15.
 */
public class Announcements implements Parcelable {

    public String result;
    public ArrayList<Announcement> announcements;

    public Announcements(){

    }

    // Parcelable management
    private Announcements(Parcel in) {
        result = in.readString();
        in.readList(announcements, Announcement.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(result);
        dest.writeList(announcements);
    }

    public static final Parcelable.Creator<Announcements> CREATOR = new Parcelable.Creator<Announcements>() {
        public Announcements createFromParcel(Parcel in) {
            return new Announcements(in);
        }

        public Announcements[] newArray(int size) {
            return new Announcements[size];
        }
    };

}