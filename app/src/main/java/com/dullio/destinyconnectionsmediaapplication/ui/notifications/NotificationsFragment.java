package com.dullio.destinyconnectionsmediaapplication.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dullio.destinyconnectionsmediaapplication.Notification;
import com.dullio.destinyconnectionsmediaapplication.NotificationsAdapter;
import com.dullio.destinyconnectionsmediaapplication.R;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    private List<Notification> notificationList = new ArrayList<>();


    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        recyclerView = root.findViewById(R.id.notifications_recyclerView);

        manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);

        notificationList.add(new Notification("Welcome to your Destiny user dashboard. We are glad you have joined us. Contact us for more information","Destiny Team"));

        adapter = new NotificationsAdapter(getActivity(),notificationList);
        recyclerView.setAdapter(adapter);



        notificationsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }
}