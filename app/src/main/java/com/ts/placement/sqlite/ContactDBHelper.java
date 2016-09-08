package com.ts.placement.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ts-user on 9/1/2016.
 */
public class ContactDBHelper extends SQLiteOpenHelper
{
    public ContactDBHelper(Context context)
    {
        super(context,"ADDRESSBOOKDB",null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
     String CREATE_CONTACTS_TABLE = "create table CONTACT(id integer primary key"+
             ",name varchar,phone varchar)";
        db.execSQL("CREATE_CONTACT_TABLE");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXITS CONTACT");
        onCreate(db);
    }
    public void addContacts(Contact contact)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",contact.getId());
        contentValues.put("Name",contact.getName());
        contentValues.put("Phone",contact.getPhone());
        db.insert("CONTACT",null,contentValues);
    }
    public List<Contact> getAllContacts() {
        // Select Query
        String selectQuery = "SELECT  * FROM CONTACT";

        //retrieving records from table
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        //Create dynamic List to store contact objects
        List<Contact> contactList = new ArrayList<Contact>();

        // looping through all rows and adding to list
        while (cursor.moveToNext()) {
            Contact contact = new Contact();
            contact.setId(Integer.parseInt(cursor.getString(0)));
            contact.setName(cursor.getString(1));
            contact.setPhone(cursor.getString(2));
            // Adding contact to list
            contactList.add(contact);
        }
        Log.d("No of record", ""+contactList.size());
        // return contact list
        return contactList;
    }
}

