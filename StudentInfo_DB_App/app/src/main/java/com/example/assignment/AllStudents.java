package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AllStudents extends AppCompatActivity {
    ListView listViewStudent;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_students);


        listViewStudent = findViewById(R.id.listViewStudent);
        MainActivity.dbHelper = new DBHelper(AllStudents.this);

        ArrayList<StudentModel> list = MainActivity.dbHelper.getAllStudents();

        StudentAdapterView arrayAdapter = new StudentAdapterView (this,list);


        listViewStudent.setAdapter(arrayAdapter);

        listViewStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                MainActivity.dbHelper = new DBHelper(AllStudents.this);
                StudentModel s= (StudentModel) adapterView.getItemAtPosition(i);
                String name = s.getName();
                int rollNo =s.getRollNmber();

                Cursor data = MainActivity.dbHelper.getStudentID(name,rollNo); //get the id associated with that name and rollno

                int StudentID = -1;
                while(data.moveToNext()){
                    StudentID = data.getInt(0);
                }

                if(StudentID > -1){

                    Intent editScreenIntent = new Intent(AllStudents.this, EditStudent.class);
                    editScreenIntent.putExtra("id",StudentID);
                    editScreenIntent.putExtra("rollno",String.valueOf(rollNo));
                    editScreenIntent.putExtra("name",name);
                    startActivity(editScreenIntent);
                }

            }
        });
    }
}