package com.example.quiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Data {

    private ArrayList<Person> personList;
    private Add add;

    public void Data() {
        personList = new ArrayList<Person>();

    }

    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void addPerson(Person person){
        personList.add(person);
    }

    public void makeList(){
        //lage personer
        Uri joeyUri = Uri.parse("android.resource://com.example.quiz/drawable/joey");
        Person joey = new Person(joeyUri, "joey");

        Uri chandlerUri = Uri.parse("android.resource://com.example.quiz/drawable/chandler");
        Person chandler = new Person(chandlerUri, "chandler");

        Uri rachelUri = Uri.parse("android.resource://com.example.quiz/drawable/rachel");
        Person rachel = new Person(rachelUri, "rachel");

        System.out.print(rachel.getUri() + rachel.getName());


        personList.add(rachel);
       // personList.add(chandler);
       // personList.add(rachel);
    }
}