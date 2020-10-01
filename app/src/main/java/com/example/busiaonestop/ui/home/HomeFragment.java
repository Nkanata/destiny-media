package com.example.busiaonestop.ui.home;

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

import com.example.busiaonestop.R;
import com.example.busiaonestop.Services;
import com.example.busiaonestop.ServicesRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.example.busiaonestop.R.drawable.booking;
import static com.example.busiaonestop.R.drawable.drive;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Services> servicesList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = root.findViewById(R.id.servicesRecyclerview);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        servicesList.add(new Services("GUEST","Please provide your details before proceeding.this will help us to serve you well",R.drawable.report));
        servicesList.add(new Services("DRIVE","Our procedures vary depending on what kind of transport your in ,time of the day and how much luggage you or your vehicle are carrying",R.drawable.drive));
        servicesList.add(new Services("IMMIGRATION","Our immigration procedures at Busia Border are straight forward.All you need to have is exit/entry card....",R.drawable.imigration));
        servicesList.add(new Services("LUGGAGE CHECK","Kindly note that your luggage will be checked by our officers and your will be cleared after paying the custom tax as usual", R.drawable.drive));
        servicesList.add(new Services("PAYMENT","Payment will be made depending on the luggage your carrying across the border as custom",R.drawable.payment));
        servicesList.add(new Services("VISA","you will be issued your visa or passport before crossing the border, your can also get tempor....",R.drawable.visa));
        servicesList.add(new Services("BOOKING"," Busia One Stop Border Post offer booking services to our customers wishing to travelling to Kamapala Uganda and other regions",R.drawable.drive));
        servicesList.add(new Services("FEEDBACK","please provide us with your feedback regarding our services .....",R.drawable.feedback));
        servicesList.add(new Services("REPORT","you can read our report",R.drawable.report));

        adapter = new ServicesRecyclerAdapter(getContext(),servicesList);
        recyclerView.setAdapter(adapter);


        return root;
    }
}