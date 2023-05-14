package com.example.login2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.

 */
public class HomeFrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFrag() {
        // Required empty public constructor
    }
    RecyclerView recyclerView;
    List<Model> itemList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView=view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        initData();

        recyclerView.setAdapter(new ItemAdapter(initData()));

        return view;
    }

    private  List<Model> initData() {
        itemList=new ArrayList<>();
        itemList.add(new Model(R.drawable.siyah_blazer_elbise,"SİYAH BLAZER ELBİSE \n\n 1500 TL"));
        itemList.add(new Model(R.drawable.bej_sort,"BEJ ŞORT \n\n 400 TL"));
        itemList.add(new Model(R.drawable.siyah_askili_elbise,"SİYAH ASKILI ELBİSE \n\n 1200 TL"));
        itemList.add(new Model(R.drawable.siyah_sort,"SİYAH ŞORT \n\n 900 TL"));
        itemList.add(new Model(R.drawable.siyah_takim,"SİYAH TAKIM \n\n 2000 TL"));
        itemList.add(new Model(R.drawable.kahverengi_blazer,"KAHVERENGİ BLAZER \n\n 1300 TL"));
        itemList.add(new Model(R.drawable.kahverengi_blazer_elbise,"KAHVERENGİ BLAZER ELBİSE \n 1400 TL"));
        itemList.add(new Model(R.drawable.kareli_takim,"KARELİ TAKIM \n\n 2200 TL"));
        itemList.add(new Model(R.drawable.beyaz_elbise,"BEYAZ ELBİSE \n\n 1200 TL"));

        return itemList;

    }
}