package com.example.trainingprojectapps.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.trainingprojectapps.model.President;

import java.util.List;

public class PresidentViewModel extends AndroidViewModel {
    private PresidentRepository presidentRepository;
    private final LiveData<List<President>> allPresident;

    public PresidentViewModel(@NonNull Application application) {
        super(application);
        presidentRepository = new PresidentRepository(application);
        allPresident = presidentRepository.getAllPresident();
    }

    public LiveData<List<President>> getAllPresident(){
        return allPresident;
    }

    public void insert(President president){
        presidentRepository.insert(president);
    }

    public void update(President president){
        presidentRepository.update(president);
    }

    public void delete(President president){
        presidentRepository.delete(president);
    }
}
