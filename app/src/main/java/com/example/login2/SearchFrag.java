package com.example.login2;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.

 */
public class SearchFrag extends Fragment {


    private RecyclerView recyclerView;

    private ItemAdapter itemAdapter;
    private List<Model> itemList;
    private SearchView searchView;



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_search, container, false);

        recyclerView=view.findViewById(R.id.recycler);
        searchView=view.findViewById(R.id.searchview);

        searchView.clearFocus();
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
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

        itemAdapter= new ItemAdapter(itemList);
        recyclerView.setAdapter(itemAdapter);
        return view;
    }




    public void filterList(String text){

        List<Model> filteredList =new ArrayList<>();
        for(Model item :itemList){
       if(item.getName().toLowerCase().contains(text.toLowerCase())){
       filteredList.add(item);
}
        }
        if (filteredList.isEmpty()){
            Toast.makeText(getActivity(),"No data found",Toast.LENGTH_SHORT).show();
        }
        else {
            itemAdapter.setFilteredList(filteredList);
        }
    }
}