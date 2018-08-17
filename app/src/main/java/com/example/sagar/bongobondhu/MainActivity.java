package com.example.sagar.bongobondhu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ShareActionProvider;
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
//        listView.setTextFilterEnabled(true);



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //until throw the activity this music player runs
        //we have to fix this issue
        //not working this method
        MujibSpeech.Stop();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        /*
        * set the options menu
        * */
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);

        /*
         * find and set the SearchView in options menu
         * */
        MenuItem menuItem = menu.findItem(R.id.search_op);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            /*
             * not working this , we have to fixed it
             * */
            @Override
            public boolean onQueryTextChange(String newText) {
//                listView.setFilterText(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about_op){
            Toast.makeText(this,"about us",Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.feedback_op){
            Toast.makeText(this,"feed back",Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.share_op){
            Toast.makeText(this,"share this",Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
