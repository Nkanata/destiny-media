package com.example.busiaonestop;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ServicesRecyclerAdapter extends RecyclerView.Adapter<ServicesRecyclerAdapter.ServicesViewHolder> {


    private Context mContext;
    private List<Services> servicesList = new ArrayList<>();




    public ServicesRecyclerAdapter(Context context, List<Services> services){

        this.servicesList = services;
        this.mContext = context;
    }


    public class ServicesViewHolder extends RecyclerView.ViewHolder{

        //bring member variables textview and image

        TextView mTitle,mDescription;
        ImageView mImageview;
        CardView mCardView;


        public ServicesViewHolder(View view){

            super(view);


            mTitle = (TextView) view.findViewById(R.id.title_textview);
            mDescription = (TextView) view.findViewById(R.id.description_textView);
            mImageview = (ImageView) view.findViewById(R.id.imageResource);
            mCardView = (CardView) view.findViewById(R.id.frame);

        }
    }

    @NonNull
    @Override

    public ServicesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        View view = LayoutInflater.from(mContext).inflate(R.layout.services_list_item,parent,false);
        return new ServicesViewHolder(view);

        
    }

    @Override
    public void onBindViewHolder(@NonNull final ServicesViewHolder holder, final int position){

      final Services services = servicesList.get(position);

       holder.mImageview.setImageDrawable(mContext.getResources().getDrawable(services.getmResource()));
       holder.mTitle.setText(services.getmTitle());
        holder.mDescription.setText(services.getmDescription());
       holder.mCardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(mContext," developed by cosmos ",Toast.LENGTH_SHORT).show();


               switch (holder.getAdapterPosition()){

                   case 0:
                       Intent intent = new Intent(mContext,welcome.class);
                       mContext.startActivity(intent);
                       break;
                   case 1:
                        intent = new Intent(mContext,Drive.class);
                       mContext.startActivity(intent);
                       break;

                   case 2:
                        intent = new Intent(mContext,Immigration.class);
                       mContext.startActivity(intent);
                       break;

                   case 3:
                        intent = new Intent(mContext,Luggage.class);
                       mContext.startActivity(intent);
                       break;

                   case 4:
                        intent = new Intent(mContext,Payment.class);
                       mContext.startActivity(intent);
                       break;

                   case 5:
                        intent = new Intent(mContext,Visa.class);
                       mContext.startActivity(intent);
                       break;

                   case 6:
                       intent = new Intent(mContext,Booking.class);
                       mContext.startActivity(intent);
                       break;

                   case 7:
                       intent = new Intent(mContext,Feedback.class);
                       mContext.startActivity(intent);
                       break;

                   case 8:
                       intent = new Intent(mContext,Report.class);
                       mContext.startActivity(intent);
                       break;
               }
           }
       });

    }

    @Override
    public int getItemCount(){
        return servicesList.size();
    }

}
