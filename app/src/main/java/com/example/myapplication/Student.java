package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @PrimaryKey
    int id;
    @ColumnInfo(name = "s_name")
    String name;
    @ColumnInfo(name = "s_age")
    int age;
    @Ignore
    int dummy;
}
