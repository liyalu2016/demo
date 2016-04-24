package com.example.liyalu.myapplication.model;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liyalu on 16/4/24.
 */
public class AppGroup {
    private List<AppInfo> mAppList = new LinkedList<>();
    private String mTitle;
    private String mSubTitle;

    public AppGroup(String title, String subTitle) {
        mTitle = title;
        mSubTitle = subTitle;
    }

    public List<AppInfo> getAppList() {
        return mAppList;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSubTitle() {
        return mSubTitle;
    }

    public void setSubTitle(String subTitle) {
        mSubTitle = subTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
