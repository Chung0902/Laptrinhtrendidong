package com.example.sabpham_sqline.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sabpham_sqline.Model.Sanpham;

public class DBMannager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="sanpham_manager";
    private static final String TABLE_NAME="sanpham";
    private static final String ID="id";
    private static final String TENSANPHAM="tensanpham";
    private static final String MOTA="mota";
    private static final String SOLUONG="soluong";
    private static final String GIATIEN="giatien";
    private static final int VERSION;

    static {
        VERSION = 1;
    }


    public DBMannager(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQLQuery = "CREATE TABLE " + TABLE_NAME + "(" +
                ID + " integer primary key, " +
                TENSANPHAM + " TEXT, " +
                MOTA + " TEXT, " +
                SOLUONG + " TEXT, " +
                GIATIEN + " TEXT)";
        sqLiteDatabase.execSQL(SQLQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addSanpham(Sanpham sanpham){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TENSANPHAM, sanpham.getmTensanpham());
        values.put(MOTA, sanpham.getmMota());
        values.put(SOLUONG, sanpham.getmSoluong());
        values.put(GIATIEN, sanpham.getmGiatien());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }
}
