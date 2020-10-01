package com.dullio.destinyconnectionsmediaapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ContactListViewAdapter extends ArrayAdapter<ListViewContact> {


    private Context mContext;
    private List<ListViewContact> listViewContactList =  new ArrayList<>();


    public ContactListViewAdapter(Context context,List<ListViewContact> listViewContactList){
        super(context,0,listViewContactList);

        this.listViewContactList = listViewContactList;
        this.mContext = context;
    }


    @NonNull
    @java.lang.Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if (view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.contact_bottomsheet_list_item_layout,parent,false);
        }

        ListViewContact listViewContact = listViewContactList.get(position);

        TextView textView = view.findViewById(R.id.listView_textView);
        textView.setText(listViewContact.getmTitle());
        textView.setCompoundDrawablesWithIntrinsicBounds(mContext.getResources().getDrawable(listViewContact.getmResource()),null,null,null);

        return view;
    }
}
