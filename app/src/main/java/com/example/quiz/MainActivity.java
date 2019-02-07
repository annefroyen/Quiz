package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quiz.Database.App;


public class MainActivity extends AppCompatActivity {

    private Button quizButton;
    private Button addButton;
    private Button databaseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //addFriends();

        init();

        quizButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent (MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent (MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        databaseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent (MainActivity.this, DatabaseActivity.class);
                startActivity(intent);
            }
        });

    }

    private void init(){
        quizButton = findViewById(R.id.quizButton);
        addButton = findViewById(R.id.addButton);
        databaseButton = findViewById(R.id.databaseButton);
    }


    public void addFriends() {

        Person joey = new Person("android.resource://com.example.quiz/drawable/joey", "joey");
        ((App) getApplicationContext()).getOurDAO().insert(joey);

        Person rachel = new Person("android.resource://com.example.quiz/drawable/rachel", "rachel");
        ((App) getApplicationContext()).getOurDAO().insert(rachel);

        Person monica = new Person("android.resource://com.example.quiz/drawable/monica", "monica");
        ((App) getApplicationContext()).getOurDAO().insert(monica);

        Person phoebe = new Person("android.resource://com.example.quiz/drawable/phoebe", "phoebe");
        ((App) getApplicationContext()).getOurDAO().insert(phoebe);

        Person chandler = new Person("android.resource://com.example.quiz/drawable/chandler", "chandler");
        ((App) getApplicationContext()).getOurDAO().insert(chandler);

        Person ross = new Person("android.resource://com.example.quiz/drawable/ross", "ross");
        ((App) getApplicationContext()).getOurDAO().insert(ross);

    }
}
