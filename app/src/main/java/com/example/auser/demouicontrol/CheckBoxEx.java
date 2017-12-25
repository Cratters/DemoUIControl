package com.example.auser.demouicontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class CheckBoxEx extends AppCompatActivity {

    CheckBox[] checkBoxes;
    CheckBox ck1,ck2,ck3,ck4,ck5,ck6;
    TextView result;
    Button submit,button,button2,button3;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        findViews();
        setListeners();
    }

    void findViews() {
        ck1 = (CheckBox) findViewById(R.id.checkBox1);
        ck2 = (CheckBox) findViewById(R.id.checkBox2);
        ck3 = (CheckBox) findViewById(R.id.checkBox3);
        ck4 = (CheckBox) findViewById(R.id.checkBox4);
        ck5 = (CheckBox) findViewById(R.id.checkBox5);
        ck6 = (CheckBox) findViewById(R.id.checkBox6);
        checkBoxes = new CheckBox[]{ck1,ck2,ck3,ck4,ck5,ck6};
        button = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        submit = (Button) findViewById(R.id.submit);
        result = (TextView) findViewById(R.id.result);
    }

    void setListeners(){
        submit.setOnClickListener(bunListener);
        button.setOnClickListener(listenerETE);
        button2.setOnClickListener(listenerRBE);
        button3.setOnClickListener(listenerTBE);
        for (CheckBox cbk : checkBoxes)
            cbk.setOnCheckedChangeListener(CBListener);
    }

    View.OnClickListener bunListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String text1 = "";
            if (ck1.isChecked() || ck2.isChecked() || ck3.isChecked())
                text1 += "\n您最喜歡的顏色是:\n";
            if (ck1.isChecked())
                text1 += ck1.getText() + " ";
            if (ck2.isChecked())
                text1 += ck2.getText() + " ";
            if (ck3.isChecked())
                text1 += ck3.getText() + " ";
            result.setText(text1);
            if (ck4.isChecked() || ck5.isChecked() || ck6.isChecked())
                text1 +=  "\n您平常的休閒活動:\n";
            if (ck4.isChecked())
                text1 += ck4.getText() + " ";
            if (ck5.isChecked())
                text1 += ck5.getText() + " ";
            if (ck6.isChecked())
                text1 += ck6.getText() + " ";
            if (text1.endsWith(" "))
                result.setText(text1.substring(0, text1.length() - 1));
            else
                result.setText(text1);

        }
    };

    View.OnClickListener listenerRBE = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            intent = new Intent();
            intent.setClass(CheckBoxEx.this ,RadioButtonEx.class);
            startActivity(intent);
        }
    };

    View.OnClickListener listenerETE = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            intent = new Intent();
            intent.setClass(CheckBoxEx.this ,EditTextEx.class);
            startActivity(intent);
        }
    };

    View.OnClickListener listenerTBE = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            intent = new Intent();
            intent.setClass(CheckBoxEx.this ,ToggleButtonEx.class);
            startActivity(intent);
        }
    };

    CheckBox.OnCheckedChangeListener CBListener = new CheckBox.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView , boolean isChecked) {
            String text1 = "";
            if (ck1.isChecked() || ck2.isChecked() || ck3.isChecked())
                text1 += "\n您最喜歡的顏色是:\n";
            if (ck1.isChecked())
                text1 += ck1.getText() + " ";
            if (ck2.isChecked())
                text1 += ck2.getText() + " ";
            if (ck3.isChecked())
                text1 += ck3.getText() + " ";
            result.setText(text1);
            if (ck4.isChecked() || ck5.isChecked() || ck6.isChecked())
                text1 +=  "\n您平常的休閒活動:\n";
            if (ck4.isChecked())
                text1 += ck4.getText() + " ";
            if (ck5.isChecked())
                text1 += ck5.getText() + " ";
            if (ck6.isChecked())
                text1 += ck6.getText() + " ";
            if (text1.endsWith(" "))
                result.setText(text1.substring(0, text1.length() - 1));
            else
                result.setText(text1);
        }
    };


}
