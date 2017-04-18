package com.example.irobot.registerationform;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

public class UserData extends ContentProvider {
    SQLiteDatabase sql;
    DBhelper dBhelper;
    public UserData() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        String tab = uri.getLastPathSegment();
        int i = sql.delete(tab,selection,null);
        return i;


    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.


        String tab = uri.getLastPathSegment();
        long l = sql.insert(tab,null,values);
        Uri dummy = Uri.parse("Completed/"+l);

        return dummy;
        //throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.

        dBhelper = new DBhelper(getContext(),Util.DB_Name,null,Util.DB_Version);
        sql = dBhelper.getWritableDatabase();
        return false;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.


        Log.i("Test2","Success");
        String tb = uri.getLastPathSegment();
        Log.i("Test3",tb);
        Cursor cursor = sql.query(tb,projection,null,null,null,null,null);
        Log.i("Test4","Success");



        return  cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        String tab = uri.getLastPathSegment();
        int f = sql.update(tab,values,selection,null);
        return f;

    }


    class DBhelper extends SQLiteOpenHelper {

        public DBhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(Util.Create_Tab);//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++-----------------------------------------------+-
            Log.i("Table","Created");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
