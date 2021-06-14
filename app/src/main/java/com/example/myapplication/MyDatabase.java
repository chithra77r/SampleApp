package com.example.myapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class}, version = 1)

abstract public class MyDatabase extends RoomDatabase {
    static MyDatabase myDatabase;

    abstract StudentDao getStudentDao();

    static MyDatabase getInstance(Context context) {
        if (myDatabase == null) {
            myDatabase = Room
                    .databaseBuilder(context, MyDatabase.class, "chithra")
                    .allowMainThreadQueries()
                    .build();
            return myDatabase;
        }
        return myDatabase;
    }
}
