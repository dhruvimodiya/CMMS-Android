package com.example.project02;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperCom extends SQLiteOpenHelper {
    public DBHelperCom(@Nullable Context context) {
        super(context, "reg", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table complain(deviceid TEXT primary key,date TEXT,device TEXT,problem TEXT,proc TEXT,dec TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists complain");
    }
    public boolean insertcomdata(String deviceid, String date,String device,String problem,String proc,String dec){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("deviceid", deviceid);
        contentValues.put("date", date);
        contentValues.put("device", device);
        contentValues.put("problem", problem);
        contentValues.put("proc", proc);
        contentValues.put("dec", dec);
        long result = db.insert("complain",null, contentValues);
        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select deviceid,date,device,problem,proc,dec from complain",null);
        return cursor;
    }
    public boolean updateuserdata(String deviceid, String date,String device,String problem,String proc,String dec){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("date", date);
        contentValues.put("device", device);
        contentValues.put("problem", problem);
        contentValues.put("proc", proc);
        contentValues.put("dec", dec);
        Cursor cursor = db.rawQuery("select * from complain where deviceid=?",new String[]{deviceid});
        if(cursor.getCount() > 0) {
            long result = db.update("complain", contentValues, "deviceid=?", new String[]{deviceid});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else {
            return false;
        }
    }
    public boolean deletedata(String deviceid){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from complain where deviceid=?",new String[]{deviceid});
        if(cursor.getCount() > 0) {
            long result = db.delete("complain", "deviceid=?", new String[]{deviceid});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else {
            return false;
        }
    }
}
