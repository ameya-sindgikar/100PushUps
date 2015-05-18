package com.example.ameya.sevenweekshundredpushupschallenge;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;


public class FinalTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_test);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setAlpha(0.5f);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("Final Test");
    }

}
