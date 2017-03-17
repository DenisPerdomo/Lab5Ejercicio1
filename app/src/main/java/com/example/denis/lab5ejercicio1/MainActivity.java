package com.example.denis.lab5ejercicio1;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickImage (View v){
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.girar);
        v.startAnimation(anim);
        MediaPlayer sound = null;

        switch (v.getId()){
            case R.id.imgGuitarra:
                sound = MediaPlayer.create(this,R.raw.guitarra);
                break;
            case R.id.imgGaita:
                sound = MediaPlayer.create(this,R.raw.gaita);
                break;
            case R.id.imgPiano:
                sound = MediaPlayer.create(this,R.raw.piano);
                break;
            case R.id.imgTrompeta:
                sound = MediaPlayer.create(this,R.raw.trompeta);
                break;
            case R.id.imgViolin:
                sound = MediaPlayer.create(this,R.raw.violin);
                break;
            case R.id.imgBateria:
                sound = MediaPlayer.create(this,R.raw.bateria);
                break;
        }

        //Se inicia el sonido.
        sound.start();
        //Liberar audio cuando termine de reproducir.
        sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }
}
