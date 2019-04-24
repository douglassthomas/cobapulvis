package com.example.tes20april;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Home extends androidx.fragment.app.Fragment {



    RecyclerView recyclerView;

    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        List<NotifModel> listNotif = new ArrayList<>();
        listNotif.add(new NotifModel("ID0101", "Udin", "27 April 2019", "terindikasi"));
        listNotif.add(new NotifModel("ID0151", "Ann", "27 April 2019", "waspada"));
        listNotif.add(new NotifModel("ID1233", "Meri", "27 April 2019", "normal"));

        recyclerView = v.findViewById(R.id.homeRV);
        HomeRVAdapter adapter = new HomeRVAdapter(listNotif, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        Button btnSearch = v.findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SearchActivity.class);
                startActivity(i);
            }
        });




        return v;
    }


}
