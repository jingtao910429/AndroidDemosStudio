package com.rongyu.wwt.androiddemos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rongyu.wwt.advancedCompent.AutoCompleteTextViewActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        Button dailBtn = (Button)findViewById(R.id.main_dailbtn);
        dailBtn.setOnClickListener(this);

        Button sendMessageBtn = (Button)findViewById(R.id.main_sendMessage);
        sendMessageBtn.setOnClickListener(this);

        //数据存储按钮事件
        Button storeBtn =  (Button)findViewById(R.id.main_storeBtn);
        storeBtn.setOnClickListener(this);

        Button advancedCompentBtn = (Button)findViewById(R.id.mian_advancedCompent);
        advancedCompentBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent jumpIntent = null;

        switch (v.getId()) {
            case R.id.main_dailbtn:
                jumpIntent = new Intent(MainActivity.this, DailPhoneActivity.class);
                break;
            case R.id.main_sendMessage:
                jumpIntent = new Intent(MainActivity.this, SMSActivity.class);
                break;
            case R.id.main_storeBtn:
                jumpIntent = new Intent(MainActivity.this, FileSaveToMemoryActivity.class);
                break;
            case R.id.mian_advancedCompent:
                jumpIntent = new Intent(MainActivity.this, AdvancedComponentActivity.class);
            default:
                break;
        }

        if (jumpIntent == null){
            Toast.makeText(MainActivity.this, "Activity目的不明", Toast.LENGTH_LONG).show();
        }else{
            startActivity(jumpIntent);
        }
    }

}
