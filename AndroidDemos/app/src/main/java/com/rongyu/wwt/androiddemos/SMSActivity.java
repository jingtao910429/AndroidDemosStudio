package com.rongyu.wwt.androiddemos;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SMSActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText phoneEditText;
    private EditText contentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

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

        phoneEditText = (EditText)findViewById(R.id.et_sms_phone);
        contentEditText = (EditText)findViewById(R.id.et_sms_content);

        Button sendMessageBtn = (Button)findViewById(R.id.sms_btn);
        sendMessageBtn.setOnClickListener(this);

        //高级组件部分
        Button highCompentBtn = (Button)findViewById(R.id.high_compent);
        highCompentBtn.setOnClickListener(this);

    }

    /**
     * 直接调用短信接口发短信
     * @param phoneNumber
     * @param message
     */

    private void sendMessage(String phoneNumber,String message) {

        SmsManager smsManager = SmsManager.getDefault();
        ArrayList<String> divideContents = smsManager.divideMessage(message);
        for (String text : divideContents){
            smsManager.sendTextMessage(phoneNumber, null, text, null, null);
        }

    }

    /**
     * 调起系统发短信功能
     * @param phoneNumber
     * @param message
     */

    private void doSendSMSTo(String phoneNumber,String message){

        /**
         * PhoneNumberUtils
         * Various utilities for dealing with phone number strings.
         *
         * inner method
         *   Matcher match = GLOBAL_PHONE_NUMBER_PATTERN.matcher(phoneNumber);
         *   match.matches();
         *
         *   private static final Pattern GLOBAL_PHONE_NUMBER_PATTERN =
             Pattern.compile("[\\+]?[0-9.-]+");
         */

        //
        if (PhoneNumberUtils.isGlobalPhoneNumber(phoneNumber)){
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+phoneNumber));
            intent.putExtra("sms_body",message);
            startActivity(intent);
        }
    }


    //发送短信
    public void sendSMS() {

        String phoneStr = phoneEditText.getText().toString().trim();
        String contentStr = contentEditText.getText().toString().trim();

        if (phoneStr == null || phoneStr.length() == 0 || contentStr == null || contentStr.length() == 0){
            Toast.makeText(SMSActivity.this,"电话号码或者短信内容不能为空",Toast.LENGTH_SHORT).show();
            return;
        }
        sendMessage(phoneStr,contentStr);
    }

    //高级控件部分
    public void highCompentBtnClick() {

        Intent highCompentIntent = new Intent(SMSActivity.this,AdvancedComponentActivity.class);
        startActivity(highCompentIntent);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.sms_btn:
                sendSMS();
                break;
            case R.id.high_compent:
                highCompentBtnClick();
                break;
            default:
                break;
        }


    }
}
