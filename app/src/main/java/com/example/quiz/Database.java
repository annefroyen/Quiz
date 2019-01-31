package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.net.Uri;
import java.util.*;

public class Database extends AppCompatActivity {

    public Button nextButton;
    public Button addButton;
    public Button prevButton;
    public Button exitButton;

    ArrayList<Person> personList;


    public Button deleteButton;
    public ImageView iv_image;
    public TextView tv_name;
    String name;
    int i = 0;

    public Database() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        Data data = new Data();
       // personList = data.getPersonList();
        data.makeList();

        System.out.print("Funker det?" + data.getPersonList().size());



        addButton = (Button) findViewById(R.id.addButton);
        nextButton = (Button) findViewById(R.id.nextButton);
        exitButton = (Button) findViewById(R.id.exitButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        prevButton = (Button) findViewById(R.id.prevButton);
        tv_name = (TextView) findViewById(R.id.tv_name);
        iv_image = (ImageView) findViewById(R.id.iv_image);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Database.this, MainActivity.class);
                startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DELETE PERSON
                //image_list
                //personList.remove()


            }
        });


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Database.this, Add.class);
                startActivity(intent);
            }
        });

        initView();
    }

    private void initView() {
        setupList(0);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                if (i > personList.size() - 1) {
                    i = 0;
                }
                setupList(i);

            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i--;
                if (i < 0) {
                    i = personList.size() - 1;
                }
                setupList(i);
            }
        });
    }

    private void setupList(int i) {
        //henter ut person
       Person currentPerson =  personList.get(i);


        //henter ut bilde
        Uri currentUri = currentPerson.getUri();
        iv_image.setImageURI(currentUri);


        //henter ut navn
        name = currentPerson.getName();
        tv_name.setText(name);
    }


}