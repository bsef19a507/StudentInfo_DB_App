package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void newStudent(View view) {
        Intent newstudents = new Intent(Main.this,MainActivity.class);
        startActivity(newstudents);
    }

    public void AllStudent(View view) {
        Intent students = new Intent(Main.this, AllStudents.class);
        startActivity(students);

    }
}