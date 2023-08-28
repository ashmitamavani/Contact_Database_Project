package com.example.contact_database_project;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class My_Database extends SQLiteOpenHelper {
    public My_Database( Context context) {
        super(context, "Contact-book", null, 1);
        Log.d("TTT", "My_Database:Crete Contact ");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      String query="Create Table Contactbook(ID integer primary key autoincrement,NAME text,NUMBER text)";
      db.execSQL(query);
        Log.d("TTT", "onCreate: Create Table");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void AddContact(String name, String number) {
        String query="insert into Contactbook(NAME,NUMBER) values ('"+name+"','"+number+"')";
       SQLiteDatabase db=getWritableDatabase();
       db.execSQL(query);
    }

    public Cursor ShowData() {
        String query="Select *from Contactbook";
        SQLiteDatabase db=getReadableDatabase();
         Cursor cursor=db.rawQuery(query,null);
        return cursor;
    }

    public void UpdateContact(int id, String name, String number) {
        String query="update Contactbook set NAME='"+name+"',NUMBER='"+number+"'where ID="+id+"";
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(query);
    }

    public void DeleteContact(int id) {
        String query="delete from Contactbook where ID='"+id+"";
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL(query);
    }
}
