package com.example.liyalu.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by liyalu on 16/4/24.
 */
public class AppInfo implements Parcelable{
    private String mAppName;
    private String mAppAuthor;
    private int mIconResId;
    private float mScore;

    private AppInfo(Parcel parcel) {
        mAppName = parcel.readString();
        mAppAuthor = parcel.readString();
        mIconResId = parcel.readInt();
        mScore = parcel.readFloat();
    }

    public AppInfo(String appName, String appAuthor, int iconResId, float score) {
        this.mAppName = appName;
        this.mAppAuthor = appAuthor;
        this.mIconResId = iconResId;
        this.mScore = score;
    }

    public static final Parcelable.Creator<AppInfo> CREATOR = new Creator<AppInfo>() {
        @Override
        public AppInfo createFromParcel(Parcel parcel) {
            return new AppInfo(parcel);
        }

        @Override
        public AppInfo[] newArray(int i) {
            return new AppInfo[i];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mAppName);
        parcel.writeString(mAppAuthor);
        parcel.writeInt(mIconResId);
        parcel.writeFloat(mScore);
    }

    public String getAppName() {
        return mAppName;
    }

    public String getAppAuthor() {
        return mAppAuthor;
    }

    public int getIconResId() {
        return mIconResId;
    }

    public float getScore() {
        return mScore;
    }

    public void setAppName(String appName) {
        this.mAppName = appName;
    }

    public void setScore(float score) {
        this.mScore = score;
    }

    public void setAppAuthor(String appAuthor) {
        this.mAppAuthor = appAuthor;
    }

    public void setIconResId(int iconResId) {
        this.mIconResId = iconResId;
    }
}
