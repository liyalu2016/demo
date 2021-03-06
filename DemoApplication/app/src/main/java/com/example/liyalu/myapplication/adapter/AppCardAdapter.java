package com.example.liyalu.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.liyalu.myapplication.R;
import com.example.liyalu.myapplication.activity.DetailsPageActivity;
import com.example.liyalu.myapplication.model.AppGroup;
import com.example.liyalu.myapplication.model.AppInfo;
import com.example.liyalu.myapplication.view_holder.AppCardViewHolder;

/**
 * Created by liyalu on 16/4/28.
 */
public class AppCardAdapter extends RecyclerView.Adapter<AppCardViewHolder> {
    private static final int VIEW_TYPE_APP_LIST = 0;
    private static final int VIEW_TYPE_APP = 1;

    private AppGroup[] mDataSet;

    private View.OnClickListener mOnClickCardListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Integer position = (Integer) view.getTag();
            AppInfo appInfo = mDataSet[position].getAppList().get(0);

            Context context = view.getContext();
            Intent intent = new Intent(context, DetailsPageActivity.class);
            intent.putExtra(DetailsPageActivity.EXTRA_APP_INFO, appInfo);

            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    (Activity) context,
                    new Pair<View, String>(view.findViewById(R.id.app_icon),
                            context.getString(R.string.transition_name_icon))
            );
            ActivityCompat.startActivity((Activity) context, intent, options.toBundle());
        }
    };

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
            v.setOnClickListener(mOnClickCardListener);

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
            holder.itemView.setTag(position);

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