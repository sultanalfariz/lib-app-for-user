package com.example.asus.ublib_user.View.Fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.asus.ublib_user.Model.LoginResource;
import com.example.asus.ublib_user.R;
import com.example.asus.ublib_user.View.Activity.LoginActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AccountFragment extends Fragment {

    TextView txtNama, txtNIM, txtFakultas;
    RelativeLayout btnLogout;

    public static final String KEYPREF = "Key Preference";
    SharedPreferences sharedPreferences;

    LoginResource loginResource;

    public AccountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View accFrg = inflater.inflate(R.layout.fragment_account, container, false);

        txtNama = accFrg.findViewById(R.id.text_nama);
        txtNIM = accFrg.findViewById(R.id.text_nim);

        sharedPreferences = getActivity().getSharedPreferences(KEYPREF, getContext().MODE_PRIVATE);
        String id = sharedPreferences.getString("id_user", null);
        Log.d("dataaaa", "id = "+id);

        String tnama = sharedPreferences.getString("nama", null);
        String tnim = sharedPreferences.getString("nim", null);

        txtNama.setText(tnama);
        txtNIM.setText(tnim);

        btnLogout = accFrg.findViewById(R.id.btn_logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keluar = new Intent(getActivity(), LoginActivity.class);
                startActivity(keluar);
            }
        });

        return accFrg;
    }

}
