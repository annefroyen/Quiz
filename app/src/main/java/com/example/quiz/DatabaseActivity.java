package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.net.Uri;
import android.widget.Toast;
import com.example.quiz.Database.*;

import java.util.*;

public class DatabaseActivity extends AppCompatActivity {

    public Button nextButton;
    public Button addButton;
    public Button prevButton;
    public Button exitButton;
    public Button deleteButton;

    public ImageView iv_image;
    public TextView tv_name;
    private TextView number;
    private String size;

    int i = 0;
    List<Person> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        list = ((App) getApplicationContext()).getOurDAO().getAll();


        init();

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String name =  tv_name.getText().toString();
               Person newPerson = ( (App)getApplicationContext()).getOurDAO().findByName(name);
               ( (App)getApplicationContext()).getOurDAO().delete(newPerson);
                Intent intent = new Intent(DatabaseActivity.this, DatabaseActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),name + " deleted!",Toast.LENGTH_LONG).show();
            }
        });


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DatabaseActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        initView();
    }

    private void init(){
        tv_name = (TextView) findViewById(R.id.tv_name);
        iv_image = (ImageView) findViewById(R.id.iv_image);
        addButton = (Button) findViewById(R.id.addButton);
        nextButton = (Button) findViewById(R.id.nextButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        prevButton = (Button) findViewById(R.id.prevButton);
        number = (TextView) findViewById(R.id.number);
    }

    private void initView() {

        setupList(0);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if (i > list.size() - 1) { i = 0; }
               setupList(i);

            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i--;
                if (i < 0) { i = list.size() - 1; }
               setupList(i);
            }
        });
    }

    private void setupList(int i) {

        //henter ut person
        Person currentPerson = list.get(i);

        //henter ut bilde
        String currentUri = currentPerson.getUri();
        Uri uri = Uri.parse(currentUri);
        iv_image.setImageURI(uri);

        //henter ut navn
        String name = currentPerson.getName();
        tv_name.setText(name);


        //setter størrelse
        size = Integer.toString(list.size());
        number.setText(size);
    }

    public String getTheSize() {
        return size;
    }
}