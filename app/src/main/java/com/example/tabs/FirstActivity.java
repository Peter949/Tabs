package com.example.tabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstActivity extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {   String[] Countries =
            {
                "Аргентина", "Бразилия", "Чили", "Колумбия", "Уругвай"
            };
        MainActivity mainActivity = new MainActivity();
        View view = inflater.inflate(R.layout.first_main, container, false);
        ListView listView = (ListView)view.findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (
                        getActivity(),
                        android.R.layout.simple_list_item_1,
                        Countries
                );
        listView.setAdapter(adapter);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(mainActivity.getApplicationContext(), Argentina.class);
                        startActivity(intent);
                        break;
                }
            }
        };
        //.getListView().setOnItemClickListener(itemListener);
        return view;
    }
}
