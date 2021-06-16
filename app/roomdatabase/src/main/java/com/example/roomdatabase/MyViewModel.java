package com.example.roomdatabase;

import android.app.Application;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    UserDao userDao;
    private MutableLiveData<List<User>> obsUser = new MutableLiveData();

    public MyViewModel(@NonNull Application application) {
        super(application);
    }

    {
        userDao = AppDatabase.getInstance(getApplication()).getUser();

    }

    private void fetchItem() {
        obsUser.setValue(userDao.getAll());
    }


    public void insertUser(String data){
        User user = new User();
        user.name = data;
        userDao.insertInfo(user);
        fetchItem();
    }

    public LiveData<List<User>> getObsUser() {
        return obsUser;
    }

}
