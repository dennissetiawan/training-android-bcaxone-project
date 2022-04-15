package com.example.trainingprojectapps.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.trainingprojectapps.model.President;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

@Database(entities = {President.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PresidentDao presidentDao();

    private static volatile AppDatabase INSTANCE;
    private final static int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static AppDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (AppDatabase.class){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"president_database").build();
                }
            }
        }
        return INSTANCE;
    }

}


