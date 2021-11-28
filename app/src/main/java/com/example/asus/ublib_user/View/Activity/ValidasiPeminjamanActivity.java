package com.example.asus.ublib_user.View.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.asus.ublib_user.Interface.ValidasiInterface;
import com.example.asus.ublib_user.Model.ValidasiResource;
import com.example.asus.ublib_user.Model.ValidasiResponse;
import com.example.asus.ublib_user.R;
import com.example.asus.ublib_user.Service.Config;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ValidasiPeminjamanActivity extends AppCompatActivity {

    TextView txtKode, txtJudul, txtPengarang, txtJenis, txtDesc;

    List<ValidasiResource> validasi = new ArrayList<>();
    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validasi_peminjaman);

        txtKode = findViewById(R.id.text_kode_peminjaman);
        txtJudul = findViewById(R.id.text_judul_buku);
        txtPengarang = findViewById(R.id.text_pengarang_buku);
        txtJenis = findViewById(R.id.text_jenis_buku);
        txtDesc = findViewById(R.id.text_desc_buku);

        Intent intent = getIntent();
        final String id = intent.getStringExtra("id_pinjam");
        Log.d("dataaaaa", "id_pinjam = "+id);
        sharedPreferences = getSharedPreferences(KEYPREF, MODE_PRIVATE);
        SharedPreferences.Editor data = sharedPreferences.edit();
        data.putString("id_pinjam", id);
        data.commit();
        data.apply();

        ValidasiInterface validasiInterface = Config.builder(ValidasiPeminjamanActivity.this)
                .create(ValidasiInterface.class);
        final Call<ValidasiResponse> validasiBuku = validasiInterface.detailVal(id);
        validasiBuku.enqueue(new Callback<ValidasiResponse>() {
            @Override
            public void onResponse(Call<ValidasiResponse> call, Response<ValidasiResponse> response) {
                Log.d("dataaaaa", "masuk response");
                validasi = response.body().getSuccess();
                Log.d("dataaaaa", "data = "+validasi);
                if (validasi != null){
                    txtKode.setText(validasi.get(0).getId().toString());
                    txtJudul.setText(validasi.get(0).getJudul().toString());
                    txtPengarang.setText(validasi.get(0).getPengarang().toString());
                    txtJenis.setText(validasi.get(0).getNama().toString());
                    txtDesc.setText(validasi.get(0).getNim().toString());

                }

            }

            @Override
            public void onFailure(Call<ValidasiResponse> call, Throwable t) {

            }
        });
    }
}
