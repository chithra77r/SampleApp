package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("itisck", "Hello ");

        tvShow = findViewById(R.id.tvShow);
        btAdd = findViewById(R.id.btAdd);
        btShow = findViewById(R.id.btShow);
        etName = findViewById(R.id.etName);
        MyDatabase database = MyDatabase.getInstance(MainActivity.this);
        StudentDao studentDao = database.getStudentDao();

        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Student> list = studentDao.getStudent();
                tvShow.setText(list.toString());
            }
        });

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Student student = new Student();
                student.name = etName.getText().toString();
                studentDao.insertStudent(student);
                etName.getText().clear();

            }
        });

    }
}