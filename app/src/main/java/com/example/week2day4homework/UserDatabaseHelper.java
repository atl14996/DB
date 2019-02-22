package com.example.week2day4homework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import static com.example.week2day4homework.UserDatabaseContract.COLUMN_ADDRESS;
import static com.example.week2day4homework.UserDatabaseContract.COLUMN_CITY;
import static com.example.week2day4homework.UserDatabaseContract.COLUMN_EMAIL;
import static com.example.week2day4homework.UserDatabaseContract.COLUMN_NAME;
import static com.example.week2day4homework.UserDatabaseContract.COLUMN_PHONE;
import static com.example.week2day4homework.UserDatabaseContract.COLUMN_STATE;
import static com.example.week2day4homework.UserDatabaseContract.COLUMN_USERID;
import static com.example.week2day4homework.UserDatabaseContract.COLUMN_ZIP;
import static com.example.week2day4homework.UserDatabaseContract.DATABASE_NAME;
import static com.example.week2day4homework.UserDatabaseContract.DATABASE_VERSION;
import static com.example.week2day4homework.UserDatabaseContract.TABLE_NAME;
import static com.example.week2day4homework.UserDatabaseContract.createQuery;

public class UserDatabaseHelper extends SQLiteOpenHelper {



    public UserDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {

db.execSQL(createQuery());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertUserIntoDatabase(@NonNull User user) {

        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        //Data holder used for database key value pairs
        ContentValues contentValues = new ContentValues();


        contentValues.put(COLUMN_NAME, user.getName());
        contentValues.put(COLUMN_ADDRESS, user.getAddress());
        contentValues.put(COLUMN_CITY, user.getCity());
        contentValues.put(COLUMN_STATE, user.getState());
        contentValues.put(COLUMN_ZIP, user.getZip());
        contentValues.put(COLUMN_EMAIL, user.getEmailAddress());
        contentValues.put(COLUMN_PHONE, user.getPhoneNumber());
        contentValues.put(COLUMN_USERID, user.getUserId());

        //insert the car into the table using contentValues

        return writeableDatabase.insert(TABLE_NAME, null, contentValues);


    }


    public static String getAllUsersQuery() {
        return "SELECT * FROM" + TABLE_NAME;
    }

    public ArrayList<User> getAllUsersFromDatabase() {

        ArrayList<User> returnUserList = new ArrayList<>();
        SQLiteDatabase readableDatabase = this.getReadableDatabase();

        Cursor cursor = readableDatabase.rawQuery(getAllUsersQuery(), null);

        if(cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_USERID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String address = cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS));
                String city = cursor.getString(cursor.getColumnIndex(COLUMN_CITY));
                String state = cursor.getString(cursor.getColumnIndex(COLUMN_STATE));
                String zip = cursor.getString(cursor.getColumnIndex(COLUMN_ZIP));
                String phone = cursor.getString(cursor.getColumnIndex(COLUMN_PHONE));
                String email = cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL));


                returnUserList.add(new User());
            }
            while (cursor.moveToNext());
            //return the result in a list
        }
        cursor.close();
        return returnUserList;
    }
}
