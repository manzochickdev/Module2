package com.example.tuananh.module2.Nearby;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tuananh.module2.Model;
import com.example.tuananh.module2.R;
import com.example.tuananh.module2.databinding.LayoutPeopleNearbyBinding;

import java.util.ArrayList;

class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    ArrayList<Model> models;
    Context context;

    public Adapter(ArrayList<Model> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_people_nearby,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //todo tat test mode
        //viewHolder.layoutPeopleNearbyBinding.setModel(models.get(i));
        viewHolder.layoutPeopleNearbyBinding.setModel(null);
        viewHolder.layoutPeopleNearbyBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
//        return models.size();
        return 5;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        LayoutPeopleNearbyBinding layoutPeopleNearbyBinding;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutPeopleNearbyBinding = DataBindingUtil.bind(itemView);
        }
    }
}
