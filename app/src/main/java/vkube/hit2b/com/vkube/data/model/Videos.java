package vkube.hit2b.com.vkube.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by svyat on 07.02.15.
 */
public class Videos implements Parcelable {

    public String result;
    public ArrayList<Video> videos;

    public Videos(){

    }

    // Parcelable management
    private Videos(Parcel in) {
        result = in.readString();
        in.readList(videos, Video.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(result);
        dest.writeList(videos);
    }

    public static final Parcelable.Creator<Videos> CREATOR = new Parcelable.Creator<Videos>() {
        public Videos createFromParcel(Parcel in) {
            return new Videos(in);
        }

        public Videos[] newArray(int size) {
            return new Videos[size];
        }
    };

}