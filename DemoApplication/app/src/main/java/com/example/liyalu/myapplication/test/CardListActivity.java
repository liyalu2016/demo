package com.example.liyalu.myapplication.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liyalu.myapplication.R;
import com.example.liyalu.myapplication.model.AppGroup;
import com.example.liyalu.myapplication.model.AppInfo;


/**
 * Created by liyalu on 16/4/23.
 */
public class CardListActivity extends Activity {
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private AppCardAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        final int MAX_LEN = 10;
        AppGroup[] appGroups = new AppGroup[MAX_LEN];
        appGroups[0] = new AppGroup("Want quick suggestions?", "Rate this item to get recommendations");
        appGroups[0].getAppList().add(new AppInfo("Meme Creator", "Gentoozero", R.drawable.icon_app_0, 4.0f));
        appGroups[1] = new AppGroup("Commution Apps", "Recommended for you");
        appGroups[1].getAppList().add(new AppInfo("BuzzFeed", "BuzzFeed", R.drawable.icon_app_1, 4.1f));
        appGroups[2] = new AppGroup("Photography Apps", "Recommended for you");
        appGroups[2].getAppList().add(new AppInfo("GATM Meme Generator", "IDDQD", R.drawable.icon_app_2, 4.2f));
        appGroups[3] = new AppGroup("Want quick suggestions?", "Rate this item to get recommendations");
        appGroups[3].getAppList().add(new AppInfo("BBC News", "BBC Worldwide (Ltd)", R.drawable.icon_app_3, 4.3f));
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

        mAdapter = new AppCardAdapter(appGroups);
        mRecyclerView.setAdapter(mAdapter);
    }

    public class AppCardViewHolder extends RecyclerView.ViewHolder {

        public AppCardViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class AppCardAdapter extends RecyclerView.Adapter<AppCardViewHolder> {
        private AppGroup[] mDataSet;

        public AppCardAdapter(AppGroup[] dataSet) {
            mDataSet = dataSet;
        }

        @Override
        public AppCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.app_item, parent, false);

            AppCardViewHolder vh = new AppCardViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(AppCardViewHolder holder, int position) {

            ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.app_icon);
            imageView.setImageResource(mDataSet[position].getAppList().get(0).getIconResId());

            TextView nameView = (TextView) holder.itemView.findViewById(R.id.app_name);
            nameView.setText(mDataSet[position].getAppList().get(0).getAppName());

            TextView authorView = (TextView) holder.itemView.findViewById(R.id.app_author);
            authorView.setText(mDataSet[position].getAppList().get(0).getAppAuthor());

//            TextView scoreView = (TextView) holder.itemView.findViewById(R.id.score);
//            scoreView.setText(String.valueOf(mDataSet[position].getAppList().get(0).getScore()));

            TextView titleView = (TextView) holder.itemView.findViewById(R.id.title);
            titleView.setText(mDataSet[position].getTitle());

            TextView subTitleView = (TextView) holder.itemView.findViewById(R.id.sub_title);
            subTitleView.setText(mDataSet[position].getSubTitle());
        }

        @Override
        public int getItemCount() {
            return mDataSet.length;
        }
    }


}
