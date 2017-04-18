package com.example.irobot.registerationform;

import android.net.Uri;

/**
 * Created by iROBOT on 4/12/2017.
 */

public class Util {

    public static final String Create_Tab = "create table UserDetails( _ID integer primary key autoincrement,"+

                                                "USERNAME varchar(256),"+
                                                "PASSWORD varchar(256),"+
                                                "EMAIL varchar(256),"+
                                                "FIRST_NAME varchar(256),"+
                                                "LAST_NAME varchar(256),"+
                                                "GENDER varchar(256))";
    public static final String DB_Name = "Users.db";

    public static final String TAB_NAME = "UserDetails";
    public static final int DB_Version = 1;
    public static final String COL_ID = "_ID";
    public static final String COL_Username = "USERNAME";
    public static final String COL_password = "PASSWORD";
    public static final String COL_Email = "EMAIL";
    public static final String COL_fname = "FIRST_NAME";
    public static final String COL_lname = "LAST_NAME";
    public static final String COL_gender = "GENDER";

    public static final Uri URI= Uri.parse("content://com.example.irobot.registerationform.userdata/"+TAB_NAME);

}
