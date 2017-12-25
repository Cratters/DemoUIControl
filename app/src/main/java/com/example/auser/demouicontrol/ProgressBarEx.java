package com.example.auser.demouicontrol;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarEx extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;
    Button reset;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);
        findViews();
        new MyAsyncTask().execute("開始下載");
        reset.setOnClickListener(listener);
    }

    private class MyAsyncTask extends AsyncTask<String,Integer,String> {

        @Override
        protected String doInBackground(String... params) {   //背景執行續
            if (params[0].equals("開始下載")) {
                for (i = 0; i <= 100; i++) {

                    try {
                        Thread.sleep(100);
                        publishProgress(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            return "下載完畢";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {   //UI執行續
            super.onProgressUpdate(values);
            textView.setText(values[0]+"%");
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(ProgressBarEx.this,s,Toast.LENGTH_SHORT).show();
        }
    }

    void findViews(){
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        textView = (TextView)findViewById(R.id.textView);
        reset = (Button)findViewById(R.id.reset);
    }

    Button.OnClickListener listener = new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            i=100;
            textView.setText("");
            new MyAsyncTask().execute("開始下載");
        }
    };
}
