package com.rongyu.wwt.advancedCompent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.rongyu.wwt.androiddemos.R;

import java.util.Calendar;

public class TimePickerActivity extends AppCompatActivity {

    private int hour,minute,seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_view);
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

        TimePicker timePicker = (TimePicker)findViewById(R.id.timePicker);

        //日历类
        final Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        seconds = calendar.get(Calendar.SECOND);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                TimePickerActivity.this.hour = hourOfDay;
                TimePickerActivity.this.minute = minute;
                showTime();
            }
        });
    }

    private void showTime() {
        TextView textView = (TextView)findViewById(R.id.timer_textView);
        textView.setText("当前选择时间为：" + hour + "时" + minute + "分" + seconds + "秒");
    }

}
