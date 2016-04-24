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
        mRecyclerView = (RecyclerView)findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        final int MAX_LEN = 10;
        BigCardData[] bigCardDataList = new BigCardData[MAX_LEN];
        bigCardDataList[0] = new BigCardData("Meme Creator", "Gentoozero", R.drawable.icon_app_0, 4.0f);
        bigCardDataList[1] = new BigCardData("BuzzFeed", "BuzzFeed", R.drawable.icon_app_1, 4.1f);
        bigCardDataList[2] = new BigCardData("GATM Meme Generator", "IDDQD", R.drawable.icon_app_2, 4.2f);
        bigCardDataList[3] = new BigCardData("BBC News", "BBC Worldwide (Ltd)", R.drawable.icon_app_3, 4.3f);
        bigCardDataList[4] = new BigCardData("Google", "Google Inc.", R.drawable.icon_app_4, 4.4f);
        bigCardDataList[5] = new BigCardData("Jetradar", "JetRadar", R.drawable.icon_app_5, 4.5f);
        bigCardDataList[6] = new BigCardData("Doodle Like Magic", "Doodle Joy Studio", R.drawable.icon_app_6, 4.6f);
        bigCardDataList[7] = new BigCardData("Duolingo", "Duolingo", R.drawable.icon_app_7, 4.7f);
        bigCardDataList[8] = new BigCardData("BeautyPlus - Magical Camera", "Meitu (China) Limited", R.drawable.icon_app_8, 4.8f);
        bigCardDataList[9] = new BigCardData("CandyCamera", "JP Brothers, Inc.", R.drawable.icon_app_9, 4.9f);

        mAdapter = new AppCardAdapter(bigCardDataList);
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

    public class AppCardViewHolder extends RecyclerView.ViewHolder {

        public AppCardViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class AppCardAdapter extends RecyclerView.Adapter<AppCardViewHolder> {
        private BigCardData[] mDataSet;

        public AppCardAdapter(BigCardData[] dataSet) {
            mDataSet = dataSet;
        }

        @Override
        public AppCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.big_card, parent, false);

            AppCardViewHolder vh = new AppCardViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(AppCardViewHolder holder, int position) {

            ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.app_icon);
            imageView.setImageResource(mDataSet[position].getImageId());

            TextView nameView = (TextView) holder.itemView.findViewById(R.id.app_name);
            nameView.setText(mDataSet[position].getAppName());

            TextView authorView = (TextView) holder.itemView.findViewById(R.id.app_author);
            authorView.setText(mDataSet[position].getAppAuthor());

//            TextView scoreView = (TextView) holder.itemView.findViewById(R.id.score);
//            scoreView.setText(String.valueOf(mDataSet[position].getScore()));
        }

        @Override
        public int getItemCount() {
            return mDataSet.length;
        }
    }


}
