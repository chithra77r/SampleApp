package com.example.myapplication;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MyViewModel  extends AndroidViewModel
{
     String data;
    MutableLiveData<String> liveData = new MutableLiveData<>();

    private final MyDatabase database;

    private final StudentDao studentDao;

    {
      database = MyDatabase.getInstance(getApplication());
      studentDao = database.getStudentDao();
    }

    public MyViewModel(@NonNull Application application) {
        super(application);
    }

    void fun(String data){
         new Thread(new Runnable() {
             @Override
             public void run() {
                 try {
                     Thread.sleep(10000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 MyViewModel.this.data = ""+(Integer.valueOf(data)+5);
             }
         }).start();
     }

     void funLiveData(String data) {
//         new Thread(new Runnable() {
//             @Override
//             public void run() {
//                 try {
//                     Thread.sleep(10000);
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//                 liveData.postValue(""+(Integer.valueOf(data)+5));
//             }
//         }).start();

     }

     void insertStudent(){
         studentDao.insertStudent();
     }


}
