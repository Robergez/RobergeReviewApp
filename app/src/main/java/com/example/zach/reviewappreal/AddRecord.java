package com.example.zach.reviewappreal;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddRecord extends AppCompatActivity {

    reviewDbHelper helper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);

        helper = new reviewDbHelper(this);
        db = helper.getReadableDatabase();
    }

    protected void insertRecord(View v){

        String rev = ((EditText) findViewById(R.id.addReview)).getText().toString();
        String ed = ((EditText) findViewById(R.id.addRating)).getText().toString();
        String t = ((EditText) findViewById(R.id.addTitle)).getText().toString();
        String d = ((EditText) findViewById(R.id.addDate)).getText().toString();



        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ReviewContract.Review.COLUMN_NAME_TITLE, t);
        values.put(ReviewContract.Review.COLUMN_NAME_REVIEW, rev);
        values.put(ReviewContract.Review.COLUMN_NAME_RATING, ed);
        values.put(ReviewContract.Review.COLUMN_NAME_DATE, d);


        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(ReviewContract.Review.TABLE_NAME, null, values);

        if(newRowId <= -1){
            TextView success = (TextView) findViewById(R.id.txtSuccess);
            success.setText("something went horribly wrong");
        }else{
            TextView success = (TextView) findViewById(R.id.txtSuccess);
            success.setText("Review added");
        }

    }
}
