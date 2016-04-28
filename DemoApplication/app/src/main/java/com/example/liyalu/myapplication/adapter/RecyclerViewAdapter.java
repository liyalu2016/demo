package com.example.liyalu.myapplication.adapter;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
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
import com.example.liyalu.myapplication.view_holder.RecyclerViewHolder;


/**
 * Created by liyalu on 16/4/28.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    public AppGroup mAppGroup;
    private View.OnClickListener mOnClickCardListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Integer position = (Integer) view.getTag();
            AppInfo appInfo = mAppGroup.getAppList().get(position);

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

    public RecyclerViewAdapter() {
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_horizontal_item, parent, false);
        v.setOnClickListener(mOnClickCardListener);

        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.itemView.setTag(position);

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
