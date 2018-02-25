package com.example.matt.customjoystick_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private JoystickView myJoystick;
    private TextView percentageX, percentageY;
    private TextView rawX, rawY, relX, relY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myJoystick = (JoystickView) findViewById(R.id.joystick);
        percentageX = (TextView) findViewById(R.id.percentage_x);
        percentageY = (TextView) findViewById(R.id.percentage_y);

        rawX = findViewById(R.id.raw_x);
        rawY = findViewById(R.id.raw_y);
        relX = findViewById(R.id.rel_x);
        relY = findViewById(R.id.rel_y);

        setUpListeners();
    }

    private void setUpListeners(){
        myJoystick.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                percentageX.setText(String.valueOf(myJoystick.getPercentageX()));
                percentageY.setText(String.valueOf(myJoystick.getPercentageY()));
                rawX.setText(String.valueOf(myJoystick.getXPos()));
                rawY.setText(String.valueOf(myJoystick.getYPos()));
                relX.setText(String.valueOf(myJoystick.getRelativePosX()));
                relY.setText(String.valueOf(myJoystick.getRelativePosY()));
                return false;
            }
        });
    }
}