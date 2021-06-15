package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Student {
    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "s_name")
    String name;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dummy=" + dummy +
                '}'+"\n";
    }

    @ColumnInfo(name = "s_age")
    int age;
    @Ignore
    int dummy;
}
