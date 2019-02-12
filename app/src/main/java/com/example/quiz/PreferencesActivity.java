package com.example.quiz;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class PreferencesActivity  extends AppCompatActivity {


    private TextView owner;

    @Override
    public void onCreate(Bundle savedInstanceStatee) {
        super.onCreate(savedInstanceStatee);
        setContentView(R.layout.activity_preferences);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SharedPreferences SP = getApplicationContext().getSharedPreferences("NAME",0);

        owner = findViewById(R.id.owner);
        owner.setText(SP.getString("Name", null));

    }
}
