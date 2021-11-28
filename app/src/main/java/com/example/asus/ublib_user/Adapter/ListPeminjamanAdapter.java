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
import com.example.asus.ublib_user.Model.PeminjamanResource;
import com.example.asus.ublib_user.R;
import com.example.asus.ublib_user.View.Activity.ValidasiPeminjamanActivity;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class ListPeminjamanAdapter extends RecyclerView.Adapter<ListPeminjamanAdapter.PeminjamanViewHolder> {

    Context context;
    List<PeminjamanResource> pinjam;

    public ListPeminjamanAdapter(Context context, List<PeminjamanResource> pinjam){
        this.context = context;
        this.pinjam = pinjam;
    }

    @NonNull
    @Override
    public PeminjamanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutList = LayoutInflater.from(context).inflate(R.layout.item_peminjaman, parent, false);
        PeminjamanViewHolder peminjamanViewHolder = new PeminjamanViewHolder(layoutList);

        return peminjamanViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PeminjamanViewHolder holder, final int position) {
        Glide.with(context)
                .load("http://192.168.1.3/ublib/public/uploads/file/"+pinjam.get(position).getGambar().toString())
                .into(holder.imgBuku);
        holder.txtJudul.setText(pinjam.get(position).getJudul().toString());
        holder.txtPengarang.setText(pinjam.get(position).getPengarang().toString());
        holder.txtJenis.setText(pinjam.get(position).getJenis().toString());
        holder.txtStatus.setText(pinjam.get(position).getStatusPeminjaman().toString());
        holder.txtTanggal.setText(pinjam.get(position).getTglPeminjaman().toString());

        holder.itemBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ValidasiPeminjamanActivity.class);
                intent.putExtra("id_pinjam", pinjam.get(position).getId().toString());
                v.getContext().startActivity(intent);
            }
        });
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

            imgBuku =itemView.findViewById(R.id.gambar_buku);
            txtJudul = itemView.findViewById(R.id.text_judul_buku);
            txtPengarang = itemView.findViewById(R.id.text_pengarang);
            txtJenis = itemView.findViewById(R.id.text_jenis_buku);
            txtStatus = itemView.findViewById(R.id.text_status_peminjaman);
            txtTanggal = itemView.findViewById(R.id.text_tanggal_ambil);

            itemBuku = itemView.findViewById(R.id.card_peminjaman);
        }
    }
}
