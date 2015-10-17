package com.rongyu.wwt.advancedCompent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.rongyu.wwt.androiddemos.R;

import java.util.Calendar;
import java.util.Date;

public class DatesPickerActivity extends AppCompatActivity {

    private int year,month,day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dates_picker);
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


        final DatePicker datePicker = (DatePicker)findViewById(R.id.datePicker);

        //日历类
        final Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        //注册日期更改监听事件
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                DatesPickerActivity.this.year = year;
                DatesPickerActivity.this.month = month;
                DatesPickerActivity.this.day = day;
                showDate();
            }
        });
    }

    private void showDate () {
        EditText content = (EditText)findViewById(R.id.dateEditText);
        content.setText("当前选择日期为：" + year + "年" + month + "月" + day + "日");
    }

}
