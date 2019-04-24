package com.example.tes20april;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {


    TextView txtSearch;
    ImageButton btnGoSearch;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        txtSearch = findViewById(R.id.txtSearch);
        btnGoSearch = findViewById(R.id.btnGoSearch);




        btnGoSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idnama = txtSearch.getText().toString();
                List<PasienModel> listsearch = new ArrayList<>();

                for(PasienModel p : ListPasien.listPasien){
                    if(p.getNama().contains(idnama)||p.getIdPasien().contains(idnama)){
                        listsearch.add(p);
                        Log.d("namaa", "onClick: "+p.getNama());
                    }
                }

                recyclerView = findViewById(R.id.SearchRV);
                PasienRVAdapter adapter = new PasienRVAdapter(listsearch, getApplicationContext(), 1);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(adapter);
            }
        });

    }






}
