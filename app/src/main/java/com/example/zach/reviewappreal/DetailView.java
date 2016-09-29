package com.example.zach.reviewappreal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailView extends AppCompatActivity {

    reviewDbHelper helper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);

        TextView nameValue = (TextView) findViewById(R.id.txtTitle);
        TextView ratingValue = (TextView) findViewById(R.id.txtRating);
        TextView dateValue = (TextView) findViewById(R.id.txtDate);
        TextView reviewValue = (TextView) findViewById(R.id.txtReview);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);


        helper = new reviewDbHelper(this);
        db = helper.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + ReviewContract.Review.TABLE_NAME, null);

        c.moveToPosition(position);

        String t = c.getString(c.getColumnIndexOrThrow(ReviewContract.Review.COLUMN_NAME_TITLE));
        String rat = c.getString(c.getColumnIndexOrThrow(ReviewContract.Review.COLUMN_NAME_RATING));
        String d = c.getString(c.getColumnIndexOrThrow(ReviewContract.Review.COLUMN_NAME_DATE));
        String rev = c.getString(c.getColumnIndexOrThrow(ReviewContract.Review.COLUMN_NAME_REVIEW));

        nameValue.setText(t);
        ratingValue.setText(rat);
        dateValue.setText(d);
        reviewValue.setText(rev);
    }
}
