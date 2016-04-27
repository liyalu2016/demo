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

        AppGroup appGroup = new AppGroup("Want quick suggestions?", "Rate this item to get recommendations");
        appGroup.getAppList().add(new AppInfo("Meme Creator", "Gentoozero", R.drawable.icon_app_0, 4.0f));
        appGroup.getAppList().add(new AppInfo("BuzzFeed", "BuzzFeed", R.drawable.icon_app_1, 4.1f));
        appGroup.getAppList().add(new AppInfo("GATM Meme Generator", "IDDQD", R.drawable.icon_app_2, 4.2f));
        appGroup.getAppList().add(new AppInfo("BBC News", "BBC Worldwide (Ltd)", R.drawable.icon_app_3, 4.3f));
        appGroup.getAppList().add(new AppInfo("Google", "Google Inc.", R.drawable.icon_app_4, 4.4f));
        appGroup.getAppList().add(new AppInfo("Jetradar", "JetRadar", R.drawable.icon_app_5, 4.5f));

        RecyclerView.Adapter adapter = new RecyclerViewAdapter(appGroup);
        recyclerView.setAdapter(adapter);

        TextView titleView = (TextView) findViewById(R.id.title);
        titleView.setText(appGroup.getTitle());

        TextView subTitleView = (TextView) findViewById(R.id.sub_title);
        subTitleView.setText(appGroup.getSubTitle());
    }

    public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
        public AppGroup mAppGroup;

        public RecyclerViewAdapter(AppGroup appGroup) {
            this.mAppGroup = appGroup;
        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_horizontal_item, parent, false);
            RecyclerViewHolder vh = new RecyclerViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            AppInfo info = mAppGroup.getAppList().get(position);

            ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.app_icon);
            imageView.setImageResource(info.getIconResId());

            TextView textView = (TextView) holder.itemView.findViewById(R.id.app_name);
            textView.setText(info.getAppName());

            TextView scoreTextView = (TextView) holder.itemView.findViewById(R.id.score);
            scoreTextView.setText(String.valueOf(info.getScore()));
        }

        @Override
        public int getItemCount() {
            return mAppGroup.getAppList().size();
        }
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public RecyclerViewHolder(View itemView) {
            super(itemView);
        }
    }
}



