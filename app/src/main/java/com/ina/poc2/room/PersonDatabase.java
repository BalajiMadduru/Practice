package com.ina.poc2.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;



@Database(entities = Person.class, version = 1)
public abstract class PersonDatabase extends RoomDatabase {
    private static final String DB_NAME = "person_db";
    private static PersonDatabase instance;
    public static synchronized PersonDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder (context.getApplicationContext(), PersonDatabase.class,DB_NAME)
                      .fallbackToDestructiveMigration ()
                      .allowMainThreadQueries()
                       .build();
        }
        return instance;
    }
    public abstract PersonDao personDao();
}

