package com.example.quiz.Database;

import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Database;

import com.example.quiz.Person;

@Database(entities = {Person.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}

