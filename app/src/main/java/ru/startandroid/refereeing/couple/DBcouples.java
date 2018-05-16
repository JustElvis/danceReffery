package ru.startandroid.refereeing.couple;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Slav on 28.12.2016.
 */

public class DBcouples {
    private static final String DB_NAME = "mDBcouples";
    private static final int DB_VERSION  = 1;
    private static final String TABLE_NAME = "couples";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NUMBER = "number";
    public static final String COLUMN_PLACE = "place";
    private static final String DB_CREATE =
            "create table " + TABLE_NAME + "(" +
                    COLUMN_ID + " integer primary key autoincrement, " +
                    COLUMN_NUMBER + " text, " +
                    COLUMN_PLACE + " integer" +
                    ");";

    String[] numbers = {"12", "53", "31", "41", "74", "73", "71", "85", "841", "672", "134", "853",
            "234", "669", "666", "342", "931", "111", "222", "333", "444", "555", "166", "777"};

    private final Context mCtx;

    public DBHelper myDBHelper;
    public  SQLiteDatabase mDB;

    public DBcouples(Context context){
        mCtx = context;
    }
    public void open(){
        myDBHelper = new DBHelper(mCtx, DB_NAME, null, DB_VERSION);
        mDB = myDBHelper.getWritableDatabase();
    }
    public void close(){
        if (myDBHelper != null) myDBHelper.close();
    }

    public Cursor getAllData(){
        return mDB.query(TABLE_NAME, null, null, null, null, null, null);
    }

    public String[] getFirstNumbers(){
        String[] num1 = new String[12];
        for (int i = 0 ; i < 12 ; i++){
            num1[i] = numbers[i];
        }
        return num1;
    }

    public String[] getSecondNumbers(){
        String[] num2 = new String[12];
        for (int i = 12 ; i < 24; i ++){
            num2[i - 12] = numbers[i];
        }
        return num2;
    }

    public class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DB_CREATE);
            ContentValues cv = new ContentValues();
            for (int i = 0; i < numbers.length; i++){
                cv.put(COLUMN_NUMBER, numbers[i]);
                cv.put(COLUMN_PLACE, 0);
                db.insert(TABLE_NAME, null, cv);
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}