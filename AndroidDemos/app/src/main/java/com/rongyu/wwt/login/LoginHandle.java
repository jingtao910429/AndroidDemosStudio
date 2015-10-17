package com.rongyu.wwt.login;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wwt on 15/10/15.
 */
public class LoginHandle {

    //保存用户名和密码到文件
    public static boolean saveUserInfo (String userName, String passWord, Context context) {

        File fileHandle = new File(context.getFilesDir(),"text.txt");

        try {
            FileOutputStream outputStream = new FileOutputStream(fileHandle);
            outputStream.write((userName + "##" + passWord).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //从文件中读取用户名和密码
    public static Map<String, String> getUserInfo (Context context) {
        Map<String, String> infoMap = new HashMap<String, String >();

        File fileHandle = new File(context.getFilesDir(),"text.txt");

        try {

            //InputStream提供的是字节流的读取，而非文本读取，这是和Reader类的根本区别。
            //即用Reader读取出来的是char数组或者String ，使用InputStream读取出来的是byte数组。

            FileInputStream inputStream = new FileInputStream(fileHandle);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String infoStr = bufferedReader.readLine();

            String[] userInfoArr = infoStr.split("##");

            infoMap.put("userName",userInfoArr[0]);
            infoMap.put("password",userInfoArr[1]);

            return infoMap;

        }catch (Exception e){
            e.printStackTrace();
        }



        return infoMap;
    }

}
