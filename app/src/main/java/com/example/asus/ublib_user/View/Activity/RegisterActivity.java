package com.example.asus.ublib_user.View.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.ublib_user.Interface.RegisterInterface;
import com.example.asus.ublib_user.Model.RegisterResponse;
import com.example.asus.ublib_user.R;
import com.example.asus.ublib_user.Service.Config;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    EditText formNIM, formNama, formFakultas, formProdi, formPassword;
    RelativeLayout btnDaftar;

    String nim, nama, fakultas, prodi, password;

    Context mContext;
    ProgressDialog loading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        formNIM = findViewById(R.id.form_nim);
        formNama = findViewById(R.id.form_nama);
        formFakultas = findViewById(R.id.form_fakultas);
        formProdi = findViewById(R.id.form_prodi);
        formPassword = findViewById(R.id.form_password);
        btnDaftar = findViewById(R.id.btn_daftar);

        mContext = this;

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                nim = formNIM.getText().toString();
                nama = formNama.getText().toString();
                fakultas = formFakultas.getText().toString();
                prodi = formProdi.getText().toString();
                password = formPassword.getText().toString();
                Log.d("data", nim);
                Log.d("data", nama);
                Log.d("data", fakultas);
                Log.d("data", prodi);
                Log.d("data", password);

                RegisterInterface registerInterface = Config.builder(RegisterActivity.this)
                        .create(RegisterInterface.class);
                Call<RegisterResponse> register = registerInterface
                        .register(nim, nama, fakultas, prodi, password);
                Log.d("dataaa", "atas enqueu");
                register.enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        RegisterResponse status = response.body().getSuccess();
                        Log.d("data status", "masuk status");
                        if (status != null){
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            loading.dismiss();
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Isi Data Anda Dengan Benar",
                                Toast.LENGTH_LONG).show();
                        loading.dismiss();
                    }
                });
            }
        });
    }
}
