package com.example.login2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PersonFrag extends Fragment {

    TextView profilkulAd,profilEmail;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_person, container, false);

        profilkulAd=view.findViewById(R.id.profilName);
        profilEmail=view.findViewById(R.id.profilEmail);



        return view;
    }
}