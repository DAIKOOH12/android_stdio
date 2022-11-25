package com.example.btl_caculator.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.btl_caculator.History;

import java.util.ArrayList;
import java.util.List;

public class CalculationHistory extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "History";
    private static final int DATABASE_VERSION = 1;

    private String TABLE_NAME="cal_history";
    private String ID="stt";
    private String LAST_CAL="last_cal";
    private String TOTAL="total";
    Context context;
    public CalculationHistory( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query= "CREATE TABLE "+ TABLE_NAME +" ( "
                + ID +" integer primary key autoincrement, "
                + LAST_CAL + " TEXT, "
                + TOTAL +" float)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void addHistory(History history){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(LAST_CAL,history.getCal());
        contentValues.put(TOTAL,history.getTotal());
        sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        sqLiteDatabase.close();
    }
    public ArrayList<History> getHistory(ArrayList<History> histories){     //update
        ArrayList<History> a = new ArrayList<History>();
        String selectAll = " SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectAll,null);

        cursor.moveToFirst();
        while(cursor.isAfterLast() == false) {
            History history=new History();
            history.setPosition(cursor.getInt(0));
            history.setCal(cursor.getString(1));
            history.setTotal(cursor.getFloat(2));
            a.add(history);
            cursor.moveToNext();
        }
        histories=a;
        return histories;
    }

    public Cursor GetData(String sql){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.rawQuery(sql,null);

    }

    public void Xoa(String cal, float total, int id){
        String query="DELETE FROM "+TABLE_NAME + " WHERE stt ='"+ id +"'";
        SQLiteDatabase db=this.getReadableDatabase();
        db.execSQL(query);

    }
    public void deleteHistory(){
        String query="DELETE FROM "+TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();

        db.execSQL(query);
    }
}
