package com.example.roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    static AppDatabase appDatabase;

    abstract UserDao getUser();

    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, "chithu")
                    .allowMainThreadQueries()
                    .build();
            return appDatabase;
        }
        return appDatabase;
    }


}
