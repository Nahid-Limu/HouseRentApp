package com.example.nahid.houserent.adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nahid.houserent.R;
import com.example.nahid.houserent.activity.CallListener;
import com.example.nahid.houserent.model.UserModel;
import com.example.nahid.houserent.viewholder.RecyclerViewHolder;

import java.util.List;

/**
 * Created by Nahid on 29-Jul-17.
 */

public class RecylarViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<UserModel> item;

    CallListener callListener;

    public RecylarViewAdapter(List<UserModel> item, CallListener callListener) {
        this.item = item;
        this.callListener = callListener;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_view, null);

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(layoutView);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {

        holder.type.setText(item.get(position).getType());
        holder.rent.setText(item.get(position).getRent());
        holder.details.setText(item.get(position).getDetails());
        holder.phone.setText(item.get(position).getPhone());
        holder.date.setText(item.get(position).getDate());



        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                callListener.call(holder.phone.getText().toString());

            }
        });

    }

    @Override
    public int getItemCount() {
        return item.size();
    }
}
