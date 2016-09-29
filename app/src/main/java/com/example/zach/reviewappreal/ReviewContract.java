package com.example.zach.reviewappreal;

import android.provider.BaseColumns;

/**
 * Created by Zach on 9/29/2016.
 */

public class ReviewContract {

    public static final String TEXT_TYPE = " TEXT";
    public static final String COMMA_SEP = ",";
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Review.TABLE_NAME + " (" +
                    Review._ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                    Review.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    Review.COLUMN_NAME_DATE + TEXT_TYPE + COMMA_SEP +
                    Review.COLUMN_NAME_RATING + TEXT_TYPE + COMMA_SEP +
                    Review.COLUMN_NAME_REVIEW + " )";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Review.TABLE_NAME;


    //private ReviewContract() {}

    /* Inner class that defines the table contents */
    public static class Review implements BaseColumns {
        public static final String TABLE_NAME = "reviews";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_RATING = "rating";
        public static final String COLUMN_NAME_REVIEW = "review";
    }
}
