package com.example.baitap_giuaky.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.baitap_giuaky.model.Sanpham;

import java.util.ArrayList;
import java.util.List;

public class DBMannager extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="sanpham_manager";
    private static final String TABLE_NAME="sanpham";
    private static final String ID="id";
    private static final String TENSANPHAM="tensanpham";
    private static final String MOTA="mota";
    private static final String SOLUONG="soluong";
    private static final String GIATIEN="giatien";
    private static int VERSION = 1;

    private Context context;

    private String SQLQuery = "CREATE TABLE " +TABLE_NAME+" ("+
            ID +" integer primary key, "+
            TENSANPHAM + " TEXT, "+
            MOTA + " TEXT, "+
            SOLUONG + " TEXT, "+
            GIATIEN + " TEXT)";

    public DBMannager(Context context) {
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

    public List<Sanpham>getAllSanpham(){
        List<Sanpham> listSanpham = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                Sanpham sanpham = new Sanpham();
                sanpham.setmID(cursor.getInt(0));
                sanpham.setmTensanpham(cursor.getString(1));
                sanpham.setmMota(cursor.getString(2));
                sanpham.setmSoluong(cursor.getString(3));
                sanpham.setmGiatien(cursor.getString(4));
                listSanpham.add(sanpham);

            }while (cursor.moveToNext());
        }
        db.close();
        return listSanpham;
    }

    public int updateSanpham(Sanpham sanpham) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TENSANPHAM, sanpham.getmTensanpham());
        contentValues.put(MOTA, sanpham.getmMota());
        contentValues.put(SOLUONG, sanpham.getmSoluong());
        contentValues.put(GIATIEN, sanpham.getmGiatien());
        return db.update(TABLE_NAME, contentValues, ID+"=?", new String[]{String.valueOf(sanpham.getmID())});
    }

    public int delecteSanpham(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,ID+"=?",new String[]{String.valueOf(id)});
    }
}
