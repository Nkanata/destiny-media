package com.dullio.destinyconnectionsmediaapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_MULTIPLE_TASK;

public class ContactBottomSheet extends BottomSheetDialogFragment {

    private ListView listView;
    private ContactListViewAdapter adapter;
    private List<ListViewContact> contactList = new ArrayList<>();


    public ContactBottomSheet(){
        // Required empty constructor
    }

    @Override
    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }


    @Nullable
    @java.lang.Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.contact_bottomsheet_layout,container,false);

        listView = v.findViewById(R.id.contact_bottomsheet_listView);

        contactList.add(new ListViewContact(getActivity().getResources().getString(R.string.phone),R.drawable.ic_phone_black_24dp));
        contactList.add(new ListViewContact(getActivity().getResources().getString(R.string.alternative_phone),R.drawable.ic_phone_black_24dp));

        adapter = new ContactListViewAdapter(getActivity(),contactList);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @java.lang.Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               if (i ==0){
                   //Call with number
                   makePhoneCall(contactList.get(i).getmTitle());
                   dismiss();
               }
               else if(i==1){
                   makePhoneCall(contactList.get(i).getmTitle());
               }

            }
        });



        return v;
    }

    private void makePhoneCall(String phoneNumber){

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+phoneNumber));

        if (intent.resolveActivity(getActivity().getPackageManager()) != null){
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|FLAG_ACTIVITY_MULTIPLE_TASK);
            getActivity().startActivity(intent);
        }

    }

}
