package com.rongyu.wwt.advancedCompent;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.rongyu.wwt.androiddemos.R;

public class SpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
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

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(spinnerAdapter);
    }

    private BaseAdapter spinnerAdapter = new BaseAdapter() {
        //共有多少项
        @Override
        public int getCount() {
            return 10;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            /*第一种布局方式

            TextView textView = new TextView(SpinnerActivity.this);
            textView.setText("当前第"+ position + "项");
            textView.setTextSize(20);
            textView.setTextColor(getResources().getColor(R.color.colorAccent));

            return textView;
            */

            /*第二种布局方式*/

            LinearLayout line = new LinearLayout(SpinnerActivity.this);

            line.setOrientation(LinearLayout.HORIZONTAL);
            ImageView imageView = new ImageView(SpinnerActivity.this);
            imageView.setImageResource(R.drawable.archives_personal);

            TextView textView = new TextView(SpinnerActivity.this);
            textView.setText("当前第"+ position + "项");
            textView.setTextSize(20);
            textView.setTextColor(getResources().getColor(R.color.colorAccent));

            line.addView(imageView);
            line.addView(textView);

            return line;
        }
    };

}
