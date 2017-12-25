package com.example.auser.demouicontrol;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewEx extends AppCompatActivity {

    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_ex);
        //ImageAdpter imageAdpter =new ImageAdpter();

    }

    class ImageAdpter extends BaseAdapter {
        int[] imageResIds = {
                R.drawable.img001, R.drawable.img002, R.drawable.img003,
                R.drawable.img004, R.drawable.img005, R.drawable.img006,
                R.drawable.img007, R.drawable.img008, R.drawable.img009,
        };

        Context mctx;

        ImageAdpter(Context context){
            mctx = context;
        }

        @Override
        public int getCount() {
            return imageResIds.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView = new ImageView(mctx);
            imageView.setLayoutParams( new GridView.LayoutParams(150,150));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageResource(imageResIds[i]);
            return imageView;
        }
    }
}
