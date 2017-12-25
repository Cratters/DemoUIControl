package com.example.auser.demouicontrol;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

public class ListViewEx extends AppCompatActivity {
    ListView listView;
    Class<?>[] activityNameClasses = {
            CheckBox.class,
            EditTextEx.class,
            ListViewEx.class,
            ProgressBarEx.class,
            RadioButtonEx.class,
            RatingBarEx.class,
            ToggleButtonEx.class,
            SpinnerEx.class
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_ex);
        listView = (ListView) findViewById(R.id.listView);
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, activityNameClasses);
        //adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(ListViewEx.this ,activityNameClasses[position]);
                startActivity(intent);
            }
        });
    }
}
