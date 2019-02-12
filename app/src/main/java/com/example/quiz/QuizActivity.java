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

import com.example.quiz.Database.App;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    public Button submitButton;
    public Button exitButton;
    public EditText et_answer;
    public TextView tv_score;
    public ImageView userImage;

    List<Person> list;
    String correct_answer;
    int score = 0;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        list = ((App) getApplicationContext()).getOurDAO().getAll();

        et_answer = (EditText) findViewById(R.id.et_answer);
        tv_score = (TextView) findViewById(R.id.tv_score);
        userImage = (ImageView)findViewById(R.id.userImage);
        submitButton = (Button) findViewById(R.id.submitButton);

        initView();
    }


    private void initView() {

       setupList();

        submitButton.setOnClickListener(new View.OnClickListener() {
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
        correct_answer = currentPerson.getName();
    }

}