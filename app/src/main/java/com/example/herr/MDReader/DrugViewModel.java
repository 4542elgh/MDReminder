package com.example.herr.MDReader;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class DrugViewModel extends AndroidViewModel {
    private DrugRepository mRepository;

    private LiveData<List<Drug>> mAllDrugs;

    public DrugViewModel (Application application) {
        super(application);
        mRepository = new DrugRepository(application);
        mAllDrugs = mRepository.getAllDrugs();
    }

    public LiveData<List<Drug>> getmAllDrugs() {
        return mAllDrugs;
    }

    public void updateCurrentItems() {
        mAllDrugs = mRepository.getAllDrugs();
    }

    public void sync(){
        mRepository.sync(null);
    }

    public void loadAll() {
        mRepository.updateList(null);
    }
}
