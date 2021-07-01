package com.neslihan.notuygulamasi;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.neslihan.notuygulamasi.model.Not;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    final static String DATABASE_NAME="Notlar";
    final static int DATABSE_VERSION=1;
    private String UPDATE_NOT;

    public Database(@Nullable Context context) {
        super(context, DATABASE_NAME, null , DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NOT="CREATE TABLE Notlar("+"id PRIMARY KEY AUTOINCREMENT, "+
                "baslik VARCHAR,"+
                "notMetin VARCHAR,"+
                "color VARCHAR)";

        db.execSQL(CREATE_NOT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXITS Notlar");
    }

    public void YeniNot(Not not){
        SQLiteDatabase db=this.getWritableDatabase();
        String INSERT_NOT="INSERT INTO Notlar(baslik,notMetin,color)"+
                "VALUES('" + not.getBaslik()+"','"+not.getNotMetin()+"','"+not.getRenk()+"')";

        db.execSQL(INSERT_NOT);
    }


    public ArrayList<Not> getNotlarim(){
        SQLiteDatabase db=this.getReadableDatabase();
        String SELECT_NOTLAR="SELECT * FROM Notlar ORDER BY in DESC";

        Cursor cursor = db.rawQuery(SELECT_NOTLAR,null);
        ArrayList<Not> Notlar= new ArrayList<>();

        if (cursor != null){
            cursor.moveToFirst();
            do {
                Not not=new Not();
                Not.setId(cursor.getInt(0));
                Not.setBaslik(cursor.getString(1));
                Not.setNotMetin(cursor.getString(2));
                Not.setRenk(cursor.getString(3));
                notlar.add(not);
            }while(cursor.moveToNext());

        }
        return notlar;
    }
    public void notGuncelle(Not not){
        SQLiteDatabase db= this.getWritableDatabase();
        String SELECT_NOT="UPDATE Notlar SET baslik='"+not.getBaslik()
                +"',notMetin='"+not.getNotMetin()
                +"',color='"+not.getRenk()+"' WHERE id="+not.getId();
        db.execSQL(UPDATE_NOT);
        db.close();
    }
    public void notSil(int id){
        SQLiteDatabase db= this.getWritableDatabase();
        String DELETE_NOT="DELETE FROM Notlar WHERE id="+id;
        db.execSQL(DELETE_NOT);
        db.close();

    }
}
