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

import static android.content.Intent.FLAG_ACTIVITY_MULTIPLE_TASK;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder> {

    private Context mContext;
    private List<DashboardItem> servicesItemList = new ArrayList<>();

    public ServicesAdapter(Context context,List<DashboardItem> dashboardItemList){
        this.servicesItemList = dashboardItemList;
        this.mContext = context;
    }


    public class ServicesViewHolder extends RecyclerView.ViewHolder{

        TextView mTitle, mDescription,mAction;
        ImageView itemImage;

        public ServicesViewHolder(View view){
            super(view);

            mTitle = view.findViewById(R.id.detailed_dashboard_title);
            mDescription = view.findViewById(R.id.detailed_dashboard_description);
            mAction = view.findViewById(R.id.detailed_dashboard_action);
            itemImage = view.findViewById(R.id.detailed_dashboard_imageView) ;
        }
    }


    @NonNull
    @java.lang.Override
    public ServicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.detailed_dashboard_list_item,parent,false);
        return new ServicesViewHolder(v);
    }

    @java.lang.Override
    public void onBindViewHolder(@NonNull ServicesViewHolder holder, final int position) {

        final DashboardItem dashboardItem = servicesItemList.get(position);

        if (holder.getAdapterPosition()==0){
            holder.itemImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        holder.itemImage.setImageDrawable(mContext.getResources().getDrawable(dashboardItem.getmResource()));
        holder.mAction.setText(dashboardItem.getmAction());
        holder.mDescription.setText(dashboardItem.getmDescription());
        holder.mTitle.setText(dashboardItem.getmTitle());

        holder.mAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent ;
                switch (position){
                    case 0:
                        intent = new Intent(mContext,TrainingActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|FLAG_ACTIVITY_MULTIPLE_TASK);
                        intent.putExtra("title",dashboardItem.getmTitle());
                        mContext.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(mContext,RedirectionActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|FLAG_ACTIVITY_MULTIPLE_TASK);
                        intent.putExtra("title",dashboardItem.getmTitle());
                        mContext.startActivity(intent);
                        break;
                        default:
                }

            }
        });



    }

    @java.lang.Override
    public int getItemCount() {
        return servicesItemList.size();
    }
}
