package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditStudent extends AppCompatActivity {

    private String selectedName,selectedRollno;
    private int selectedID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        Button delbtn=findViewById(R.id.deletebtn);
        Button updatebtn=findViewById(R.id.updatebtn);

        EditText editName = findViewById(R.id.editname);
        EditText editRollNumber = findViewById(R.id.editrollno);
        //get the intent extra from the ListDataActivity
        Intent receivedIntent = getIntent();

        //now get the itemID we passed as an extra
        selectedID = receivedIntent.getIntExtra("id",-1); //NOTE: -1 is just the default value

        //now get the name we passed as an extra
        selectedName = receivedIntent.getStringExtra("name");
       selectedRollno=receivedIntent.getStringExtra("rollno");
        //set the text to show the current selected name
        Log.d("roll", String.valueOf(selectedRollno));
        editName.setText(selectedName);
        editRollNumber.setText(String.valueOf(selectedRollno));

        delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity.dbHelper.deleteStudent(selectedID);
                startActivity(new Intent(EditStudent.this, MainActivity.class));
                finish();
            }
        });

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n = editName.getText().toString();
                String r = editRollNumber.getText().toString();
                Log.d("nameOFStudent",n);
                Log.d("nameOFStudent",String.valueOf(selectedID));
                MainActivity.dbHelper.updateData(n,r,selectedID);
                startActivity(new Intent(EditStudent.this, MainActivity.class));


            }
        });
    }



}