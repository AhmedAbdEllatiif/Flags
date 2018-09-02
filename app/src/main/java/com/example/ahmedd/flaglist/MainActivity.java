package com.example.ahmedd.flaglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;
    ArrayList flagIcons;
    ArrayList countryNames;
    FlagsNamesIcons icons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flags);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        listItems = new ArrayList<>();
        icons = new FlagsNamesIcons();
        flagIcons = icons.flagsIcon();
        countryNames = icons.countryNames();

       for (int i=0 ; i<icons.countryNames().size(); i++){
           ListItem listItem = new ListItem((Integer)icons.flagsIcon().get(i)
                   ,(String) icons.countryNames().get(i));

           listItems.add(listItem);
       }

       adapter = new MyAdapter(listItems,this);
       recyclerView.setAdapter(adapter);

    }
}
