package com.example.ahmedd.flaglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;




public class MainActivity extends AppCompatActivity {

   // Toolbar toolBar;
    SearchView searchView;
    ListView listView;

    String countryNames[] = new String[]{

            "Algeria",
            "Argentina",
            "Australia",
            "Brazil",
            "Egypt",
            "England",
            "France",
            "GreenLand",
            "IceLand",
            "Poland",
            "Portugal",
            "Spain",
            "USA",
            "Wales",
    };


    int countryFlags[] = new int[]{
            R.drawable.algeria,
            R.drawable.argentina,
            R.drawable.australia,
            R.drawable.brazil,
            R.drawable.egypt,
            R.drawable.england,
            R.drawable.france,
            R.drawable.greenland,
            R.drawable.iceland,
            R.drawable.poland,
            R.drawable.portugal,
            R.drawable.spain,
            R.drawable.usa,
            R.drawable.wales,

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flags);

        //toolBar =(Toolbar) findViewById(R.id.toolBar);
        searchView = (SearchView) findViewById(R.id.searchBar);
        listView = (ListView) findViewById(R.id.listView);



        MyAdapter myAdapter = new MyAdapter(MainActivity.this ,countryNames , countryFlags);
        listView.setAdapter(myAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem item = menu.findItem(R.id.listView);
        searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                MyAdapter myAdapter = new MyAdapter(MainActivity.this , countryNames);
                listView.setAdapter(myAdapter);
                myAdapter.getFilter().filter(s);

                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
