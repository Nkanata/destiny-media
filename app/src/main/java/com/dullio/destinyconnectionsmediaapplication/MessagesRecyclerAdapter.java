package com.dullio.destinyconnectionsmediaapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MessagesRecyclerAdapter extends RecyclerView.Adapter<MessagesRecyclerAdapter.MessagesViewHolder> {

    private Context mContext;
    private List<Message> messageList = new ArrayList<>();

    public MessagesRecyclerAdapter(Context context, List<Message> messages){
        this.mContext  = context;
        this.messageList = messages;
    }


    public class MessagesViewHolder extends RecyclerView.ViewHolder{
        TextView mContent, mTimeStamp,senderContent,senderTimeStamp;
        LinearLayout myLayout,senderLayout;
        public MessagesViewHolder (View view){
            super(view);

           mTimeStamp = view.findViewById(R.id.my_messages_timestamp);
           mContent = view.findViewById(R.id.my_messages_title);
           senderContent = view.findViewById(R.id.message_title);
           senderTimeStamp = view.findViewById(R.id.message_timestamp);
           myLayout = view.findViewById(R.id.my_message_layout);
           senderLayout = view.findViewById(R.id.message_layout);
        }
    }

    @NonNull
    @Override
    public MessagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.messages_item_layout,parent,false);
        return new MessagesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessagesViewHolder holder, int position) {

        Message message = messageList.get(position);

        if (message.isMine()){
            holder.myLayout.setVisibility(View.VISIBLE);
            holder.senderLayout.setVisibility(View.GONE);
            holder.mContent.setText(message.getmContent());
        }
        else {
            holder.senderLayout.setVisibility(View.VISIBLE);
            holder.myLayout.setVisibility(View.GONE);
            holder.senderContent.setText(message.getmContent());
        }

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }
}
