package com.example.asus.ublib_user.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.ublib_user.Model.HistoryResource;
import com.example.asus.ublib_user.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class ListHistoryAdapter extends RecyclerView.Adapter<ListHistoryAdapter.PeminjamanViewHolder> {

    Context context;
    List<HistoryResource> pinjam;

    public ListHistoryAdapter(Context context, List<HistoryResource> pinjam){
        this.context = context;
        this.pinjam = pinjam;
    }

    @NonNull
    @Override
    public PeminjamanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutList = LayoutInflater.from(context).inflate(R.layout.item_history, parent, false);
        PeminjamanViewHolder peminjamanViewHolder = new PeminjamanViewHolder(layoutList);

        return peminjamanViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PeminjamanViewHolder holder, final int position) {

        holder.txtJudul.setText(pinjam.get(position).getJudul().toString());
        holder.txtPengarang.setText(pinjam.get(position).getPengarang().toString());
        holder.txtTanggal.setText(pinjam.get(position).getTglPengembalian().toString());
    }

    @Override
    public int getItemCount() {
        return pinjam.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class PeminjamanViewHolder extends RecyclerView.ViewHolder {

        RoundedImageView imgBuku;
        TextView txtJudul, txtPengarang, txtJenis, txtStatus, txtTanggal;
        CardView itemBuku;

        public PeminjamanViewHolder(@NonNull View itemView) {
            super(itemView);

            txtJudul = itemView.findViewById(R.id.text_judul_buku);
            txtPengarang = itemView.findViewById(R.id.text_pengarang);
            txtTanggal = itemView.findViewById(R.id.tanggal_selesai_peminjaman);
        }
    }
}