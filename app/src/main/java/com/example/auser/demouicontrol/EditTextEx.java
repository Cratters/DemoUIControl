package com.example.auser.demouicontrol;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class EditTextEx extends AppCompatActivity {


    CheckBox mCheckBox;
    EditText editText,editText2;

    public static final String PREF = "PREF";
    public static final String PREF_ADMIN = "Admin";
    public static final String PREF_PASSWORD = "Password";


    private void restorePrefs() {
        SharedPreferences settings = getSharedPreferences(PREF, 0);
        String pref_admin = settings.getString(PREF_ADMIN, "");
        if (!"".equals(pref_admin))
        {
            editText.setText(pref_admin);
            editText.requestFocus();
        }
        String pref_password = settings.getString(PREF_PASSWORD, "");
        if (!"".equals(pref_password))
        {
            editText2.setText(pref_password);
            editText2.requestFocus();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences settings = getSharedPreferences(PREF, 0);
        settings.edit().putString(PREF_ADMIN,editText.getText().toString()).commit();
        settings.edit().putString(PREF_PASSWORD,editText2.getText().toString()).commit();
    }

    void findViews(){
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        mCheckBox = (CheckBox) findViewById(R.id.checkBox);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        findViews();
        restorePrefs();
        mCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView , boolean isChecked) {
                // TODO Auto-generated method stub
                if(mCheckBox.isChecked()){
                    Toast.makeText(EditTextEx.this,"顯示密碼",Toast.LENGTH_SHORT).show();
                    editText2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//顯示密碼
                }else{
                    editText2.setTransformationMethod(PasswordTransformationMethod.getInstance());  //隱藏密碼
                }
            }
        });
    }
}
