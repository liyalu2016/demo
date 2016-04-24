package com.example.liyalu.myapplication.test;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        String[] dataSet = {"test1", "test2"};
        mAdapter = new AppCardAdapter(dataSet);
        mRecyclerView.setAdapter(mAdapter);
    }

    public class AppCardViewHolder extends RecyclerView.ViewHolder {

        public AppCardViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class AppCardAdapter extends RecyclerView.Adapter<AppCardViewHolder> {
        private String[] mDataSet;

        public AppCardAdapter(String[] dataSet) {
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
            TextView v = (TextView) holder.itemView.findViewById(R.id.app_name);

            v.setText(mDataSet[position]);
        }

        @Override
        public int getItemCount() {
            return mDataSet.length;
        }
    }


}
