package com.ina.poc2.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ina.poc2.room.Person;

import java.util.List;

@Dao
public interface PersonDao {
    @Query("Select * from person")
    List<Person> getpersonList();

    @Insert
    void insertPerson(Person person);

    @Update
    void updatePerson(Person person);

    @Delete
    void deletePerson(Person person);
}
