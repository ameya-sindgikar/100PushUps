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


public class DaysList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_list);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setAlpha(0.5f);

        Intent intent = getIntent();
        final String weekNumber = intent.getStringExtra("weekNumber");

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("Week " + weekNumber);

        TextView day1 = (TextView) findViewById(R.id.day1);
        day1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDayView(weekNumber, "1");
            }
        });

        TextView day2 = (TextView) findViewById(R.id.day2);
        day2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDayView(weekNumber, "2");
            }
        });

        TextView day3 = (TextView) findViewById(R.id.day3);
        day3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDayView(weekNumber, "3");
            }
        });
    }

    public void startDayView(String weekNum, String dayNum) {
        Intent dayActivity = new Intent(getApplicationContext(), Day.class);
        dayActivity.putExtra("weekNum", weekNum);
        dayActivity.putExtra("dayNum", dayNum);
        startActivity(dayActivity);
    }

}
