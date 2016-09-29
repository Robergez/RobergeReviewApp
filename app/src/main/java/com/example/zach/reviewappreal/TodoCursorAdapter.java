package com.example.zach.reviewappreal;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Zach on 9/29/2016.
 */

public class TodoCursorAdapter extends CursorAdapter {
    public TodoCursorAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }

    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
    }

    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find fields to populate in inflated template
        TextView titleValue = (TextView) view.findViewById(R.id.titleValue);
        TextView ratingValue = (TextView) view.findViewById(R.id.ratingValue);
        // Extract properties from cursor
        String rTitle = cursor.getString(cursor.getColumnIndexOrThrow(ReviewContract.Review.COLUMN_NAME_TITLE));
        String rRating = cursor.getString(cursor.getColumnIndexOrThrow(ReviewContract.Review.COLUMN_NAME_RATING));
        // Populate fields with extracted properties
        titleValue.setText(rTitle);
        ratingValue.setText(rRating);
    }
}
