package com.ina.poc2.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Person {
    @PrimaryKey(autoGenerate = true)

    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "city")
    public String city;

    public Person(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    @Ignore
    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
