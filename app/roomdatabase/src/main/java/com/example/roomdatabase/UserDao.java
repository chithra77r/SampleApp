package com.example.roomdatabase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertInfo(User user);

    @Query("select * from User")
    List<User> getAll();


}
