package com.example.quiz.Database;

import android.app.Application;
import android.arch.persistence.room.Room;

public class App extends Application {

    private UserDao ourDAO;

    @Override
    public void onCreate() {
        super.onCreate();
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
        AppDatabase.class, "NameQuiz").allowMainThreadQueries().build();
        setOurDAO(db.userDao());
        }

    public UserDao getOurDAO() {
        return ourDAO;
    }

    public void setOurDAO(UserDao ourDAO) {
        this.ourDAO = ourDAO;
    }
}
