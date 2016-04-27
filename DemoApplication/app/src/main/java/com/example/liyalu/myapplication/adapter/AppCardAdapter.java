package com.example.liyalu.myapplication.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liyalu.myapplication.R;
import com.example.liyalu.myapplication.model.AppGroup;
import com.example.liyalu.myapplication.view_holder.AppCardViewHolder;

/**
 * Created by liyalu on 16/4/28.
 */
public class AppCardAdapter extends RecyclerView.Adapter<AppCardViewHolder> {
    private static final int VIEW_TYPE_APP_LIST = 0;
    private static final int VIEW_TYPE_APP = 1;

    private AppGroup[] mDataSet;

    public AppCardAdapter(AppGroup[] dataSet) {
        mDataSet = dataSet;
    }

    @Override
    public AppCardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_APP_LIST) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_horizontal_list, parent, false);
            RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.horizontal_list);
            recyclerView.setHasFixedSize(true);

            LinearLayoutManager layoutManager = new LinearLayoutManager(parent.getContext(),
                    LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(layoutManager);

            RecyclerView.Adapter adapter = new RecyclerViewAdapter();
            recyclerView.setAdapter(adapter);

            AppCardViewHolder vh = new AppCardViewHolder(v);
            vh.recyclerView = recyclerView;

            return vh;
        } else {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.app_item, parent, false);

            return new AppCardViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(AppCardViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW_TYPE_APP_LIST) {
            RecyclerViewAdapter adapter = (RecyclerViewAdapter) holder.recyclerView.getAdapter();
            adapter.mAppGroup = mDataSet[position];
            adapter.notifyDataSetChanged();

            TextView titleView = (TextView) holder.itemView.findViewById(R.id.title);
            titleView.setText(mDataSet[position].getTitle());

            TextView subTitleView = (TextView) holder.itemView.findViewById(R.id.sub_title);
            subTitleView.setText(mDataSet[position].getSubTitle());

        } else {
            ImageView imageView = (ImageView) holder.itemView.findViewById(R.id.app_icon);
            imageView.setImageResource(mDataSet[position].getAppList().get(0).getIconResId());

            TextView nameView = (TextView) holder.itemView.findViewById(R.id.app_name);
            nameView.setText(mDataSet[position].getAppList().get(0).getAppName());

            TextView authorView = (TextView) holder.itemView.findViewById(R.id.app_author);
            authorView.setText(mDataSet[position].getAppList().get(0).getAppAuthor());

            TextView titleView = (TextView) holder.itemView.findViewById(R.id.title);
            titleView.setText(mDataSet[position].getTitle());

            TextView subTitleView = (TextView) holder.itemView.findViewById(R.id.sub_title);
            subTitleView.setText(mDataSet[position].getSubTitle());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataSet[position].getAppList().size() > 1) {
            return VIEW_TYPE_APP_LIST;
        } else {
            return VIEW_TYPE_APP;
        }
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }
}