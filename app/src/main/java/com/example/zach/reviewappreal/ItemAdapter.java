package com.example.zach.reviewappreal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Zach on 9/29/2016.
 */

public class ItemAdapter extends ArrayAdapter<String> {

    public ItemAdapter(Context context, ArrayList<String> records){
        super(context,0,records);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        String s = getItem(position);

        if(convertView==null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_view,parent,false);
        }

        String[] record = s.split(",");
        TextView titleValue = (TextView) convertView.findViewById(R.id.titleValue);
        TextView ratingValue = (TextView) convertView.findViewById(R.id.ratingValue);

        titleValue.setText(record[0]);
        ratingValue.setText(record[1]);

        return convertView;
    }
}
