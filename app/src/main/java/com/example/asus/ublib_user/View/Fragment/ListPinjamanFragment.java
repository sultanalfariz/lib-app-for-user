package com.example.asus.ublib_user.View.Fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.asus.ublib_user.Adapter.ListPeminjamanAdapter;
import com.example.asus.ublib_user.Interface.ListPeminjamanInterface;
import com.example.asus.ublib_user.Model.PeminjamanResource;
import com.example.asus.ublib_user.Model.PeminjamanResponse;
import com.example.asus.ublib_user.Service.Config;
import com.example.asus.ublib_user.View.Activity.HistoryActivity;
import com.example.asus.ublib_user.View.Activity.ValidasiPeminjamanActivity;
import com.example.asus.ublib_user.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListPinjamanFragment extends Fragment {

    ImageView btnHistory;
    RecyclerView rvPeminjaman;

    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferencesId;

    List<PeminjamanResource> pinjam = new ArrayList<>();

    public ListPinjamanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View peminjamanFrg = inflater.inflate(R.layout.fragment_list_pinjaman, container, false);

        btnHistory = peminjamanFrg.findViewById(R.id.btn_history);

        rvPeminjaman = peminjamanFrg.findViewById(R.id.rv_list_peminjaman);

        sharedPreferencesId = getActivity().getSharedPreferences(KEYPREF, getContext().MODE_PRIVATE);
        String id = sharedPreferencesId.getString("id_user", null);
        Log.d("dataaaa", "id = "+id);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvPeminjaman.setLayoutManager(linearLayoutManager);

        ListPeminjamanInterface listPeminjamanInterface = Config.builder(getContext())
                .create(ListPeminjamanInterface.class);
        Call<PeminjamanResponse> listBuku = listPeminjamanInterface.peminjaman(id);
        listBuku.enqueue(new Callback<PeminjamanResponse>() {
            @Override
            public void onResponse(Call<PeminjamanResponse> call, Response<PeminjamanResponse> response) {
                Log.d("dataaaa", "masuk");
                pinjam = response.body().getSuccess();
                Log.d("dataaaa", "kendaraan = "+pinjam);
                if (pinjam != null){
                    ListPeminjamanAdapter listPeminjamanAdapter = new ListPeminjamanAdapter(getContext(), pinjam);
                    rvPeminjaman.setAdapter(listPeminjamanAdapter);
                    listPeminjamanAdapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onFailure(Call<PeminjamanResponse> call, Throwable t) {

            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent history = new Intent(getActivity(), HistoryActivity.class);
                startActivity(history);
            }
        });

        return peminjamanFrg;
    }

}
