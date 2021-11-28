package com.example.asus.ublib_user.View.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.asus.ublib_user.Interface.AddPeminjamanInterface;
import com.example.asus.ublib_user.Model.AddPeminjamanResource;
import com.example.asus.ublib_user.Model.AddPeminjamanResponse;
import com.example.asus.ublib_user.R;
import com.example.asus.ublib_user.Service.Config;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeminjamanActivity extends AppCompatActivity {

    EditText formNama, formNIM, formJudul, formPengarang, formTglPinjam, formTglKembali;
    RelativeLayout btnLanjut;

    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferences;

    String nama, nim, judul, pengarang, tgl_peminjaman, tgl_pengembalian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peminjaman);

        formNama = findViewById(R.id.form_nama);
        formNIM = findViewById(R.id.form_nim);
        formJudul = findViewById(R.id.form_judul_buku);
        formPengarang = findViewById(R.id.form_pengarang);
        formTglPinjam = findViewById(R.id.form_tanggal_peminjaman);
        formTglKembali = findViewById(R.id.form_tanggal_pengembalian);

        btnLanjut = findViewById(R.id.btn_lanjut);

        sharedPreferences = getSharedPreferences(KEYPREF, MODE_PRIVATE);
        final String id = sharedPreferences.getString("id_user", null);

        String tjudul = getIntent().getStringExtra("judul");
        String tpengarang = getIntent().getStringExtra("pengarang");
        String tnama = sharedPreferences.getString("nama", null);
        String tnim = sharedPreferences.getString("nim", null);

        Intent intent = getIntent();
        final String id_buku = intent.getStringExtra("id_buku");
        Log.d("dataaaaa", "id_buku = "+id_buku);
        sharedPreferences = getSharedPreferences(KEYPREF, MODE_PRIVATE);
        SharedPreferences.Editor data = sharedPreferences.edit();
        data.putString("id_buku", id_buku);
        data.commit();
        data.apply();

        formNama.setText(tnama);
        formNIM.setText(tnim);
        formJudul.setText(tjudul);
        formPengarang.setText(tpengarang);

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nama = formNama.getText().toString();
                nim = formNIM.getText().toString();
                judul = formJudul.getText().toString();
                pengarang = formPengarang.getText().toString();
                tgl_peminjaman = formTglPinjam.getText().toString();
                tgl_pengembalian = formTglKembali.getText().toString();


                String id_admin = getIntent().getStringExtra("id_admin");

                AddPeminjamanInterface addPeminjamanInterface = Config.builder(PeminjamanActivity.this)
                        .create(AddPeminjamanInterface.class);
                Log.d("dataaaaaaaaaaaa","data = "+nama);
                Log.d("dataaaaaaaaaaaa","data = "+nim);
//                Log.d("dataaaaaaaaaaaa","data = "+judul);
//                Log.d("dataaaaaaaaaaaa","data = "+pengarang);
//                Log.d("dataaaaaaaaaaaa","data = "+tgl_peminjaman);
//                Log.d("dataaaaaaaaaaaa","data = "+tgl_pengembalian);
                Log.d("dataaaaaaaaaaaa","data = "+id);
                Log.d("dataaaaaaaaaaaa","data = "+id_admin);
                Log.d("dataaaaaaaaaaaa","data = "+id_buku);
                Call<AddPeminjamanResponse> pinjam = addPeminjamanInterface.tambahPeminjaman(nama, nim, judul, pengarang, tgl_peminjaman, tgl_pengembalian, id, id_admin, id_buku);
                pinjam.enqueue(new Callback<AddPeminjamanResponse>() {
                    @Override
                    public void onResponse(Call<AddPeminjamanResponse> call, Response<AddPeminjamanResponse> response) {

                        AddPeminjamanResource masuk = response.body().getSuccess();
                        Log.d("dataaaa", "add"+masuk);
                        if (masuk != null){

                            Intent intent = new Intent(PeminjamanActivity.this, MainActivity.class);
                            Toast.makeText(PeminjamanActivity.this, "Pemesanan anda sedang diproses", Toast.LENGTH_LONG).show();
                            startActivity(intent);

                        }

                    }

                    @Override
                    public void onFailure(Call<AddPeminjamanResponse> call, Throwable t) {

                    }
                });
            }
        });
    }
}
