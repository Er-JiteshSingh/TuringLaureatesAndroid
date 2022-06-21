package com.turinglaureate.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.turinglaureate.R;
import com.turinglaureate.retrocall.ResponseModel;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private final List<ResponseModel> data;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView year;
        private final TextView citation;
        private final TextView affiliation;
        private final TextView country;
        private final ImageView img;

        public ViewHolder(View view) {
            super(view);

            name = (TextView) view.findViewById(R.id.name);
            year = (TextView) view.findViewById(R.id.year);
            citation = (TextView) view.findViewById(R.id.citation);
            affiliation = (TextView) view.findViewById(R.id.affiliation);
            country = (TextView) view.findViewById(R.id.country);
            img = (ImageView) view.findViewById(R.id.img);

        }

        public TextView getName() {
            return name;
        }

        public TextView getYear() {
            return year;
        }

        public TextView getCitation() {
            return citation;
        }

        public TextView getAffiliation() {
            return affiliation;
        }

        public TextView getCountry() {
            return country;
        }

        public ImageView getImg() {
            return img;
        }

    }

    public CustomAdapter(List<ResponseModel> data) {
        this.data = data;
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

        viewHolder.getName().setText(data.get(position).getName());
        viewHolder.getCitation().setText(data.get(position).getDescription());
        viewHolder.getAffiliation().setText(data.get(position).getAffiliation());
        viewHolder.getCountry().setText(data.get(position).getCountry());
        viewHolder.getYear().setText(data.get(position).getYear());
        Glide.with(viewHolder.name.getContext()).load(data.get(position).getImage()).into(viewHolder.getImg());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
