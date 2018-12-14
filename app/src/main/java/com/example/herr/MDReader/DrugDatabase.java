package com.example.herr.MDReader;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    Log.d("drugs_database", "populating with data...");
                                    new PopulateDbAsync(INSTANCE, context.getApplicationContext()).execute();
                                }
                            })
                            .build();

                }
            }
        }
        return INSTANCE;
    }

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {
        private final DrugDao drugDao;
        private final Context context;

        public PopulateDbAsync(DrugDatabase instance, Context context) {
            this.drugDao = instance.drugDao();
            this.context = context;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            drugDao.clearAll();

            //read ndc.json and parse values into dao
            InputStream dataStream = context.getResources().openRawResource(R.raw.ndc);

            String json;

            try {
                int size = dataStream.available();
                byte[] buffer = new byte[size];
                dataStream.read(buffer);
                dataStream.close();
                json = new String(buffer, "UTF-8");

                drugDao.insert(JsonUtils.getDrugList(json));
            }
            catch (Exception e){
                Log.d("exception", e.toString());
            }


            return null;
        }
    }
}
