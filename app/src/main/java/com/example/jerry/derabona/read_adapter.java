package com.example.jerry.derabona;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jerry on 7/15/17.
 */

public class read_adapter extends ArrayAdapter<match>{

    private ArrayList<match> matches;
    Context context;


    public read_adapter(Context context, ArrayList<match> matches) {
        super(context, R.layout.activity_read_row, matches);
        this.matches = matches;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.activity_read_row, parent, false);

        match match  = getItem(position);
        String description = match.getMatch();
        String date = match.getDate();

        TextView txt_date = (TextView) view.findViewById(R.id.ab_txt_data);
        TextView txt_description = (TextView) view.findViewById(R.id.ab_txt_match);

        txt_date.setText(date);
        txt_description.setText(description);
        return view;
    }
}
