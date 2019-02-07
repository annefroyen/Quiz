package com.example.quiz;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM People")
    List<Person> getAll();

    @Query("SELECT * FROM People WHERE id IN (:userIds)")
    List<Person> loadAllByIds(int[] userIds);

    //@Query("SELECT * FROM person WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
    //Person findByName(String first, String last);

    @Insert
    void insertAll(Person... person);

    @Insert
    void insert(Person person);

    @Delete
    void delete(Person person);
}

