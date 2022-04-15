package com.example.trainingprojectapps.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.trainingprojectapps.model.President;

import java.util.List;

@Dao
public interface PresidentDao {
    @Query("SELECT * FROM President")
    LiveData<List<President>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(President president);

    @Update
    void update(President president);

    @Delete
    void delete(President president);

}
