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
import android.widget.TextView;

import com.example.asus.ublib_user.Adapter.ListBukuAdapter;
import com.example.asus.ublib_user.Adapter.ListBukuFilterAdapter;
import com.example.asus.ublib_user.Interface.FilterBukuInterface;
import com.example.asus.ublib_user.Interface.ListBukuInterface;
import com.example.asus.ublib_user.Model.FilterResource;
import com.example.asus.ublib_user.Model.FilterResponse;
import com.example.asus.ublib_user.Model.ListBukuResource;
import com.example.asus.ublib_user.Model.ListBukuResponse;
import com.example.asus.ublib_user.Service.Config;
import com.example.asus.ublib_user.View.Activity.DetailBukuActivity;
import com.example.asus.ublib_user.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    RecyclerView rvListBuku;
    TextView btnNovel, btnBahasa, btnEkonomi, btnTeknologi;

    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferencesId;

    List<ListBukuResource> buku = new ArrayList<>();

    List<FilterResource> filter = new ArrayList<>();

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View homeFrg = inflater.inflate(R.layout.fragment_home, container, false);

        rvListBuku = homeFrg.findViewById(R.id.rv_list_buku);

        btnNovel = homeFrg.findViewById(R.id.btn_novel);
        btnBahasa = homeFrg.findViewById(R.id.btn_bahasa);
        btnEkonomi = homeFrg.findViewById(R.id.btn_ekonomi);
        btnTeknologi = homeFrg.findViewById(R.id.btn_teknologi);

        sharedPreferencesId = getActivity().getSharedPreferences(KEYPREF, getContext().MODE_PRIVATE);
        String id = sharedPreferencesId.getString("id_user", null);
        Log.d("dataaaa", "id = "+id);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvListBuku.setLayoutManager(linearLayoutManager);

        ListBukuInterface listKendaraanInterface = Config.builder(getContext())
                .create(ListBukuInterface.class);
        Call<ListBukuResponse> listBuku = listKendaraanInterface.buku();
        listBuku.enqueue(new Callback<ListBukuResponse>() {
            @Override
            public void onResponse(Call<ListBukuResponse> call, Response<ListBukuResponse> response) {
                Log.d("dataaaa", "masuk");
                buku = response.body().getSuccess();
                Log.d("dataaaa", "kendaraan = "+buku);
                if (buku != null){
                    ListBukuAdapter listBukuAdapter = new ListBukuAdapter(getContext(), buku);
                    rvListBuku.setAdapter(listBukuAdapter);
                    listBukuAdapter.notifyDataSetChanged();
                }


            }

            @Override
            public void onFailure(Call<ListBukuResponse> call, Throwable t) {

            }
        });

        btnNovel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FilterBukuInterface filterBukuInterface = Config.builder(getContext())
                        .create(FilterBukuInterface.class);
                final Call<FilterResponse> filterbuku = filterBukuInterface.filterJenis("Novel");
                filterbuku.enqueue(new Callback<FilterResponse>() {
                    @Override
                    public void onResponse(Call<FilterResponse> call, Response<FilterResponse> response) {

                        filter = response.body().getSuccess();

                        if (filter != null){
                            ListBukuFilterAdapter listBukuFilterAdapter = new ListBukuFilterAdapter(getContext(), filter);
                            rvListBuku.setAdapter(listBukuFilterAdapter);
                            listBukuFilterAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onFailure(Call<FilterResponse> call, Throwable t) {

                    }
                });
            }
        });

        btnBahasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FilterBukuInterface filterBukuInterface = Config.builder(getContext())
                        .create(FilterBukuInterface.class);
                final Call<FilterResponse> filterbuku = filterBukuInterface.filterJenis("Bahasa");
                filterbuku.enqueue(new Callback<FilterResponse>() {
                    @Override
                    public void onResponse(Call<FilterResponse> call, Response<FilterResponse> response) {

                        filter = response.body().getSuccess();

                        if (filter != null){
                            ListBukuFilterAdapter listBukuFilterAdapter = new ListBukuFilterAdapter(getContext(), filter);
                            rvListBuku.setAdapter(listBukuFilterAdapter);
                            listBukuFilterAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onFailure(Call<FilterResponse> call, Throwable t) {

                    }
                });
            }
        });

        btnEkonomi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FilterBukuInterface filterBukuInterface = Config.builder(getContext())
                        .create(FilterBukuInterface.class);
                final Call<FilterResponse> filterbuku = filterBukuInterface.filterJenis("Ekonomi");
                filterbuku.enqueue(new Callback<FilterResponse>() {
                    @Override
                    public void onResponse(Call<FilterResponse> call, Response<FilterResponse> response) {

                        filter = response.body().getSuccess();

                        if (filter != null){
                            ListBukuFilterAdapter listBukuFilterAdapter = new ListBukuFilterAdapter(getContext(), filter);
                            rvListBuku.setAdapter(listBukuFilterAdapter);
                            listBukuFilterAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onFailure(Call<FilterResponse> call, Throwable t) {

                    }
                });
            }
        });

        btnTeknologi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FilterBukuInterface filterBukuInterface = Config.builder(getContext())
                        .create(FilterBukuInterface.class);
                final Call<FilterResponse> filterbuku = filterBukuInterface.filterJenis("Teknologi");
                filterbuku.enqueue(new Callback<FilterResponse>() {
                    @Override
                    public void onResponse(Call<FilterResponse> call, Response<FilterResponse> response) {

                        filter = response.body().getSuccess();

                        if (filter != null){
                            ListBukuFilterAdapter listBukuFilterAdapter = new ListBukuFilterAdapter(getContext(), filter);
                            rvListBuku.setAdapter(listBukuFilterAdapter);
                            listBukuFilterAdapter.notifyDataSetChanged();
                        }

                    }

                    @Override
                    public void onFailure(Call<FilterResponse> call, Throwable t) {

                    }
                });
            }
        });

        return homeFrg;
    }

}
