package com.example.sagar.bongobondhu;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.System.exit;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] mujib_speech , speech_description;
    private LayoutInflater inflater;

    static boolean play_state = false;
    static ImageButton for_pause;
    static int id = -1;

    MediaPlayer mediaPlayer;
    private int[] song = {
            R.raw.bakshal_noy,
            R.raw.march_7 ,
            R.raw.scout_vaider_uddeshhe ,
            R.raw.shason_kora_tari_saje ,
            R.raw.shromik_somporkito ,
            R.raw.jodi_raat_pohale_suna_jeto
    };

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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_layout,parent,false);
        }

        //find the id of all views
        ImageView imageView = convertView.findViewById(R.id.image_left);
        TextView name = convertView.findViewById(R.id.sound_name);
        TextView description = convertView.findViewById(R.id.sound_description);
        final ImageButton button_right = convertView.findViewById(R.id.image_right);

        //set the text and images to all views
        imageView.setImageResource(R.drawable.music_player);
        name.setText(mujib_speech[position]);
        description.setText(speech_description[position]);
        button_right.setImageResource(R.drawable.play);

        /*
        * set the play button listener
        */
        button_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context,"hello",Toast.LENGTH_SHORT).show();
                MujibSpeech mujibSpeech = new MujibSpeech(position , context);

                if (play_state == true && id == position){
                    mujibSpeech.Stop();
                    for_pause.setImageResource(R.drawable.play);
                    play_state = false;
                    id = -1;
                }else {
//                    Log.d("prev", "onClick: "+id);
                    id = position;
//                    Log.d("next", "onClick: "+id);
                }

                if (play_state == true && id != -1){
                    mujibSpeech.Stop();
                    for_pause.setImageResource(R.drawable.play);
                    play_state = false;

                }


                if (id == position){
                    play_state = mujibSpeech.Play();
                }

                if (play_state == true && id != -1){
                    button_right.setImageResource(R.drawable.pause);
                    for_pause = button_right;
                }
            }
        });

        /*
         * set the item click listener
         */
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"hello hi",Toast.LENGTH_SHORT).show();
            }
        });


        return  convertView;
    }
}
