package com.example.sagar.bongobondhu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = mujib_speech[position];
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
            }
        });

    }

}
