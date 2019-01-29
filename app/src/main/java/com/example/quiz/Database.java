package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class Database extends AppCompatActivity {


    int[] image_list={
            R.drawable.joey,
            R.drawable.ross,
            R.drawable.rachel,
            R.drawable.chandler,
            R.drawable.phoebe,
            R.drawable.monica,
    };

    public Button nextButton;
    public Button addButton;
    public Button prevButton;
    public Button exitButton;
    public Button deleteButton;
    public ImageView iv_image;
    public TextView tv_name;
    String name;
    int i = 0;

    public Database() {
    }

    public int[] getImage_list() {
        return image_list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        addButton = (Button) findViewById(R.id.addButton);
        nextButton = (Button) findViewById(R.id.nextButton);
        exitButton = (Button) findViewById(R.id.exitButton);
        deleteButton = (Button) findViewById(R.id.deleteButton);
        prevButton = (Button) findViewById(R.id.prevButton);
        tv_name = (TextView) findViewById(R.id.tv_name);
        iv_image = (ImageView)findViewById(R.id.iv_image);

        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Database.this, MainActivity.class);
                startActivity(intent);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //DELETE PERSON
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
               if(i > image_list.length-1) {
                   i=0;
               }
               setupList(i);

            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i--;
                if(i < 0) {
                    i=image_list.length-1;
                }
                setupList(i);
            }
        });
    }


    private void setupList(int i) {
        int imageSelected = image_list[i];
        iv_image.setImageResource(imageSelected);

        name = getResources().getResourceEntryName(imageSelected);
        tv_name.setText(name);
    }

   // private lengthProblem(int i) {
       // int size = image_list.length;
       // if(i > (size-1) || i < 0){
         //   return true;
        //}
       //// return false;
    //}

}