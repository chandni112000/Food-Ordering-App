//package com.example.foodorderingapp;
//
//import android.content.ContentValues;
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//
//import androidx.annotation.Nullable;
//
//public class DBLogin extends SQLiteOpenHelper {
//
//    public static final String DBNAME = "Login.db";
//
//    public DBLogin(Context context) {
//        super(context, "Login.db", null, 1);
//    }
//
//    @Override
//    public void onCreate(SQLiteDatabase MyDB) {
//        MyDB.execSQL("create Table users(Gmail TEXT primary key  , password TEXT)");
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
//        MyDB.execSQL("drop Table if exists users");
//
//    }
//
////    public Boolean insertData(String gmail , String password){
////        SQLiteDatabase MyDB = this.getWritableDatabase();
////        ContentValues contentValues = new ContentValues();
////        contentValues.put("Gmail", gmail);
////        contentValues.put("password" , password);
////        long result = MyDB.insert("users", null, contentValues);
////        if (result == -1) return false;
////        else
////            return true;
////    }
////
////    public Boolean checkusergmail(String Gmail){
////        SQLiteDatabase MyDB = this.getWritableDatabase();
////        Cursor cursor = MyDB.rawQuery("select * from users where Gmail = ?", new String[] {Gmail});
////        if (cursor.getCount()>0)
////            return true;
////        else
////           return false;
////
////    }
////
////    public Boolean checkusergmaipassword(String Gmail, String password){
////        SQLiteDatabase MyDB = this.getWritableDatabase();
////        Cursor cursor = MyDB.rawQuery("Select * from users where Gmail = ? and password = ?", new String[] {Gmail,password});
////        if (cursor.getCount()>0)
////            return true;
////        else
////            return false;
////
////    }
////}
