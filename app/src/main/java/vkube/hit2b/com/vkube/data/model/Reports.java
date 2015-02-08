package vkube.hit2b.com.vkube.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by svyat on 07.02.15.
 */
public class Reports implements Parcelable {

    public String result;
    public ArrayList<Report> reports;

    public Reports(){

    }

    // Parcelable management
    private Reports(Parcel in) {
        result = in.readString();
        in.readList(reports, Report.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(result);
        dest.writeList(reports);
    }

    public static final Parcelable.Creator<Reports> CREATOR = new Parcelable.Creator<Reports>() {
        public Reports createFromParcel(Parcel in) {
            return new Reports(in);
        }

        public Reports[] newArray(int size) {
            return new Reports[size];
        }
    };

}