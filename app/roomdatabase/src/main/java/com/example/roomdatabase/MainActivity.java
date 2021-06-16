package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvShow;
    Button btAdd, btShow;
    EditText etName;
    MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("itisck", "Hello ");

        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        tvShow = findViewById(R.id.tvShow);
        btAdd = findViewById(R.id.btAdd);
        btShow = findViewById(R.id.btShow);
        etName = findViewById(R.id.etName);



        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.insertUser(etName.getText().toString());
//
//                View -> viewModel -> Model
//
//
//               View <- viewModel <- Model
//
//

            }
        });
        myViewModel.getObsUser().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                tvShow.setText(users.toString());
            }
        });

    }
}