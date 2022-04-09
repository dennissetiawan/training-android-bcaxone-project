package com.example.trainingprojectapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.widget.SearchView;

import com.example.trainingprojectapps.model.President;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<President> presidentsDataArrayList = President.generateDataItem();
    private PresidentAdapter presidentAdapter;
    private RecyclerView recyclerView;

    private final String TAG ="MAIN_ACTIVITY";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        presidentAdapter = new PresidentAdapter(presidentsDataArrayList,
                item -> showSnackBar(item.getName() +" " +item.getTerm_began() ));
        recyclerView.setAdapter(presidentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addOnItemTouchListener(new RecyclerView.SimpleOnItemTouchListener());

        Log.d(TAG,"on create main activity called");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true);
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                notifyList(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(TextUtils.isEmpty(s)){
                    Log.d(TAG,"reset data");
                    resetData();
                    return true;
                }
                return false;
            }
        });

        return true;
    }

    private President searchPresident(String query){
        President president = null;
        Log.d(TAG,"search president"+query);
        for (President p : presidentsDataArrayList) {
            if(p.getName().toLowerCase().contains(query.toLowerCase())){
                president = p;
                break;
            }
        }
        if (president == null) {
            showSnackBar("No president found");
        }
        return president;
    }
    private void notifyList(String query) {
        President president = searchPresident(query);
        if(president != null){
            presidentsDataArrayList.clear();
            presidentsDataArrayList.add(president);
            presidentAdapter.notifyDataSetChanged();
        }

    }


    private void resetData(){
        presidentsDataArrayList.clear();
        presidentsDataArrayList.addAll(President.generateDataItem());
        presidentAdapter.notifyDataSetChanged();
    }

    private void showSnackBar(String text){
        final Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content).getRootView()
                , text, Snackbar.LENGTH_LONG);
        snackbar.setAction("OK", v -> snackbar.dismiss());
        snackbar.show();
    }

}