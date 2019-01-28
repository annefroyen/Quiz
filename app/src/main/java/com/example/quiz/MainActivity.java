package com.example.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button quizButton;
    private Button addButton;
    private Button databaseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        quizButton = findViewById(R.id.quizButton);
        quizButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToQuiz();
            }
        });

        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToAdd();
            }
        });

        databaseButton = findViewById(R.id.databaseButton);
        databaseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToDatabase();
            }
        });
    }

    public void goToQuiz (){
        Intent intent = new Intent (this, Quiz.class);
        startActivity(intent);
    }

    public void goToAdd (){
        Intent intent = new Intent (this, Add.class);
        startActivity(intent);
    }

    public void goToDatabase (){
        Intent intent = new Intent (this, Database.class);
        startActivity(intent);
    }
}
