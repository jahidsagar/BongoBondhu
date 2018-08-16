package com.example.sagar.bongobondhu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] mujib_speech , speech_description;
//    ArrayList<MujibSpeech> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mujib_speech = getResources().getStringArray(R.array.speech_name);
        speech_description = getResources().getStringArray(R.array.speech_description);

        listView = findViewById(R.id.list_main);
        CustomAdapter customAdapter = new CustomAdapter(this ,mujib_speech , speech_description);
        listView.setAdapter(customAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if (item.getItemId() == R.id.something){
//            dosomething;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
