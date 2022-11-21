package com.example.bktra2.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.bktra2.Data.model.Cayxanh;

import java.util.ArrayList;
import java.util.List;

public class DBMannager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="cayxanh_manager";
    private static final String TABLE_NAME="cayxanh";
    private static final String ID="id";
    private static final String TENKHOAHOC="tenkhoahoc";
    private static final String TENTHUONGGOI="tenthuonggoi";
    private static final String DACTINH="dactinh";
    private static final String MAULA="maula";
    private static int VERSION = 1;

    private Context context;

    private String SQLQuery = "CREATE TABLE " +TABLE_NAME+" ("+
            ID +" integer primary key, "+
            TENKHOAHOC + " TEXT, "+
            TENTHUONGGOI + " TEXT, "+
            DACTINH + " TEXT, "+
            MAULA + " TEXT)";


    public DBMannager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addCayxanh(Cayxanh cayxanh){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TENKHOAHOC, cayxanh.getmTenkhoahoc());
        values.put(TENTHUONGGOI, cayxanh.getmTenthuonggoi());
        values.put(DACTINH, cayxanh.getmDactinh());
        values.put(MAULA, cayxanh.getmMaula());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public List<Cayxanh> getAllCayxanh(){
        List<Cayxanh> listCayxanh= new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                Cayxanh cayxanh = new Cayxanh();
                cayxanh.setmID(cursor.getInt(0));
                cayxanh.setmTenkhoahoc(cursor.getString(1));
                cayxanh.setmTenthuonggoi(cursor.getString(2));
                cayxanh.setmDactinh(cursor.getString(3));
                cayxanh.setmMaula(cursor.getString(4));
                listCayxanh.add(cayxanh);

            }while (cursor.moveToNext());
        }
        db.close();
        return listCayxanh;
    }

    public int updateCayxanh(Cayxanh cayxanh) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TENTHUONGGOI, cayxanh.getmTenkhoahoc());
        contentValues.put(TENTHUONGGOI, cayxanh.getmTenthuonggoi());
        contentValues.put(DACTINH, cayxanh.getmDactinh());
        contentValues.put(MAULA, cayxanh.getmMaula());
        return db.update(TABLE_NAME, contentValues, ID+"=?", new String[]{String.valueOf(cayxanh.getmID())});
    }

    public int delecteCayxanh(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,ID+"=?",new String[]{String.valueOf(id)});
    }
}
