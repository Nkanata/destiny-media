package com.dullio.destinyconnectionsmediaapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class VisitingAppointmentAdapter extends RecyclerView.Adapter<VisitingAppointmentAdapter.VisitingAppointmentViewHolder> {

    private Context mContext;
    private List<VisitingAppointment> visitingAppointmentList = new ArrayList<>();

    public VisitingAppointmentAdapter (Context context, List<VisitingAppointment>visitingAppointmentList){
        this.mContext = context;
        this.visitingAppointmentList = visitingAppointmentList;
    }

    public class VisitingAppointmentViewHolder extends RecyclerView.ViewHolder{
        EditText textView;
        public VisitingAppointmentViewHolder(View view){
            super(view);

            textView = view.findViewById(R.id.detail_form_textView);
        }
    }


    @NonNull
    @java.lang.Override
    public VisitingAppointmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.user_details_form_layout,parent,false);
        return new VisitingAppointmentViewHolder(view);
    }

    @java.lang.Override
    public void onBindViewHolder(@NonNull final VisitingAppointmentViewHolder holder, int position) {

        VisitingAppointment appointment = visitingAppointmentList.get(position);

        holder.textView.setHint(appointment.getmTitle());
        holder.textView.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(appointment.getmResource()),null,null,null);

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @java.lang.Override
            public void onClick(View view) {
                switch (holder.getAdapterPosition()){
                    case 4:
                        // Date picker
                        openDatePicker(holder.textView);
                        break;
                    case 5:
                        // Time picker
                        openTimePicker(holder.textView);
                        break;

                        default:
                            // Do nothing
                }
            }
        });

    }

    @java.lang.Override
    public int getItemCount() {
        return visitingAppointmentList.size();
    }

    private void openDatePicker(TextView textView){

    }


    private void openTimePicker(TextView textView){

    }
}
