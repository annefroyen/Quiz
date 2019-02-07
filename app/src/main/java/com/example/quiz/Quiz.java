package com.example.quiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.*;
import java.util.Random;

public class Quiz extends AppCompatActivity {
    public List<String> suggestSource = new ArrayList<>();
    public Button nextButton;
    public Button exitButton;
    public EditText et_answer;
    public TextView tv_score;
    public ImageView userImage;


    public char[] answer;
    List<Person> list;
    String correct_answer;
    int score = 0;
    int total = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        list = ((App) getApplicationContext()).getOurDAO().getAll();

        nextButton = (Button) findViewById(R.id.nextButton);
        exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Quiz.this, MainActivity.class);
                startActivity(intent);
            }
        });
        et_answer = (EditText) findViewById(R.id.et_answer);
        tv_score = (TextView) findViewById(R.id.tv_score);
        userImage = (ImageView)findViewById(R.id.userImage);

        initView();
    }

   // Mediastore.media.getBitmap.this.getcontentResolver

    private void initView() {

       setupList();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et_answer.getText().toString().toLowerCase().equals(correct_answer.toLowerCase())){
                  score++;
                  total++;
                  Toast.makeText(getApplicationContext(),"Correct!",Toast.LENGTH_SHORT).show();
                  tv_score.setText(score + "/" + total);
                  et_answer.getText().clear();
                  setupList();

                }else {
                    total++;
                    tv_score.setText(score + "/" + total);
                    Toast.makeText(getApplicationContext(), "Incorrect! \nThe correct answer is: "+correct_answer, Toast.LENGTH_LONG).show();
                    et_answer.getText().clear();
                }
            }
        });
    }


    private void setupList() {

        //henter random person
        Random random = new Random();
        Person currentPerson = list.get(random.nextInt(list.size()));

        //henter ut bilde
        String currentUri = currentPerson.getUri();
        Uri uri = Uri.parse(currentUri);
        userImage.setImageURI(uri);

        //henter ut navn
        String name = currentPerson.getName();
        correct_answer = name;

        //random

       correct_answer = correct_answer.substring(correct_answer.lastIndexOf("/")+1);

       answer = correct_answer.toCharArray();

       suggestSource.clear();
       for(char item:answer)
       {
            suggestSource.add(String.valueOf(item));
        }
        Collections.shuffle(suggestSource);

    }

}