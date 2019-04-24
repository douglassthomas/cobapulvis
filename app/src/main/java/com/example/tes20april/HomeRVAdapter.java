package com.example.tes20april;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class HomeRVViewHolder extends RecyclerView.ViewHolder {

    TextView idPasien;
    TextView namaPasien;
    TextView tanggal;


    public HomeRVViewHolder(@NonNull View itemView) {
        super(itemView);

        idPasien = itemView.findViewById(R.id.txtIdPasien);
        namaPasien = itemView.findViewById(R.id.txtNamaPasien);
        tanggal = itemView.findViewById(R.id.txtTanggal);


    }

    void init(NotifModel n){
        if(n.getStatus().equals("normal")) idPasien.setBackgroundColor(itemView.getResources().getColor(R.color.colorNormal));
        else if(n.getStatus().equals("waspada")) idPasien.setBackgroundColor(itemView.getResources().getColor(R.color.colorKuning));
        else if(n.getStatus().equals("terindikasi")) idPasien.setBackgroundColor(itemView.getResources().getColor(R.color.colorMerah));

        idPasien.setText(n.getIdPasien());
        namaPasien.setText(n.getNamaPasien());
        tanggal.setText(n.getTanggal());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(itemView.getContext(), PasienOverview.class);
                itemView.getContext().startActivity(i);
            }
        });
    }

}

public class HomeRVAdapter extends RecyclerView.Adapter<HomeRVViewHolder> {
    List<NotifModel> listNotif;
    Context mCtx;

    public HomeRVAdapter(List<NotifModel> listNotif, Context mCtx) {
        this.listNotif = listNotif;
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public HomeRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeRVViewHolder(LayoutInflater.from(mCtx).inflate(R.layout.notifcard, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRVViewHolder holder, int position) {
        holder.init(listNotif.get(position));
    }

    @Override
    public int getItemCount() {
        return listNotif.size();
    }
}
