package com.example.sagar.bongobondhu;

/*
 * use for play the speech / song using the index value
 */

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.Button;

import java.util.ConcurrentModificationException;

public class MujibSpeech {
    static private int[] song = {
            R.raw.bakshal_noy,
            R.raw.march_7 ,
            R.raw.scout_vaider_uddeshhe ,
            R.raw.shason_kora_tari_saje ,
            R.raw.shromik_somporkito ,
            R.raw.jodi_raat_pohale_suna_jeto
    };

//    private Button pause_play;
    static private int Store_index;
    static private boolean bool_play , bool_stop;
    static MediaPlayer mediaPlayer;
    static Context context;

    public MujibSpeech(int Store_index , Context context){
        this.Store_index = Store_index;
        this.context = context;
    }

    public static boolean Play(){
//        boolean stop = this.Stop();

        int id = song[Store_index];
        mediaPlayer = MediaPlayer.create(context,id);
        mediaPlayer.start();
        bool_play = true;
        return bool_play;
    }

    public static boolean Stop(){
        if (mediaPlayer.isPlaying() && mediaPlayer != null){
            mediaPlayer.stop();
        }
        return (bool_stop = true);
    }
}
