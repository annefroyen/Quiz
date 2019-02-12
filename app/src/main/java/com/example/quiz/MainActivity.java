package com.example.quiz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.quiz.Database.App;

import java.util.zip.Inflater;


public class MainActivity extends AppCompatActivity {

    private Button quizButton;
    private Button addButton;
    private Button databaseButton;
    private Dialog dialog;
    private Button saveOwner;
    private EditText ownerDialog;
    private SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFriends();

        init();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        boolean firstStart = prefs.getBoolean("firstStart", true);
        if(firstStart){
            showDialog();
        }


        quizButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        databaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DatabaseActivity.class);
                startActivity(intent);
            }
        });

    }


    private void showDialog(){

        LayoutInflater inflater = MainActivity.this.getLayoutInflater();
        View mView = inflater.inflate(R.layout.dialog_template, null);
        final EditText ownerDialog = (EditText)mView.findViewById(R.id.ownerDialog);

        new AlertDialog.Builder(this)
                .setTitle("Preference Dialog")
                .setView(mView)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String owner = ownerDialog.getText().toString();
                       SharedPreferencesSave(owner);
                        dialog.dismiss();
                    }
                })
                .create().show();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        //editor.putBoolean("firstStart", false);
        editor.apply();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.preferences:
                Intent intent1 = new Intent(this, PreferencesActivity.class);
                this.startActivity(intent1);
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }

    }

    private void init() {
        quizButton = findViewById(R.id.quizButton);
        addButton = findViewById(R.id.addButton);
        databaseButton = findViewById(R.id.databaseButton);
    }


    public void addFriends() {

        Person joey = new Person("android.resource://com.example.quiz/drawable/joey", "joey");
        ((App) getApplicationContext()).getOurDAO().insert(joey);

        Person rachel = new Person("android.resource://com.example.quiz/drawable/rachel", "rachel");
        ((App) getApplicationContext()).getOurDAO().insert(rachel);

        Person monica = new Person("android.resource://com.example.quiz/drawable/monica", "monica");
        ((App) getApplicationContext()).getOurDAO().insert(monica);

        Person phoebe = new Person("android.resource://com.example.quiz/drawable/phoebe", "phoebe");
        ((App) getApplicationContext()).getOurDAO().insert(phoebe);

        Person chandler = new Person("android.resource://com.example.quiz/drawable/chandler", "chandler");
        ((App) getApplicationContext()).getOurDAO().insert(chandler);

        Person ross = new Person("android.resource://com.example.quiz/drawable/ross", "ross");
        ((App) getApplicationContext()).getOurDAO().insert(ross);

    }

    public void SharedPreferencesSave(String name) {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("NAME", 0);
        SharedPreferences.Editor prefEDIT = prefs.edit();
        prefEDIT.putString("Name", name);
        prefEDIT.commit();
    }
}
