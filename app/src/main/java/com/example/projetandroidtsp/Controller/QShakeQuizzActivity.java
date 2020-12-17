package com.example.projetandroidtsp.Controller;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetandroidtsp.R;
import com.example.projetandroidtsp.View.BoussoleView;

import java.util.List;
import java.util.Objects;

public class QShakeQuizzActivity extends AppCompatActivity {

        private SensorManager mSensorManager;
        private float mAccel;
        private float mAccelCurrent;
        private float mAccelLast;
        Integer incr;
        Integer incrq;
        String[] questions;
        String[] reponses;
        Integer reussi;
        int categorie;

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_q_shake_quizz);
            mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
            Objects.requireNonNull(mSensorManager).registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                    SensorManager.SENSOR_DELAY_NORMAL);
            mAccel = 10f;
            mAccelCurrent = SensorManager.GRAVITY_EARTH;
            mAccelLast = SensorManager.GRAVITY_EARTH;

            Intent i = getIntent();
            incr = i.getIntExtra("incr", 0);
            incrq = i.getIntExtra("incrq", 0);
            questions = i.getStringArrayExtra("questions");
            reponses = i.getStringArrayExtra("reponses");
            reussi=i.getIntExtra("reussi", -1);
            categorie=i.getIntExtra("categorie",0);
        }
        private final SensorEventListener mSensorListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];
                mAccelLast = mAccelCurrent;
                mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
                float delta = mAccelCurrent - mAccelLast;
                mAccel = mAccel * 0.9f + delta;
                if (mAccel > 12) {
                    Toast.makeText(getApplicationContext(), "Bien secoué!", Toast.LENGTH_SHORT).show();
                    incrq++;
                    incr=incr+4;
                    if (incrq>9){
                        Intent i = new Intent(getApplicationContext(),VictoireActivity.class);
                        i.putExtra("reussi",reussi);
                        i.putExtra("categorie",categorie);
                        startActivity(i);
                        return;
                    }
                    else{
                        Intent i = new Intent(getApplicationContext(),QSimpleQuizzActivity.class);
                        i.putExtra("incr",incr);
                        i.putExtra("incrq",incrq);
                        i.putExtra("questions",questions);
                        i.putExtra("reponses",reponses);
                        i.putExtra("categorie",categorie);
                        i.putExtra("reussi",reussi);
                        startActivity(i);
                    }
                    finish();
                }
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
            }
        };
        @Override
        protected void onResume() {
            mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                    SensorManager.SENSOR_DELAY_NORMAL);
            super.onResume();
        }
        @Override
        protected void onPause() {
            mSensorManager.unregisterListener(mSensorListener);
            super.onPause();
        }
    }