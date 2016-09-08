package com.ts.placement.sqlite;

/**
 * Created by ts-user on 9/1/2016.
 */
public class Contact
{
    int id;
    String name;
    String phone;

    public Contact()
    {
    }

    public Contact(int id, String name, String phone)
    {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }
}
