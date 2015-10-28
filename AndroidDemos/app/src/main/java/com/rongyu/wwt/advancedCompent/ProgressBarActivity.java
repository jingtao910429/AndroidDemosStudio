package com.rongyu.wwt.advancedCompent;

import android.os.Bundle;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.rongyu.wwt.androiddemos.R;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class ProgressBarActivity extends AppCompatActivity {

    private int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
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

        final ProgressBar progressBarLarge = (ProgressBar)findViewById(R.id.progressBarLarge);
        final ProgressBar progressBarHorizontal = (ProgressBar)findViewById(R.id.progressBarHorizontal);

        //主要接受子线程发送的数据， 并用此数据配合主线程更新UI。
        final Handler mHandler = new Handler() {
            @Override
            public void close() {

            }

            @Override
            public void flush() {

            }

            @Override
            public void publish(LogRecord record) {
                System.out.print(progress + "fuck-----------------fuck");
                progressBarLarge.setProgress(progress);
                progressBarHorizontal.setProgress(progress);
            }
        };

        //启动线程执行任务
        new Thread(){
            @Override
            public void run() {
                super.run();

                while (progress < 100) {
                    progress = doWork();

                    System.out.print(progress + "fuck-----------------fuck");

                    Message progressMessage = new Message();
                    progressMessage.what = 0x111;

                    try {

                        Level level = Level.ALL;
                        LogRecord logRecord = new LogRecord(level,"progress");
                        mHandler.publish(logRecord);

                    }catch (NullPointerException exception){

                    }

                }

            }
        }.start();

    }

    public int doWork() {
        System.out.print(progress + "------");
        progress ++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return progress;
    }

}
