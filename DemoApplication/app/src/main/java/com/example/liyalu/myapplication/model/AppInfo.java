package com.example.liyalu.myapplication.model;

/**
 * Created by liyalu on 16/4/24.
 */
public class AppInfo {
    private String mAppName;
    private String mAppAuthor;
    private int mImageId;
    private float mScore;

    public AppInfo(String appName, String appAuthor, int imageId, float score) {
        this.mAppName = appName;
        this.mAppAuthor = appAuthor;
        this.mImageId = imageId;
        this.mScore = score;
    }

    public String getAppName() {
        return mAppName;
    }

    public String getAppAuthor() {
        return mAppAuthor;
    }

    public int getImageId() {
        return mImageId;
    }

    public float getScore() {
        return mScore;
    }

    public void setAppName(String mAppName) {
        this.mAppName = mAppName;
    }

    public void setScore(float mScore) {
        this.mScore = mScore;
    }

    public void setAppAuthor(String mAppAuthor) {
        this.mAppAuthor = mAppAuthor;
    }

    public void setImageId(int mImageId) {
        this.mImageId = mImageId;
    }
}
