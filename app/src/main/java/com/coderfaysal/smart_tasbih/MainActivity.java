package com.coderfaysal.smart_tasbih;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView tasbihDisplay;
    ImageView nagetiveBtn, pludBtn, reloadBtn;

    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tasbihDisplay = findViewById(R.id.tasbihDisplay);

        nagetiveBtn = findViewById(R.id.nagetiveBtn);
        pludBtn = findViewById(R.id.pludBtn);
        reloadBtn = findViewById(R.id.reloadBtn);


        pludBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                tasbihDisplay.setText(""+count);

                if(count == 33 || count == 100 || count == 200 || count == 300 || count == 400 || count == 500 ){


                    Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    if (vibrator != null) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            vibrator.vibrate(VibrationEffect.createOneShot(700, VibrationEffect.DEFAULT_AMPLITUDE));
                        } else {
                            vibrator.vibrate(700);
                        }
                    }}



            }
        });

        nagetiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count > 0 ){
                    count --;
                    tasbihDisplay.setText(" "+count);
                }
            }
        });

        reloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                tasbihDisplay.setText(""+count);
            }
        });




    }
}