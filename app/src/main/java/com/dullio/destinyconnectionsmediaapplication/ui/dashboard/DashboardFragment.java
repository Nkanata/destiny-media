package com.dullio.destinyconnectionsmediaapplication.ui.dashboard;

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

import com.dullio.destinyconnectionsmediaapplication.DashboardAdapter;
import com.dullio.destinyconnectionsmediaapplication.DashboardItem;
import com.dullio.destinyconnectionsmediaapplication.ItemDecorator;
import com.dullio.destinyconnectionsmediaapplication.R;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter adapter;
    private List<DashboardItem> dashboardItemList = new ArrayList<>();
    private TextView dashboardItemCount;

    // Item Decorator variables
    private static int SPACING = 16,COLUMNS = 1;
    private boolean includeEdges = true;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);


        recyclerView = root.findViewById(R.id.dashboard_recyclerView);

        manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new ItemDecorator(COLUMNS,SPACING,includeEdges));

        dashboardItemList.add(new DashboardItem(getActivity().getResources().getString(R.string.services_module),getResources().getString(R.string.services_module_description),getResources().getString(R.string.services_module_action),R.drawable.services));
        dashboardItemList.add(new DashboardItem(getActivity().getResources().getString(R.string.advertisement_module),getResources().getString(R.string.advertisement_module_description),getResources().getString(R.string.advertisement_module_action),R.drawable.advertising));
        dashboardItemList.add(new DashboardItem(getActivity().getResources().getString(R.string.enquiry_module),getResources().getString(R.string.enquiry_module_description),getResources().getString(R.string.enquiry_module_action),R.drawable.enquiry));
        dashboardItemList.add(new DashboardItem(getActivity().getResources().getString(R.string.events_module),getResources().getString(R.string.events_module_description),getResources().getString(R.string.events_module_action),R.drawable.events_a));
        dashboardItemList.add(new DashboardItem(getActivity().getResources().getString(R.string.feedback_module),getResources().getString(R.string.feedback_module_description),getResources().getString(R.string.feedback_module_action),R.drawable.feedback));
        dashboardItemList.add(new DashboardItem(getActivity().getResources().getString(R.string.contact_module),getResources().getString(R.string.contact_module_description),getResources().getString(R.string.contact_module_action),R.drawable.contact_us));



        adapter = new DashboardAdapter(getActivity(),dashboardItemList);
        recyclerView.setAdapter(adapter);


        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }


}