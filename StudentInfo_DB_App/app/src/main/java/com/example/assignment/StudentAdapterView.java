package com.example.assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.ArrayList;

public class StudentAdapterView extends ArrayAdapter<StudentModel> {
    public StudentAdapterView(@NonNull Context context, ArrayList<StudentModel> studentArrayList) {
        super(context, 0, studentArrayList);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        StudentModel myclass = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.customized_studentview,parent,false);
        TextView name = convertView.findViewById(R.id.stuName);
        TextView rollno = convertView.findViewById(R.id.stuenroll);
        TextView isEnroll = convertView.findViewById(R.id.stuenroll);
        name.setText(myclass.getName());
        rollno.setText(myclass.getRollNmber());
        isEnroll.setText(String.valueOf( myclass.isEnroll()));

        return convertView;
    }


}
