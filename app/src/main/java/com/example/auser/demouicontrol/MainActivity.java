package com.example.auser.demouicontrol;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        restorePrefs();
    }

    void findViews(){
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
    }
}
