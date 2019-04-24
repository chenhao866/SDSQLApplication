package com.zzas.chen.SDsqlist;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SdCardDBHelper extends SQLiteOpenHelper {

    public static final String TAG = "SdCardDBHelper";
    public static String DATABASE_NAME = "sddb.db";
    public static int DATABASE_VERSION = 1;

    public SdCardDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // 插入记录
    public void saveUserinfo(SQLiteDatabase db) {
        db.execSQL("insert into user (name,password,role) " +
                        "values(?,?,?)",
                new String[] {"aaa","bbb","CCC"});
        db.close();// 记得关闭数据库操作
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e(TAG, "开始创建数据库表");
        try{
            //创建用户表(user)
            db.execSQL("create table if not exists user" +
                    "(_id integer primary key autoincrement,name varchar(20),password varchar(20),role varchar(10),updateTime varchar(20))");
            Log.e(TAG, "创建离线所需数据库表成功");
        }
        catch(SQLException se){
            se.printStackTrace();
            Log.e(TAG, "创建离线所需数据库表失败");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
