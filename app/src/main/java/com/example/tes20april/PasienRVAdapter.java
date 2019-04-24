package com.example.tes20april;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class PasienViewHolder extends RecyclerView.ViewHolder{

    TextView pasienId;
    TextView pasienName;

    public PasienViewHolder(@NonNull View itemView) {
        super(itemView);

        pasienId = itemView.findViewById(R.id.txtPasienId);
        pasienName = itemView.findViewById(R.id.txtPasienNama);

    }

    void init(PasienModel p){
        if(p.getStatus().equals("normal")) pasienId.setBackgroundColor(itemView.getResources().getColor(R.color.colorNormal));
        if(p.getStatus().equals("waspada")) pasienId.setBackgroundColor(itemView.getResources().getColor(R.color.colorKuning));
        if(p.getStatus().equals("terindikasi")) pasienId.setBackgroundColor(itemView.getResources().getColor(R.color.colorMerah));

        pasienId.setText(p.getIdPasien());
        pasienName.setText(p.getNama());
    }
}

public class PasienRVAdapter extends RecyclerView.Adapter<PasienViewHolder> {
    List<PasienModel> listPasien;
    Context mCtx;
    int kode;

    public PasienRVAdapter(List<PasienModel> listPasien, Context mCtx, int kode) {
        this.listPasien = listPasien;
        this.mCtx = mCtx;
        this.kode = kode;
    }

    @NonNull
    @Override
    public PasienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(kode==0) return new PasienViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.cardpasien, parent, false));
        else return new PasienViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.cardsearch, parent, false));


    }

    @Override
    public void onBindViewHolder(@NonNull PasienViewHolder holder, int position) {
        holder.init(listPasien.get(position));
    }

    @Override
    public int getItemCount() {
        return listPasien.size();
    }
}
