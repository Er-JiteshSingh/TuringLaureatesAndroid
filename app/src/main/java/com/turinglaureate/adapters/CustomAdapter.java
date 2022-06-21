package com.turinglaureate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.turinglaureate.R;
import com.turinglaureate.activities.LaureatesActivity;
import com.turinglaureate.modals.LaureateData;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    //    private String[] localDataSet;
    private final Context mContext;
    private final List<LaureateData> mDataList;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public ViewHolder(View view) {
            super(view);

            textView = (TextView) view.findViewById(R.id.name);
        }

        public TextView getTextView() {
            return textView;
        }
    }

    //    public CustomAdapter(LaureatesActivity laureatesActivity, String[] dataSet, Context mContext) {
    public CustomAdapter(Context mContext, List<LaureateData> mDataList) {
        this.mContext = mContext;
        this.mDataList = mDataList;
//            localDataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.laureates, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        CityDataItem cityDataItem = mDataList.get(position);
        holder.textView.setText(cityDataItem.getCityName());

        viewHolder.getTextView().setText(localDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return localDataSet.length;
    }
}
