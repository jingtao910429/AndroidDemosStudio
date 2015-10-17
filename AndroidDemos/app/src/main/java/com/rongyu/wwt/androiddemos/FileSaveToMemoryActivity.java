package com.rongyu.wwt.androiddemos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.rongyu.wwt.login.LoginHandle;

import java.util.Map;

public class FileSaveToMemoryActivity extends AppCompatActivity {

    private EditText userNameEditText;
    private EditText passwordEditText;
    private CheckBox forgetPasswordCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_save_to_memory);
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

        //保存文件到手机内存

        //用户名&密码
        userNameEditText = (EditText)findViewById(R.id.et_userName);
        passwordEditText = (EditText)findViewById(R.id.et_password);

        //记住密码checkBox
        forgetPasswordCheckBox = (CheckBox)findViewById(R.id.checkBox_forgetPassword);


        //显示默认用户名和密码

        Map<String,String> tempMapInfo = LoginHandle.getUserInfo(this);

        if (tempMapInfo.get("userName") == null || tempMapInfo.get("password") == null){
            userNameEditText.setText("");
            passwordEditText.setText("");
        }else{
            userNameEditText.setText(tempMapInfo.get("userName"));
            passwordEditText.setText(tempMapInfo.get("password"));
        }

        saveInfomation();

    }

    //保存
    public void saveInfomation(){

        String userName = userNameEditText.getText().toString().trim();
        String passWord = passwordEditText.getText().toString().trim();

        if (userName == null || userName.length() == 0 || passWord == null || passWord.length() == 0){
            Toast.makeText(FileSaveToMemoryActivity.this,"用户名或者密码不为空",Toast.LENGTH_LONG).show();
            return;
        }
        if (forgetPasswordCheckBox.isChecked()){
            //如果是记住密码，则存储密码到内存中
            LoginHandle.saveUserInfo(userName,passWord,this);
        }
    }


}
