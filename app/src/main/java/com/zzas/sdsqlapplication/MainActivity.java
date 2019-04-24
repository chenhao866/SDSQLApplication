package com.zzas.sdsqlapplication;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zzas.chen.SDsqlist.DatabaseContext;
import com.zzas.chen.SDsqlist.SdCardDBHelper;
import com.zzas.chen.SDsqlist.ShortCut;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseContext dbContext = new DatabaseContext(this);
        SdCardDBHelper dbHelper = new SdCardDBHelper(dbContext);
        ShortCut shortCut = new ShortCut();
        shortCut.createShortCut(MainActivity.this,R.mipmap.ic_launcher,R.string.app_name);//首次启动注册图标
        mysun();
    }


    private void mysun(){
        new Thread(new Runnable(){
            @Override
            public void run() {
                DatabaseContext dbContext = new DatabaseContext(MainActivity.this);
                SdCardDBHelper dbHelper = new SdCardDBHelper(dbContext);
                SQLiteDatabase db = dbHelper.getWritableDatabase();// 取得数据库操作
                dbHelper.saveUserinfo(db);
            }
        }).start();
    }
}
