package com.example.liyalu.myapplication.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liyalu.myapplication.R;

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
        AppItem[] appItemList = new AppItem[MAX_LEN];
        appItemList[0] = new AppItem(new BigCardData("Meme Creator", "Gentoozero", R.drawable.icon_app_0, 4.0f), "Want quick suggestions?", "Rate this item to get recommendations");
        appItemList[1] = new AppItem(new BigCardData("BuzzFeed", "BuzzFeed", R.drawable.icon_app_1, 4.1f), "Commution Apps", "Recommended for you");
        appItemList[2] = new AppItem(new BigCardData("GATM Meme Generator", "IDDQD", R.drawable.icon_app_2, 4.2f), "Photography Apps", "Recommended for you");
        appItemList[3] = new AppItem(new BigCardData("BBC News", "BBC Worldwide (Ltd)", R.drawable.icon_app_3, 4.3f), "Want quick suggestions?", "Rate this item to get recommendations");
        appItemList[4] = new AppItem(new BigCardData("Google", "Google Inc.", R.drawable.icon_app_4, 4.4f), "Commution Apps", "Recommended for you");
        appItemList[5] = new AppItem(new BigCardData("Jetradar", "JetRadar", R.drawable.icon_app_5, 4.5f), "Photography Apps", "Recommended for you");
        appItemList[6] = new AppItem(new BigCardData("Doodle Like Magic", "Doodle Joy Studio", R.drawable.icon_app_6, 4.6f), "Want quick suggestions?", "Rate this item to get recommendations");
        appItemList[7] = new AppItem(new BigCardData("Duolingo", "Duolingo", R.drawable.icon_app_7, 4.7f), "Commution Apps", "Recommended for you");
        appItemList[8] = new AppItem(new BigCardData("BeautyPlus - Magical Camera", "Meitu (China) Limited", R.drawable.icon_app_8, 4.8f), "Photography Apps", "Recommended for you");
        appItemList[9] = new AppItem(new BigCardData("CandyCamera", "JP Brothers, Inc.", R.drawable.icon_app_9, 4.9f), "Want quick suggestions?", "Rate this item to get recommendations");

        mAdapter = new AppCardAdapter(appItemList);
        mRecyclerView.setAdapter(mAdapter);
    }

    public class BigCardData {
        private String mAppName;
        private String mAppAuthor;
        private int mImageId;
        private float mScore;

        public BigCardData(String appName, String appAuthor, int imageId, float score) {
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

    public class AppItem {
        private BigCardData mBigCardData;
        private String mTitle;
        private String mSubTitle;

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

        public AppItem(CardListActivity.BigCardData bigCardData, String title, String subTitle) {
            mBigCardData = bigCardData;
            mTitle = title;
            mSubTitle = subTitle;
        }
    }

    public class AppCardViewHolder extends RecyclerView.ViewHolder {

        public AppCardViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class AppCardAdapter extends RecyclerView.Adapter<AppCardViewHolder> {
        private AppItem[] mDataSet;

        public AppCardAdapter(AppItem[] dataSet) {
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
            imageView.setImageResource(mDataSet[position].mBigCardData.getImageId());

            TextView nameView = (TextView) holder.itemView.findViewById(R.id.app_name);
            nameView.setText(mDataSet[position].mBigCardData.getAppName());

            TextView authorView = (TextView) holder.itemView.findViewById(R.id.app_author);
            authorView.setText(mDataSet[position].mBigCardData.getAppAuthor());

//            TextView scoreView = (TextView) holder.itemView.findViewById(R.id.score);
//            scoreView.setText(String.valueOf(mDataSet[position].getScore()));

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
