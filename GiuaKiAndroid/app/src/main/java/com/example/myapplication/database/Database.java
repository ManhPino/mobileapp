package com.example.myapplication.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void myQuery(String sql){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
    }
    public Cursor getData(String sql){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(sql,null);
    }
    public void createTable(){
        String query_cratetable = "CREATE TABLE IF NOT EXISTS Information(ID INTEGER PRIMARY KEY AUTOINCREMENT,Name VARCHAR(50), Email VARCHAR(200), Contact VARCHAR(200) , Address VARCHAR(200))";
        myQuery(query_cratetable);
    }
    public void insert_into_database(String dataFirst, String dataSecond,String dataThird,String dataFourth){
        String query_insertdata = "INSERT INTO Information VALUES(null,'"+dataFirst+"','"+dataSecond+"','"+dataThird+"','"+dataFourth+"')";
        myQuery(query_insertdata);
    }
    public void deletedata_into_databse(int id){
        String query_delete = "Delete from Information where ID = "+id+"";
        myQuery(query_delete);
    }
    public void update_database(String dataFirst, String dataSecond,String dataThird,String dataFourth, int id){
        String query_update = "UPDATE Information SET Name = '"+dataFirst+"' , Email = '"+dataSecond+"' , Contact ='"+dataThird+"' ,Address = '"+dataFourth+"'  WHERE ID = "+id+"  ";
        myQuery(query_update);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
