package com.example.zach.reviewappreal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

public class SummaryView extends AppCompatActivity {

    reviewDbHelper helper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_view);

        helper = new reviewDbHelper(this);
        db = helper.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + ReviewContract.Review.TABLE_NAME, null);
        TodoCursorAdapter adapter = new TodoCursorAdapter(this, c);
        /*
        ArrayList<String> records = new ArrayList<String>();
        for(int i = 0; i<Data.names.length; i++){
            records.add(Data.names[i] + "," + Data.ages[i] + "," + Data.secrets[i]);
        }

        ItemAdapter adapter = new ItemAdapter(this,records);
        */

        ListView listview = (ListView) findViewById(R.id.dataListView);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                //create intent
                Intent intent = new Intent(view.getContext(),DetailView.class);
                //pack in info
                intent.putExtra("position",position);
                //start activity
                startActivity(intent);
            }
        });
    }

    protected void filterList (View v){
        helper = new reviewDbHelper(this);
        db = helper.getReadableDatabase();

        String filterQuery = ((EditText) findViewById(R.id.filterText)).getText().toString();

        Cursor c = db.rawQuery("SELECT * FROM " + ReviewContract.Review.TABLE_NAME + " WHERE " + ReviewContract.Review.COLUMN_NAME_TITLE + " = '" + filterQuery + "'", null);
        TodoCursorAdapter adapter = new TodoCursorAdapter(this, c);
        /*
        ArrayList<String> records = new ArrayList<String>();
        for(int i = 0; i<Data.names.length; i++){
            records.add(Data.names[i] + "," + Data.ages[i] + "," + Data.secrets[i]);
        }

        ItemAdapter adapter = new ItemAdapter(this,records);
        */

        ListView listview = (ListView) findViewById(R.id.dataListView);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                //create intent
                Intent intent = new Intent(view.getContext(),DetailView.class);
                //pack in info
                intent.putExtra("position",position);
                //start activity
                startActivity(intent);
            }
        });
    }
}
