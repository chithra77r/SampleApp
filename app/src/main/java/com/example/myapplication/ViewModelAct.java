package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ViewModelAct extends AppCompatActivity {
    TextView tvShow;
    Button btAdd, btShow;
    EditText etName;
    MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model);
        tvShow = findViewById(R.id.tvShow);
        btAdd = findViewById(R.id.btAdd);
        btShow = findViewById(R.id.btShow);
        etName = findViewById(R.id.etName);
        myViewModel =new  ViewModelProvider(ViewModelAct.this).get(MyViewModel.class);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
              myViewModel.funLiveData( etName.getText().toString());
            }
        });

        myViewModel.liveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                tvShow.setText(s);
            }
        });

//        btShow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//           tvShow.setText(myViewModel.data);
//            }
//        });
    }
}