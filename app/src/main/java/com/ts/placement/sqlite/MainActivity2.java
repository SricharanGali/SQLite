package com.ts.placement.sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class MainActivity2 extends AppCompatActivity
{
    ContactDBHelper dbhelper;
    EditText id;
    EditText name;
    EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        id = (EditText) findViewById(R.id.name);
        name = (EditText) findViewById(R.id.id);
        phone = (EditText) findViewById(R.id.phone);

    }
    public void addContact(View view)
    {
        //reading values of all fields
        int cid = Integer.parseInt(id.getText().toString());
        String cname = name.getText().toString();
        String cphone = phone.getText().toString();
        //create Contact object
        Contact contact = new Contact(cid,cname,cphone);
        //calling addContacts() method
        dbhelper.addContacts(contact);
        //clear all fields
        id.setText("");
        name.setText("");
        phone.setText("");

    }
    public void listAllContacts(View view)
    {
        List<Contact> contacts = dbhelper.getAllContacts();
        int numOfRecords = contacts.size();
        for (int i = 0; i < numOfRecords; i++)
        {
            Contact ct = contacts.get(i);
            Log.d("Record " + (i + 1) + ":", "" + ct.getId() + " " + ct.getName() + " " + ct.getPhone());
        }
    }

    public void main(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}
