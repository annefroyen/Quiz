package com.example.quiz.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.quiz.Person;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM People")
    List<Person> getAll();

    @Query("SELECT * FROM People WHERE id IN (:userIds)")
    List<Person> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM People WHERE name LIKE :name LIMIT 1")
    Person findByName(String name);

    @Insert
    void insertAll(Person... person);

    @Insert
    void insert(Person person);

    @Delete
    void delete(Person person);
}

