package com.westqsat.syam.retrofituser.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.westqsat.syam.retrofituser.Dto.NotificationDto;
import com.westqsat.syam.retrofituser.R;

import java.util.List;

/**
 * Created by syam on 28/06/2018.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    Context mContext;
    List<NotificationDto> list;

    public NotificationAdapter(Context mContext, List<NotificationDto> list) {
        this.mContext = mContext;
        this.list = list;
    }

    @NonNull
    @Override
    public NotificationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_item, parent, false);

        NotificationAdapter.ViewHolder viewHolder = new NotificationAdapter.ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NotificationAdapter.ViewHolder holder, int position) {

//        holder.mSubID.setText(list.get(position).getmSubscriberID());
        holder.mSubID.setText(list.get(position).getmNotf_Msg());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mSubID;

        public ViewHolder(View itemView) {
            super(itemView);

            mSubID = itemView.findViewById(R.id.mSubID);

        }
    }
}
