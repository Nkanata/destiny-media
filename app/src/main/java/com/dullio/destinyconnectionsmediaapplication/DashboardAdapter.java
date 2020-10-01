package com.dullio.destinyconnectionsmediaapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder> {

    private Context mContext;
    private List<DashboardItem> dashboardItemList = new ArrayList<>();

    public DashboardAdapter (Context context, List<DashboardItem> dashboardItemList){
        this.dashboardItemList = dashboardItemList;
        this.mContext = context;
    }


    public class DashboardViewHolder extends RecyclerView.ViewHolder{

        TextView mTitle, mDescription,mAction;
        ImageView itemImage;

        public DashboardViewHolder (View v){
            super(v);

            mTitle = v.findViewById(R.id.dashboard_title);
            mDescription = v.findViewById(R.id.dashboard_description);
            mAction = v.findViewById(R.id.dashboard_action);
            itemImage = v.findViewById(R.id.dashboard_imageView);
        }
    }


    @NonNull
    @java.lang.Override
    public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.dashboard_list_item_layout,parent,false);
        return new DashboardViewHolder(v);
    }

    @java.lang.Override
    public void onBindViewHolder(@NonNull final DashboardViewHolder holder, int position) {

        DashboardItem dashboardItem = dashboardItemList.get(position);

        holder.itemImage.setImageDrawable(mContext.getResources().getDrawable(dashboardItem.getmResource()));
        holder.mAction.setText(dashboardItem.getmAction());
        holder.mDescription.setText(dashboardItem.getmDescription());
        holder.mTitle.setText(dashboardItem.getmTitle());
        if (holder.getAdapterPosition() == 1){
            holder.itemImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        holder.mAction.setOnClickListener(new View.OnClickListener() {
            @java.lang.Override
            public void onClick(View view) {
                Intent intent = null;
                switch (holder.getAdapterPosition()){
                    case 0:
                        intent = new Intent(mContext,ServiceActivity.class);
                        mContext.startActivity(intent);
                        break;

                    case 1:
                        intent = new Intent(mContext,AdvertisementActivity.class);
                        mContext.startActivity(intent);
                        break;

                    case 2:

                        intent = new Intent(mContext,EnquiryActivity.class);
                        mContext.startActivity(intent);
                        break;

                    case 3:

                        intent = new Intent(mContext,EventsActivity.class);
                        mContext.startActivity(intent);
                        break;

                    case 4:

                        intent = new Intent(mContext,HelpAndFeedbackActivity.class);
                        mContext.startActivity(intent);
                        break;

                    case 5:
                        intent = new Intent(mContext,ContactActivity.class);
                        mContext.startActivity(intent);
                        break;

                        default:
                }
            }
        });
    }

    @java.lang.Override
    public int getItemCount() {
        return dashboardItemList.size();
    }
}
