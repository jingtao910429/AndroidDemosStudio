package com.rongyu.wwt.androiddemos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.rongyu.wwt.advancedCompent.AutoCompleteTextViewActivity;
import com.rongyu.wwt.advancedCompent.DatesPickerActivity;
import com.rongyu.wwt.advancedCompent.ProgressBarActivity;
import com.rongyu.wwt.advancedCompent.SpinnerActivity;
import com.rongyu.wwt.advancedCompent.TimePickerActivity;

/*
* 高级组件部分
* */

public class AdvancedComponentActivity extends AppCompatActivity implements View.OnClickListener{

    public static enum ActivityType {
        AutoCompleteTextView,
        Spinner,
        DatePicker,
        TimerPicker,
        ProgressBar
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_component);
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


        Button autoCompleteBtn = (Button)findViewById(R.id.autoCompeleteTV);
        autoCompleteBtn.setOnClickListener(this);

        Button spinnerBtn = (Button)findViewById(R.id.spinner);
        spinnerBtn.setOnClickListener(this);

        Button datePicker = (Button)findViewById(R.id.date_pickerBtn);
        datePicker.setOnClickListener(this);

        Button timePicker = (Button)findViewById(R.id.timeBtn);
        timePicker.setOnClickListener(this);

        Button progressBar = (Button)findViewById(R.id.btn_progress);
        progressBar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            //自动完成文本框
            case R.id.autoCompeleteTV:
                jumpActivity(ActivityType.AutoCompleteTextView);
                break;
            case R.id.spinner:
                jumpActivity(ActivityType.Spinner);
                break;
            case R.id.date_pickerBtn:
                jumpActivity(ActivityType.DatePicker);
                break;
            case R.id.timeBtn:
                jumpActivity(ActivityType.TimerPicker);
                break;
            case R.id.btn_progress:
                jumpActivity(ActivityType.ProgressBar);
            default:
                break;
        }
    }

    private void jumpActivity (ActivityType type) {

        Intent jumpIntent = null;

        switch (type) {
            //自动完成文本框
            case AutoCompleteTextView:
                jumpIntent = new Intent(AdvancedComponentActivity.this, AutoCompleteTextViewActivity.class);
                break;
            //列表选择框
            case Spinner:
                jumpIntent = new Intent(AdvancedComponentActivity.this, SpinnerActivity.class);
                break;
            //日期选择框
            case DatePicker:
                jumpIntent = new Intent(AdvancedComponentActivity.this, DatesPickerActivity.class);
                break;
            //时间选择框
            case TimerPicker:
                jumpIntent = new Intent(AdvancedComponentActivity.this, TimePickerActivity.class);
                break;
            //进度
            case ProgressBar:
                jumpIntent = new Intent(AdvancedComponentActivity.this, ProgressBarActivity.class);
            default:
                break;
        }

        if (jumpIntent == null){
            Toast.makeText(AdvancedComponentActivity.this,"Activity目的不明",Toast.LENGTH_LONG).show();
        }else{
            startActivity(jumpIntent);
        }
    }
}
