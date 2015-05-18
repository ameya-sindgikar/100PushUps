package com.example.ameya.sevenweekshundredpushupschallenge;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Day extends Activity {
    JSONObject jsonObject;
    ArrayList <SetPushUps>setList;
    CustomAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        ListView lv = (ListView) findViewById(R.id.listView);

        Intent intent = getIntent();
        String weekNum = intent.getStringExtra("weekNum");
        String dayNum = intent.getStringExtra("dayNum");
        int day = Integer.parseInt(dayNum);
        Log.e("week and day", "week " + weekNum + " day "+day);

        ActionBar actionBar = getActionBar();
        actionBar.setTitle("Week " + weekNum+", Day " + dayNum);

        //Toast.makeText(getApplicationContext(), week, Toast.LENGTH_SHORT).show();

        TextView restText = (TextView) findViewById(R.id.rest_text);

        Bitmap icon = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.pu_icon);

        try {
            jsonObject = new JSONObject(loadFromJSON());
            JSONArray weekArray = jsonObject.getJSONArray("week"+weekNum);
            //Log.e("weekArray", weekArray.toString());
            JSONObject dayObject = weekArray.getJSONObject(day - 1); //Day 1 is index 0, day 2 is index 1, etc.
            //Log.e("dayObject", dayObject.toString());
            int numSetPushUps = dayObject.getInt("numSets");
            String rest = dayObject.getString("rest");
            restText.setText(rest);
            //Log.e("numSetPushUps", ""+numSetPushUps);
            setList = new ArrayList<SetPushUps>();
            for (int i=1; i<=numSetPushUps; i++) {
                String numPU = dayObject.getString("set"+i)+" push ups";
                SetPushUps setPushUps = new SetPushUps("Set "+i, numPU, icon);
                //Log.e("set", set);
                setList.add(setPushUps);
            }
        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        listAdapter = new CustomAdapter(this, setList);
        lv.setAdapter(listAdapter);

    }

    @Override
    public void onResume() {
        listAdapter.notifyDataSetChanged(); //tbh there is nothing being changed, just for good practice
        super.onResume();
    }

    public String loadFromJSON(){
        String json;
        try {
            InputStream is = getAssets().open("schedule.json");

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        }
        catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
        return  json;
    }

    public class CustomAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        private List<SetPushUps> mSetPushUps;

        public CustomAdapter(Context context, List<SetPushUps> set) {
            mInflater = LayoutInflater.from(context);
            mSetPushUps = set;
        }

        @Override
        public int getCount() {
            return mSetPushUps.size();
        }

        @Override
        public Object getItem(int position) {
            return mSetPushUps.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            ViewHolder holder;
            if(convertView == null) {
                view = mInflater.inflate(R.layout.row_layout, parent, false);
                holder = new ViewHolder();
                holder.image = (ImageView)view.findViewById(R.id.image);
                holder.setNumber = (TextView)view.findViewById(R.id.set_number);
                holder.numberPushups = (TextView)view.findViewById(R.id.number_pushups);
                view.setTag(holder);
            } else {
                view = convertView;
                holder = (ViewHolder)view.getTag();
            }

            SetPushUps set = mSetPushUps.get(position);
            holder.image.setImageBitmap(set.getImage());
            holder.setNumber.setText(set.getSetNumber());
            holder.numberPushups.setText(set.getNumberPushUps());

            return view;
        }

        private class ViewHolder {
            public ImageView image;
            public TextView setNumber, numberPushups;
        }
    }
}
