package com.example.liyalu.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.widget.TextView;

import com.example.liyalu.myapplication.R;
import com.example.liyalu.myapplication.adapter.RecyclerViewAdapter;
import com.example.liyalu.myapplication.model.AppGroup;
import com.example.liyalu.myapplication.model.AppInfo;

/**
 * Created by liyalu on 16/4/24.
 */
public class HorizontalListActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.horizontal_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
        adapter.mAppGroup = generateTestData();

        updateHeader(adapter.mAppGroup);
    }

    private static AppGroup generateTestData() {
        AppGroup appGroup = new AppGroup("Want quick suggestions?", "Rate this item to get recommendations");
        appGroup.getAppList().add(new AppInfo("Meme Creator", "Gentoozero", R.drawable.icon_app_0, 4.0f));
        appGroup.getAppList().add(new AppInfo("BuzzFeed", "BuzzFeed", R.drawable.icon_app_1, 4.1f));
        appGroup.getAppList().add(new AppInfo("GATM Meme Generator", "IDDQD", R.drawable.icon_app_2, 4.2f));
        appGroup.getAppList().add(new AppInfo("BBC News", "BBC Worldwide (Ltd)", R.drawable.icon_app_3, 4.3f));
        appGroup.getAppList().add(new AppInfo("Google", "Google Inc.", R.drawable.icon_app_4, 4.4f));
        appGroup.getAppList().add(new AppInfo("Jetradar", "JetRadar", R.drawable.icon_app_5, 4.5f));

        return appGroup;
    }

    private void updateHeader(AppGroup appGroup) {
        TextView titleView = (TextView) findViewById(R.id.title);
        titleView.setText(appGroup.getTitle());

        TextView subTitleView = (TextView) findViewById(R.id.sub_title);
        subTitleView.setText(appGroup.getSubTitle());
    }
}



