package com.dullio.destinyconnectionsmediaapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FAQRecyclerAdapter extends RecyclerView.Adapter<FAQRecyclerAdapter.FAQViewHolder> {

    private Context mContext;
    private List<FAQ> faqList = new ArrayList<>();
    private boolean isFAQOpen = false;

    public FAQRecyclerAdapter (Context context,List<FAQ> faqs){
        this.faqList = faqs;
        this.mContext = context;
    }

    public class FAQViewHolder extends RecyclerView.ViewHolder{
        TextView title,description;
        ImageView pulldown;

        public FAQViewHolder(View view){
            super(view);
            title = view.findViewById(R.id.faq_title);
            description = view.findViewById(R.id.faq_description);
            pulldown = view.findViewById(R.id.faq_pulldown);
        }
    }


    @NonNull
    @Override
    public FAQViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.faq_list_item_layout,parent,false);
        return new FAQViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FAQViewHolder holder, int position) {

        FAQ faq = faqList.get(position);

        int newPosition = holder.getAdapterPosition() +1;
        String title = newPosition+". "+faq.mTitle;
        holder.title.setText(title);
        holder.description.setText(faq.getmDescription());

        holder.pulldown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    holder.description.setVisibility(View.VISIBLE);
                    notifyDataSetChanged();
                    isFAQOpen = true;

            }
        });

    }

    @Override
    public int getItemCount() {
        return faqList.size();
    }
}
