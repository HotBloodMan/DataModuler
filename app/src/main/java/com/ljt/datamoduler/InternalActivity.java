package com.ljt.datamoduler;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InternalActivity extends AppCompatActivity {

    private static final String FILENAME="data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        setContentView(tv);

        //新建一个文件并写入数据
        try{
            FileOutputStream outputStream = openFileOutput(FILENAME, Activity.MODE_PRIVATE);
            String data="THIS DATA WRITEN TO A FILE";
            outputStream.write(data.getBytes());
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        //读取已经创建的文件并显示在屏幕上
        try {
            FileInputStream mInput = openFileInput(FILENAME);
            byte[] data = new byte[128];
            mInput.read(data);
            mInput.close();

            String display = new String(data);
            tv.setText(display.trim());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //删除创建的文件
        deleteFile(FILENAME);


    }
}
