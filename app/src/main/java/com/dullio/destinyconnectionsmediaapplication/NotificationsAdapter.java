package com.dullio.destinyconnectionsmediaapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotificationsAdapter extends RecyclerView.Adapter<NotificationsAdapter.NotificationsViewHolder> {

    private Context mContext;
    private List<Notification> mDataset = new ArrayList<>();

    public NotificationsAdapter(Context context,List<Notification> notifications){
        this.mContext = context;
        this.mDataset = notifications;
    }

    public class NotificationsViewHolder extends RecyclerView.ViewHolder{

        TextView description,timestamp,sender;
        ImageView imageResource;
        LinearLayout layout;

        public NotificationsViewHolder(View view){
            super(view);

            sender = view.findViewById(R.id.notification_title);
            description = view. findViewById(R.id.notification_description);
            timestamp = view.findViewById(R.id.notification_timestamp);
            imageResource = view.findViewById(R.id.notification_image);
            layout = view.findViewById(R.id.notification_layout);

        }

    }


    @NonNull
    @java.lang.Override
    public NotificationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.notifications_list_item_layout,parent,false);

        return new NotificationsViewHolder(view);
    }

    @java.lang.Override
    public void onBindViewHolder(@NonNull NotificationsViewHolder holder, int position) {

        final Notification notification = mDataset.get(position);
        holder.imageResource.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_account_circle_black_24dp));
        holder.timestamp.setText(notification.getmTimeStamp());
        holder.description.setText(notification.getmDescription());
        holder.sender.setText(notification.getmSender());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext,DetailedNotificationsActivity.class);
                intent.putExtra("message",notification.getmDescription());
                intent.putExtra("sender",notification.getmSender());
                intent.putExtra("timestamp",notification.getmTimeStamp());
                mContext.startActivity(intent);
            }
        });
    }

    @java.lang.Override
    public int getItemCount() {
        return mDataset.size();
    }
}
