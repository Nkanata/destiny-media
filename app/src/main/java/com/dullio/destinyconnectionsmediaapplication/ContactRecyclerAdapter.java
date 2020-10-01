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
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_MULTIPLE_TASK;

public class ContactRecyclerAdapter extends RecyclerView.Adapter<ContactRecyclerAdapter.ContactViewHolder> {

     private Context mContext;
    private List<DashboardItem> dashboardItemList = new ArrayList<>();
    private static String EMAIL_ADDRESS ="mailto:contact@destinyfm.co.ke";

    public ContactRecyclerAdapter (Context context, List<DashboardItem> dashboardItemList){
        this.dashboardItemList = dashboardItemList;
        this.mContext = context;
    }


    public class ContactViewHolder extends RecyclerView.ViewHolder{

        TextView mTitle, mDescription,mAction;
        ImageView itemImage;

        public ContactViewHolder (View v){
            super(v);

            mTitle = v.findViewById(R.id.detailed_dashboard_title);
            mDescription = v.findViewById(R.id.detailed_dashboard_description);
            mAction = v.findViewById(R.id.detailed_dashboard_action);
            itemImage = v.findViewById(R.id.detailed_dashboard_imageView);
        }

    }



    @NonNull
    @java.lang.Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.detailed_dashboard_list_item,parent,false);
        return new ContactViewHolder(v);
    }

    @java.lang.Override
    public void onBindViewHolder(@NonNull final ContactViewHolder holder, int position) {

        DashboardItem dashboardItem = dashboardItemList.get(position);

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
                    mContext.startActivity(intent);
                }
                if (holder.getAdapterPosition()==1){
                    // Call destiny
                   // makePhoneCall(mContext.getResources().getString(R.string.phone));
                }
                if (holder.getAdapterPosition()==2){
                    // email
                   // sendEmail();
                }

            }
        });
    }

    @java.lang.Override
    public int getItemCount() {
        return dashboardItemList.size();
    }

    private void sendEmail (){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:contact@destinyfm.co.ke"));

        if (intent.resolveActivity(mContext.getPackageManager())!= null){
           mContext.startActivity(intent);
        }

    }


    private void makePhoneCall(String phoneNumber){

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+phoneNumber));

        if (intent.resolveActivity(mContext.getPackageManager()) != null){
            mContext.startActivity(intent);
        }

    }



}
