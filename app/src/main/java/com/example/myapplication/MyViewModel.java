package com.example.myapplication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class MyViewModel  extends ViewModel {
     String data;
    MutableLiveData<String> liveData = new MutableLiveData<>();


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


}
