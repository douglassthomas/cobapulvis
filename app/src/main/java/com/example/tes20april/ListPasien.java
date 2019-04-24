package com.example.tes20april;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class ListPasien extends Fragment {


    public static List<PasienModel> listPasien = new ArrayList<>();

    public ListPasien() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        listPasien.add(new PasienModel("ID010101", "Bejo", "normal"));
        listPasien.add(new PasienModel("ID01051", "Brandon", "terindikasi"));
        listPasien.add(new PasienModel("KO0098", "Bejo", "waspada"));


        View v = inflater.inflate(R.layout.fragment_list_pasien, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.ListPasienRV);
        PasienRVAdapter adapter = new PasienRVAdapter(listPasien, getContext(), 0);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return v;
    }


}
