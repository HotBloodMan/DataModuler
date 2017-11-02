package com.ljt.datamoduler;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExternalActivity extends AppCompatActivity {


    private static final String FILENAME="data.txt";
    private static final String DNAME="myfiles";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        setContentView(tv);

        //创建文件的引用
//        File dataFile = new File(Environment.getExternalStorageDirectory(), FILENAME);
        File dataFile = new File(Environment.getExternalStorageDirectory(), DNAME);
        if(!dataFile.exists()){
            dataFile.mkdirs();
        }
//        if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
//            Toast.makeText(this,"Cannot use storage.",Toast.LENGTH_SHORT).show();
//            finish();
//            return;
//        }

        File dataFiles = new File(dataFile, FILENAME);


        //创建文件 并写入数据
        try{
            FileOutputStream mOutput = new FileOutputStream(dataFiles, false);
            String data="THIS DATA WRITEN HHH TO A FILE";
            mOutput.write(data.getBytes());
            mOutput.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        //读取已经存在文件并显示在屏幕上
        try {
            FileInputStream mIput = new FileInputStream(dataFiles);
            byte[] data = new byte[128];
            mIput.read(data);
            mIput.close();

            String display = new String(data);
            tv.setText(display.trim());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataFile.delete();


    }
}
