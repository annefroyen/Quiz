package com.example.quiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.quiz.Database.App;


public class AddActivity extends AppCompatActivity {

    private ImageView add_imageView;
    private Button captureButton, exitButton, saveButton;
    private EditText editName;

    private Person newPerson;
    private String name;
    private Uri uri;

    private int PHOTO_PICKER =1;

    public AddActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        init();

        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
                photoPickerIntent.setType("image/*");
                photoPickerIntent.putExtra(Intent.EXTRA_LOCAL_ONLY, false);
                startActivityForResult(Intent.createChooser(photoPickerIntent,"Complete Action Using"), PHOTO_PICKER);
                startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), PHOTO_PICKER);
            }
        });


    }

    private void init() {
        add_imageView = (ImageView) findViewById(R.id.add_imageView);
        captureButton = (Button) findViewById(R.id.captureButton);
        saveButton = (Button) findViewById(R.id.saveButton);
        editName = (EditText) findViewById(R.id.editName);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PHOTO_PICKER && resultCode == RESULT_OK && data != null) {

            uri = data.getData();
            add_imageView.setImageURI(uri);


            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    name = editName.getText().toString();
                    newPerson = new Person(uri.toString(), name);

                    ((App)getApplicationContext()).getOurDAO().insert(newPerson);

                    Toast.makeText(getApplicationContext(),
                            newPerson.getName() + " added!",
                            Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}