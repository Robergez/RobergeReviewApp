package com.example.zach.reviewappreal;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SplashScreen extends AppCompatActivity {

    public static reviewDbHelper helper;
    public static SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        helper = new reviewDbHelper(this);
        db = helper.getWritableDatabase();
    }

    protected void moveToAdd(View v){
        Intent intent = new Intent(this,AddRecord.class);
        startActivity(intent);
    }

    protected void addToList(View v){


    }

    protected void viewRecords(View v){
        Intent intent = new Intent(this,SummaryView.class);
        startActivity(intent);
    }
}
