package com.example.auser.demouicontrol;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class RadioButtonEx extends AppCompatActivity {

    RadioGroup rg1,rg2,rg3;
    Button submit;
    TextView result;
    RadioButton rBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobutton);
        findViews();
        setListenters();
    }

    private  void findViews() {
        rg1 = (RadioGroup) findViewById(R.id.radioGroup1);
        rg2 = (RadioGroup) findViewById(R.id.radioGroup2);
        rg3 = (RadioGroup) findViewById(R.id.radioGroup3);
        submit = (Button) findViewById(R.id.button);
        result = (TextView) findViewById(R.id.textView4);
    }

    private  void setListenters(){
        submit.setOnClickListener(btnListener);
        rg1.setOnCheckedChangeListener(rgListener);
        rg2.setOnCheckedChangeListener(rgListener);
        rg3.setOnCheckedChangeListener(rgListener);
    }

    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            rBtn = (RadioButton)findViewById(rg1.getCheckedRadioButtonId());
            String text = "您對此次用餐感到"+rBtn.getText();
            rBtn = (RadioButton)findViewById(rg2.getCheckedRadioButtonId());
            text += "\n您的性別是"+rBtn.getText();
            rBtn = (RadioButton)findViewById(rg3.getCheckedRadioButtonId());
            text += "\n您的年齡為"+rBtn.getText();
            result.setText(text);
        }
    };

    RadioGroup.OnCheckedChangeListener rgListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

            switch (group.getId()) {
                case R.id.radioGroup1:
                    rBtn = (RadioButton) findViewById(rg1.getCheckedRadioButtonId());
                    break;
                case R.id.radioGroup2:
                    rBtn = (RadioButton) findViewById(rg2.getCheckedRadioButtonId());
                    break;
                case R.id.radioGroup3:
                    rBtn = (RadioButton) findViewById(rg3.getCheckedRadioButtonId());
                    break;
            }
                    String groupName = ""+rBtn.getText();
                    Toast.makeText(RadioButtonEx.this,groupName,Toast.LENGTH_SHORT).show();
        }
    };
}
