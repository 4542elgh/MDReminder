package com.example.herr.MDReader;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import java.net.URL;
import java.util.List;

public class DrugRepository {
    private DrugDao mDrugDao;
    private LiveData<List<Drug>> mAllDrugs;

    public DrugRepository(Application application){
        DrugDatabase db = DrugDatabase.getDatabase(application.getApplicationContext());
        mDrugDao = db.drugDao();
        mAllDrugs = mDrugDao.loadAllDrugs();
    }

    LiveData<List<Drug>> getAllDrugs() {
        return mAllDrugs;
    }

    public void setAll (LiveData<List<Drug>> items) {
        this.mAllDrugs = items;
    }

    public void updateList (List<Drug> items) {
        new updateListAsyncTask(mDrugDao).execute(items);
    }

    public void sync(List<Drug> items){
        new syncDBAsyncTask(mDrugDao).execute(items);
    }

    private class updateListAsyncTask extends AsyncTask<List<Drug>, Void, Void> {
        private DrugDao mAsyncTaskDao;
        updateListAsyncTask(DrugDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final List<Drug>... params) {
            DrugRepository.this.setAll(mAsyncTaskDao.loadAllDrugs());
            return null;
        }
    }

    private class syncDBAsyncTask extends AsyncTask<List<Drug>, Void, Void> {
        private DrugDao mAsyncTaskDao;
        syncDBAsyncTask(DrugDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final List<Drug>... params) {
            try {
                // temporarily pass empty string until able to test buildURL function
                URL drugSearchUrl = NetworkUtils.buildUrl("", "");
                String response = NetworkUtils.getResponseFromHttpUrl(drugSearchUrl);
                mAsyncTaskDao.clearAll();
                mAsyncTaskDao.insert(JsonUtils.getDrugRepository(response));
            }
            catch(Exception e) {
                Log.e("exception during sync", e.toString());
            }


            return null;
        }
    }

}
