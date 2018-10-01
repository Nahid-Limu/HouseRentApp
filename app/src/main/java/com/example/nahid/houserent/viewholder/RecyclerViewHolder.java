package com.example.nahid.houserent.viewholder;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nahid.houserent.R;

/**
 * Created by Nahid on 29-Jul-17.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView type, rent, details,phone, date;
    public ImageButton call;

    public RecyclerViewHolder(View itemView) {
        super(itemView);


        type = (TextView) itemView.findViewById(R.id.type);
        rent = (TextView) itemView.findViewById(R.id.rent);
        details = (TextView) itemView.findViewById(R.id.details);
        phone = (TextView) itemView.findViewById(R.id.phone);
        date = (TextView) itemView.findViewById(R.id.date);
        call = (ImageButton) itemView.findViewById(R.id.call);

    }
}
