package com.example.herr.MDReader;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DrugDao {
    @Insert
    void insert(List<Drug> drugs);

    @Query("DELETE FROM drugs")
    void clearAll();

    @Query("SELECT * FROM drugs ORDER BY productNdc ASC")
    LiveData<List<Drug>> loadAllDrugs();
}
