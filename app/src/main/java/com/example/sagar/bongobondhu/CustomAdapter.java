package com.example.sagar.bongobondhu;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] mujib_speech , speech_description;
    private LayoutInflater inflater;

    CustomAdapter(Context context , String[] mujib_speech ,String[] speech_description){
        this.context = context;
        this.mujib_speech = mujib_speech;
        this.speech_description = speech_description;
    }


    @Override
    public int getCount() {
        return mujib_speech.length;
    }

    @Override
    public Object getItem(int position) {
        return mujib_speech[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_layout,parent,false);
        }

        //find the id of all views
        ImageView imageView = convertView.findViewById(R.id.image_left);
        TextView name = convertView.findViewById(R.id.sound_name);
        TextView description = convertView.findViewById(R.id.sound_description);
        ImageButton image_right = convertView.findViewById(R.id.image_right);

        //set the text and images to all views
        imageView.setImageResource(R.drawable.music_player);
        name.setText(mujib_speech[position]);
        description.setText(speech_description[position]);
        image_right.setImageResource(R.drawable.play);


        return  convertView;
    }
}
