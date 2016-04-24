package com.example.liyalu.myapplication.model;

/**
 * Created by liyalu on 16/4/24.
 */
public class AppInfo {
    private String mAppName;
    private String mAppAuthor;
    private int mIconResId;
    private float mScore;

    public AppInfo(String appName, String appAuthor, int iconResId, float score) {
        this.mAppName = appName;
        this.mAppAuthor = appAuthor;
        this.mIconResId = iconResId;
        this.mScore = score;
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
