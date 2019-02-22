package com.example.week2day4homework;

import android.util.Log;

public class UserDatabaseContract {
    public static final String DATABASE_NAME = "user_db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "table_name";
    public static final String COLUMN_NAME = "username";
    public static final String COLUMN_ADDRESS= "address";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_STATE = "state";
    public static final String COLUMN_ZIP = "zip";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_USERID = "userid";

    public static String createQuery() {
        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("CREATE TABLE");
        queryBuilder.append(TABLE_NAME);
        queryBuilder.append(" ( ");
        queryBuilder.append(COLUMN_NAME);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_ADDRESS);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_CITY);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_STATE);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_ZIP);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_EMAIL);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_PHONE);
        queryBuilder.append(" TEXT,  ");
        queryBuilder.append(COLUMN_USERID);
        queryBuilder.append(" ");
        queryBuilder.append(" INT NONNULL IDENTITY PRIMARY ) ");

        Log.d("TAG", "createQuery: " + queryBuilder.toString());




        return queryBuilder.toString();

    }

    public static String getOneUserById(int id) {
        return String.format("SELECT * FROM %s WHERE %s = \"%d\"", TABLE_NAME, COLUMN_USERID, id);
        // return "SELECT * FROM" + TABLE_NAME + " WHERE " + COLUMN_ID + " = ";
    }


}
