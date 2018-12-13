package com.example.herr.MDReader;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Drug.class}, version = 1)

public abstract class DrugDatabase extends RoomDatabase {
    public abstract DrugDao drugDao();

    private static volatile DrugDatabase INSTANCE;

    static DrugDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DrugDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DrugDatabase.class,"drugs_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
