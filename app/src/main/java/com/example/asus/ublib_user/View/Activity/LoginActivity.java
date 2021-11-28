package com.example.asus.ublib_user.View.Activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.ublib_user.Interface.LoginInterface;
import com.example.asus.ublib_user.Model.LoginResource;
import com.example.asus.ublib_user.Model.LoginResponse;
import com.example.asus.ublib_user.R;
import com.example.asus.ublib_user.Service.Config;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    TextView btnMasuk, btnDaftar;
    EditText formNIM, formPassword;

    LoginResource loginResource;
    LoginInterface loginInterface;
    Context mContext;
    ProgressDialog loading;

    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences(KEYPREF, Context.MODE_PRIVATE);

        formNIM = findViewById(R.id.form_nim);
        formPassword = findViewById(R.id.form_password);
        btnMasuk = findViewById(R.id.btn_masuk);
        btnDaftar = findViewById(R.id.btn_daftar);

        mContext = this;

        loginInterface = Config.builder(LoginActivity.this).create(LoginInterface.class);
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loading = ProgressDialog.show(mContext, null, "Harap Tunggu...", true, false);
                final String nim,password;
                nim = formNIM.getText().toString();
                password = formPassword.getText().toString();
                final Call<LoginResponse> login = loginInterface.login(nim,password);
                login.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        try {
                            loginResource = response.body().getSuccess();
                        }catch (Exception e){
                            Toast.makeText(LoginActivity.this,"User tidak tersedia",Toast.LENGTH_LONG).show();
                        }
                        String id_user = String.valueOf(loginResource.getId());
                        if (loginResource != null){
//                                Prefs.putUser(MainActivity.this,Prefs.USER_SESSION,userModel);
//                                SharedPreferences.Editor data = sharedPreferences.edit();
//                                data.putString(KEYEMAIL,username);
//                                data.commit();
                                Intent loginSuccess = new Intent(LoginActivity.this,MainActivity.class);
                                SharedPreferences.Editor data = sharedPreferences.edit();
                                data.putString("id_user", id_user);
                                data.putString("nama", loginResource.getNama().toString());
                                data.putString("nim", loginResource.getNim().toString());
                                data.commit();
                                data.apply();
                                loading.dismiss();
                                startActivity(loginSuccess);
                                LoginActivity.this.finish();
                        }else {
                            Toast.makeText(LoginActivity.this,"User tidak tersedia",Toast.LENGTH_LONG).show();
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "An error occurred!"+t, Toast.LENGTH_SHORT).show();
                        loading.dismiss();
                    }
                });
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent daftar = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(daftar);
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
