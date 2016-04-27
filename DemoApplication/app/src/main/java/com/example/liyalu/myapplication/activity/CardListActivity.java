package com.example.liyalu.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.liyalu.myapplication.R;
import com.example.liyalu.myapplication.adapter.AppCardAdapter;
import com.example.liyalu.myapplication.model.AppGroup;
import com.example.liyalu.myapplication.model.AppInfo;


/**
 * Created by liyalu on 16/4/23.
 */
public class CardListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        AppCardAdapter adapter = new AppCardAdapter(generateTestData());
        recyclerView.setAdapter(adapter);
    }

    private static AppGroup[] generateTestData() {
        AppGroup[] appGroups = new AppGroup[10];

        AppGroup appGroup = new AppGroup("Want quick suggestions?", "Rate this item to get recommendations");
        appGroup.getAppList().add(new AppInfo("Meme Creator", "Gentoozero", R.drawable.icon_app_0, 4.0f));
        appGroup.getAppList().add(new AppInfo("BuzzFeed", "BuzzFeed", R.drawable.icon_app_1, 4.1f));
        appGroup.getAppList().add(new AppInfo("GATM Meme Generator", "IDDQD", R.drawable.icon_app_2, 4.2f));
        appGroup.getAppList().add(new AppInfo("BBC News", "BBC Worldwide (Ltd)", R.drawable.icon_app_3, 4.3f));
        appGroup.getAppList().add(new AppInfo("Google", "Google Inc.", R.drawable.icon_app_4, 4.4f));
        appGroup.getAppList().add(new AppInfo("Jetradar", "JetRadar", R.drawable.icon_app_5, 4.5f));
        appGroups[0] = appGroup;

        appGroups[1] = new AppGroup("Commution Apps", "Recommended for you");
        appGroups[1].getAppList().add(new AppInfo("BuzzFeed", "BuzzFeed", R.drawable.icon_app_1, 4.1f));
        appGroups[2] = new AppGroup("Photography Apps", "Recommended for you");
        appGroups[2].getAppList().add(new AppInfo("GATM Meme Generator", "IDDQD", R.drawable.icon_app_2, 4.2f));

        appGroup = new AppGroup("Want quick suggestions?", "Rate this item to get recommendations");
        appGroup.getAppList().add(new AppInfo("Meme Creator", "Gentoozero", R.drawable.icon_app_0, 4.0f));
        appGroup.getAppList().add(new AppInfo("BuzzFeed", "BuzzFeed", R.drawable.icon_app_1, 4.1f));
        appGroup.getAppList().add(new AppInfo("GATM Meme Generator", "IDDQD", R.drawable.icon_app_2, 4.2f));
        appGroup.getAppList().add(new AppInfo("BBC News", "BBC Worldwide (Ltd)", R.drawable.icon_app_3, 4.3f));
        appGroup.getAppList().add(new AppInfo("Google", "Google Inc.", R.drawable.icon_app_4, 4.4f));
        appGroup.getAppList().add(new AppInfo("Jetradar", "JetRadar", R.drawable.icon_app_5, 4.5f));
        appGroups[3] = appGroup;

        appGroups[4] = new AppGroup("Commution Apps", "Recommended for you");
        appGroups[4].getAppList().add(new AppInfo("Google", "Google Inc.", R.drawable.icon_app_4, 4.4f));
        appGroups[5] = new AppGroup("Photography Apps", "Recommended for you");
        appGroups[5].getAppList().add(new AppInfo("Jetradar", "JetRadar", R.drawable.icon_app_5, 4.5f));
        appGroups[6] = new AppGroup("Want quick suggestions?", "Rate this item to get recommendations");
        appGroups[6].getAppList().add(new AppInfo("Doodle Like Magic", "Doodle Joy Studio", R.drawable.icon_app_6, 4.6f));
        appGroups[7] = new AppGroup("Commution Apps", "Recommended for you");
        appGroups[7].getAppList().add(new AppInfo("Duolingo", "Duolingo", R.drawable.icon_app_7, 4.7f));
        appGroups[8] = new AppGroup("Photography Apps", "Recommended for you");
        appGroups[8].getAppList().add(new AppInfo("BeautyPlus - Magical Camera", "Meitu (China) Limited", R.drawable.icon_app_8, 4.8f));
        appGroups[9] = new AppGroup("Want quick suggestions?", "Rate this item to get recommendations");
        appGroups[9].getAppList().add(new AppInfo("CandyCamera", "JP Brothers, Inc.", R.drawable.icon_app_9, 4.9f));

        return appGroups;
    }

    public static class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }
    }
}
