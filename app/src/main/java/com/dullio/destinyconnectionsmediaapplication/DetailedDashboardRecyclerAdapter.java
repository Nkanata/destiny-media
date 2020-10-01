package com.dullio.destinyconnectionsmediaapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_MULTIPLE_TASK;

public class DetailedDashboardRecyclerAdapter extends RecyclerView.Adapter<DetailedDashboardRecyclerAdapter.MyViewHolder> {

    private Context mContext;
    private List<DashboardItem> dashboardItemList = new ArrayList<>();

    public DetailedDashboardRecyclerAdapter (Context context,List<DashboardItem>dashboardItemList){

        this.mContext = context;
        this.dashboardItemList = dashboardItemList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mTitle, mDescription,mAction;
        ImageView itemImage;
        public MyViewHolder(View view){
            super(view);

            mTitle = view.findViewById(R.id.detailed_dashboard_title);
            mDescription = view.findViewById(R.id.detailed_dashboard_description);
            mAction = view.findViewById(R.id.detailed_dashboard_action);
            itemImage = view.findViewById(R.id.detailed_dashboard_imageView);
        }


    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.detailed_dashboard_list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        final DashboardItem dashboardItem = dashboardItemList.get(position);

        holder.itemImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
        holder.itemImage.setImageDrawable(mContext.getResources().getDrawable(dashboardItem.getmResource()));
        holder.mAction.setText(dashboardItem.getmAction());
        holder.mDescription.setText(dashboardItem.getmDescription());
        holder.mTitle.setText(dashboardItem.getmTitle());

        holder.mAction.setOnClickListener(new View.OnClickListener() {
            @java.lang.Override
            public void onClick(View view) {

                if(holder.getAdapterPosition()== 0){
                    // Visiting appointment
                    Intent intent = new Intent(mContext,VisitingActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|FLAG_ACTIVITY_MULTIPLE_TASK);
                    intent.putExtra("title",dashboardItem.getmTitle());
                    mContext.startActivity(intent);
                }
                if (holder.getAdapterPosition()==1){
                    makePhoneCall(mContext.getResources().getString(R.string.phone));
                }
                if (holder.getAdapterPosition()==2){
                    // email
                    sendEmail();
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return dashboardItemList.size();
    }


    private void sendEmail (){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:contact@destinyfm.co.ke"));

        if (intent.resolveActivity(mContext.getPackageManager())!= null){
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|FLAG_ACTIVITY_MULTIPLE_TASK);
            mContext.startActivity(intent);
        }

    }


    private void makePhoneCall(String phoneNumber){

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+phoneNumber));

        if (intent.resolveActivity(mContext.getPackageManager()) != null){
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|FLAG_ACTIVITY_MULTIPLE_TASK);
            mContext.startActivity(intent);
        }

    }

}
