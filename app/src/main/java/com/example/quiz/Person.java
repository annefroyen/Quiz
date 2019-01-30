package com.example.quiz;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;

public class Person extends AppCompatActivity {

    private Uri uri;
    private String name;

    public Person(Uri uri, String name){
        this.uri =uri;
        this.name=name;
    }

    public Uri getUri() {
        return uri;
    }

    public String getName() {
        return name;
    }

    public Person() {
    }
}
