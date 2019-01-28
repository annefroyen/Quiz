package com.example.quiz;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Add extends AppCompatActivity {

    ImageView add_imageView;
    Button captureButton, cancelButton, saveButton;
    EditText editName;

    Database database = new Database();
    int [] image_list = database.getImage_list();
    public static final int GET_FROM_GALLERY = 3;
    int RC_PHOTO_PICKER =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        init();

        captureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 openPhotoPicker();
                startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.INTERNAL_CONTENT_URI), RC_PHOTO_PICKER);
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String name = editName.getText().toString();
           // image_list.add(name);

            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Add.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    //@Override
  //  protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
       // if (requestCode == SELECT_PHOTO) {

           // if (resultCode == RESULT_OK) {
             //   if (intent != null) {
               //     // Get the URI of the selected file
               //     final Uri uri = intent.getData();
               //     useImage(uri);
               // }
          //  }
          //  super.onActivityResult(requestCode, resultCode, intent);v
      //  }
    //}




    void useImage(Uri uri)
    {
        //Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
        //use the bitmap as you like
        ///imageView.setImageBitmap(bitmap);
    }

    private void init() {
        add_imageView = (ImageView) findViewById(R.id.add_imageView);
        captureButton = (Button) findViewById(R.id.captureButton);
        cancelButton = (Button) findViewById(R.id.cancelButton);
        saveButton = (Button) findViewById(R.id.saveButton);
        editName = (EditText) findViewById(R.id.editName);
    }

    private void openPhotoPicker() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
        photoPickerIntent.setType("image/*");
        photoPickerIntent.putExtra(Intent.EXTRA_LOCAL_ONLY, false);
        startActivityForResult(Intent.createChooser(photoPickerIntent,"Complete Action Using"), RC_PHOTO_PICKER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_PHOTO_PICKER && resultCode == RESULT_OK && data != null) {
            Uri pickedImage = data.getData();
            add_imageView.setImageURI(pickedImage);
        }
    }

    private void savePerson(String name, ImageView v){
        //add_imageView.getImage();
        //image.renameTo(name);
    }
}