package com.example.trainingprojectapps.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.trainingprojectapps.model.President;

import java.util.List;

public class PresidentRepository {
    private PresidentDao presidentDao;
    private LiveData<List<President>> allPresident;

    public PresidentRepository(Application application){
        AppDatabase database = AppDatabase.getDatabase(application);
        presidentDao = database.presidentDao();
        allPresident = presidentDao.getAll();
    }

    LiveData<List<President>> getAllPresident(){
        return allPresident;
    }

    void insert(President president){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                presidentDao.insert(president);
            }
        });
    }

    void update(President president){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                presidentDao.update(president);
            }
        });
    }

    void delete(President president){
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                presidentDao.delete(president);
            }
        });
    }

}
