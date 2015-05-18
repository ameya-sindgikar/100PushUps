package com.example.ameya.sevenweekshundredpushupschallenge;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.Inet4Address;


public class Week extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("Weeks");

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setAlpha(0.5f);

        TextView week1 = (TextView) findViewById(R.id.week1);
        week1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDayListView("1");
            }
        });

        TextView week2 = (TextView) findViewById(R.id.week2);
        week2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDayListView("2");
            }
        });

        TextView week3 = (TextView) findViewById(R.id.week3);
        week3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDayListView("3");
            }
        });

        TextView week4 = (TextView) findViewById(R.id.week4);
        week4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDayListView("4");
            }
        });

        TextView week5 = (TextView) findViewById(R.id.week5);
        week5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDayListView("5");
            }
        });

        TextView week6 = (TextView) findViewById(R.id.week6);
        week6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDayListView("6");
            }
        });

        TextView week7 = (TextView) findViewById(R.id.week7);
        week7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent finalTestActivity = new Intent(getApplicationContext(), FinalTest.class);
                startActivity(finalTestActivity);
            }
        });
    }

    public void startDayListView (String weekNum) {
        Intent dayListActivity = new Intent(getApplicationContext(), DaysList.class);
        dayListActivity.putExtra("weekNumber", weekNum);
        startActivity(dayListActivity);
    }
}
