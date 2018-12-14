package com.example.herr.MDReader;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.arch.lifecycle.Observer;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MDRecyclerViewAdapter mAdapter;
    private ArrayList<Drug> drugArrayList = new ArrayList<>();
    private DrugViewModel mDrugViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new MDRecyclerViewAdapter(this,drugArrayList);
        mRecyclerView = (RecyclerView)findViewById(R.id.drugs_recyclerView); //reference the recycler view
        mRecyclerView.setAdapter(mAdapter); //using adapter
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.CAMERA},
                1);

        mDrugViewModel = ViewModelProviders.of(this).get(DrugViewModel.class);
        mDrugViewModel.getmAllDrugs().observe(this, new Observer<List<Drug>>() {
            @Override
            public void onChanged(@Nullable final List<Drug> news) {
                //TODO: create drug adapter and set the drugs here
                // Update the cached copy of the words in the adapter.
//                mNewsAdapter.setNews(new ArrayList<NewsItem>(news));
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
            String re = scanResult.getContents();
            String afterDecode = "";
            try {
                afterDecode = URLDecoder.decode(re, "UTF-8");
            }
            catch (UnsupportedEncodingException e){
                e.printStackTrace();
            }

            try{
                new fetchMedAPI().execute(new URL(afterDecode));
            }
            catch (MalformedURLException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        // else continue with any other code you need in the method
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toast.makeText(MainActivity.this, "Permission denied to read your Camera", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    public class fetchMedAPI extends AsyncTask<URL, String, String> { //async task take 3 parameters One for Each method
        @Override
        protected String doInBackground(URL... urls) {
            URL searchURL = urls[0]; //get the first index item
            String result = null; //init the result var
            try{
                result = NetworkUtils.getResponseFromHttpUrl(searchURL); //fetch result using Network utils
            }catch (IOException e){
                Log.d("Error: ",e.toString());
            }
            return result; //return the result string
        }

        @Override
        protected void onPostExecute(String s) { //when finish async call
            ArrayList<Drug> drugTemp = JsonUtils.getDrugList(s);
            Log.d("jsonLog",drugTemp.get(0).getProductNdc());
            mAdapter.listDrugs.clear();
            mAdapter.listDrugs.addAll(drugTemp);
            mAdapter.notifyDataSetChanged();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_buttons,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.scan_qr:{
                IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan something");
                integrator.setOrientationLocked(false);
                integrator.setBeepEnabled(false);
                integrator.initiateScan();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
