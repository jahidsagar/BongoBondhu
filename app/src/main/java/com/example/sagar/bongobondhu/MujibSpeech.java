package com.example.sagar.bongobondhu;

public class MujibSpeech {
    String[] mujib_speech , speech_description;

    MujibSpeech(String[] mujib_speech ,String[] speech_description){
        this.mujib_speech = mujib_speech;
        this.speech_description = speech_description;
    }

    public String[] getMujib_speech() {
        return mujib_speech;
    }

    public String[] getSpeech_description() {
        return speech_description;
    }
}
