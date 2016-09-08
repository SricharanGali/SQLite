package com.ts.placement.sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText editText,editText2,editText3;
    SQLiteDatabase mydatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydatabase = openOrCreateDatabase("CharanDatabase",MODE_PRIVATE,null);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
    }
    public void insert(View view)
    {
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS TALENTSPRINT(Name VARCHAR,Id VARCHAR,Branch VARCHAR);");

        mydatabase.execSQL("INSERT INTO TALENTSPRINT VALUES('"+editText.getText()+"','"+editText2.getText()+"','"+editText3.getText()+"')");

        Toast.makeText(this,"Database Inserted",Toast.LENGTH_SHORT).show();
    }
    public void show(View view)
    {
        String query = "Select * from TALENTSPRINT";
        Cursor resultSet = mydatabase.rawQuery(query, null);
            resultSet.moveToNext();
            String name = resultSet.getString(0);
            String id = resultSet.getString(1);
            String branch = resultSet.getString(2);
            Toast.makeText(this, " Name : " + name + " ;Id : " + id + " ;Branch : " + branch, Toast.LENGTH_SHORT).show();
    }
    public void update(View view)
    {


    }
    public void delete(View view)
    {

    }
    public void main2(View view)
    {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    
}
