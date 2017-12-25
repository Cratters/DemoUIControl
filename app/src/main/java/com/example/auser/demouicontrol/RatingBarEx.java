package com.example.auser.demouicontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingBarEx extends AppCompatActivity {

    RatingBar ratingBar,ratingBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingbar);
        findViews();
        ratingBar.setOnRatingBarChangeListener(listener);
        ratingBar2.setOnRatingBarChangeListener(listener);
    }

    void findViews() {
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar2 = (RatingBar) findViewById(R.id.ratingBar2);
    }



    RatingBar.OnRatingBarChangeListener listener = new RatingBar.OnRatingBarChangeListener() {

        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            Toast.makeText(RatingBarEx.this, "你得到"+rating+"顆星星!",Toast.LENGTH_SHORT).show();
        }
    };

}
