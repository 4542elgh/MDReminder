package com.example.herr.MDReader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.arch.lifecycle.Observer;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrugViewModel mDrugViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrugViewModel = ViewModelProviders.of(this).get(DrugViewModel.class);

        mDrugViewModel.getmAllDrugs().observe(this, new Observer<List<Drug>>() {
            @Override
            public void onChanged(@Nullable final List<Drug> news) {
                //TODO: create drug adapter and set the drugs here
                // Update the cached copy of the words in the adapter.
//                mNewsAdapter.setNews(new ArrayList<NewsItem>(news));
            }
        });

        //TODO: finish implementing recycler view logic here
    }
}
