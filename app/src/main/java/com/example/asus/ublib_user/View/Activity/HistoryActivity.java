package com.example.asus.ublib_user.View.Activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.asus.ublib_user.Adapter.ListHistoryAdapter;
import com.example.asus.ublib_user.Interface.HistoryInterface;
import com.example.asus.ublib_user.Model.HistoryResource;
import com.example.asus.ublib_user.Model.HistoryResponse;
import com.example.asus.ublib_user.R;
import com.example.asus.ublib_user.Service.Config;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryActivity extends AppCompatActivity {

    RecyclerView rvHistory;

    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferencesId;

    List<HistoryResource> pinjam = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        rvHistory = findViewById(R.id.rv_history);

        sharedPreferencesId = getSharedPreferences(KEYPREF, MODE_PRIVATE);
        String id = sharedPreferencesId.getString("id_user", null);
        Log.d("dataaaa", "id = "+id);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HistoryActivity.this,LinearLayoutManager.VERTICAL, false);
        rvHistory.setLayoutManager(linearLayoutManager);

        HistoryInterface historyInterface = Config.builder(HistoryActivity.this)
                .create(HistoryInterface.class);
        Call<HistoryResponse> listBuku = historyInterface.history(id);
        listBuku.enqueue(new Callback<HistoryResponse>() {
            @Override
            public void onResponse(Call<HistoryResponse> call, Response<HistoryResponse> response) {
                Log.d("dataaaa", "masuk");
                pinjam = response.body().getSuccess();
                Log.d("dataaaa", "kendaraan = "+pinjam);
                if (pinjam != null){
                    ListHistoryAdapter listHistoryAdapter = new ListHistoryAdapter(HistoryActivity.this, pinjam);
                    rvHistory.setAdapter(listHistoryAdapter);
                    listHistoryAdapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onFailure(Call<HistoryResponse> call, Throwable t) {

            }
        });
    }
}
