package com.example.liyalu.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liyalu.myapplication.R;
import com.example.liyalu.myapplication.model.AppInfo;

/**
 * Created by liyalu on 16/4/28.
 */
public class DetailsPageActivity extends Activity {

    public static final String EXTRA_APP_INFO = "EXTRA_APP_INFO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_page);

        AppInfo appInfo = (AppInfo)getIntent().getParcelableExtra(EXTRA_APP_INFO);

        ImageView imageView = (ImageView) findViewById(R.id.app_icon);
        imageView.setImageResource(appInfo.getIconResId());

        TextView nameView = (TextView) findViewById(R.id.app_name);
        nameView.setText(appInfo.getAppName());

        TextView authorView = (TextView) findViewById(R.id.app_author);
        authorView.setText(appInfo.getAppAuthor());
    }
}
