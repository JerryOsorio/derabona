package com.example.jerry.derabona;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jerry on 7/15/17.
 */

public class read_adapter extends ArrayAdapter<match>{

    RadioGroup radioGroup;
    private ArrayList<match> matches;
    private Map<String,String> wagers;
    Context context;


    public read_adapter(Context context, ArrayList<match> matches) {
        super(context, R.layout.activity_read_row, matches);
        this.matches = matches;
        this.context = context;
        //this.wagers = wagers;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String pick = position + "a";

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.activity_read_row, parent, false);


        if(!getItem(position).getStatus().equals("open")){

            LinearLayout ll_bottom = view.findViewById(R.id.ar_ll_bottom);
            ll_bottom.setVisibility(View.GONE);

            TextView txt_progress = view.findViewById(R.id.ar_txt_progress);
            txt_progress.setVisibility(View.VISIBLE);
            txt_progress.setText(getItem(position).getStatus());

        }

        final match match  = getItem(position);
        String description = match.getMatch();
        String date = match.getDate();
        String team1 = match.getTeam1();
        String team2 = match.getTeam2();


        radioGroup = view.findViewById(R.id.ar_rg_pick);




        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                RadioButton checkedRadioButton = radioGroup.findViewById(i);
                boolean isChecked = checkedRadioButton.isChecked();
                if(isChecked){
                    String pick = checkedRadioButton.getText().toString();
                    Log.i("test", "a team was chosen, team "+ pick);
                    match.setPick(pick);
                    Log.i("test", match.getPick());
                }

            }
        });

        RadioButton rb_team1 = view.findViewById(R.id.ar_rb_team1);
        RadioButton rb_draw = view.findViewById(R.id.ar_rb_draw);
        RadioButton rb_team2 = view.findViewById(R.id.ar_rb_team2);


        rb_team1.setText(team1);
        rb_team2.setText(team2);
        rb_draw.setText("Draw");

        TextView txt_date = view.findViewById(R.id.ab_txt_date);
        TextView txt_description = view.findViewById(R.id.ab_txt_match);

        Log.i("test", date +"   found");
        Log.i("test", description +"   found");

        txt_date.setText(date);
        txt_description.setText(description);

        return view;
    }

}
