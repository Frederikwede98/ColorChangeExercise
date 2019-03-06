package com.example.colorchangeexercise;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    private android.support.constraint.ConstraintLayout myLayout = null;
    private GestureDetectorCompat gestureDetector;
    private static final int SWIPE_THRESHOLD = 100;
    private static final int SWIPE_VELOCITY_THRESHOLD = 100;
    private Button red, blue, green, orange, colorChangebtn;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = findViewById(R.id.myLayout);
        this.gestureDetector = new GestureDetectorCompat(this, this);
        view = this.getWindow().getDecorView();
        red = findViewById(R.id.button_red);
        blue = findViewById(R.id.button2_blue);
        green = findViewById(R.id.button3_green);
        orange = findViewById(R.id.button4_orange);
        colorChangebtn = findViewById(R.id.button5_changeColor);

        (findViewById(R.id.button_red)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redColor();
            }
        });
        (findViewById(R.id.button2_blue)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blueColor();
            }
        });
        (findViewById(R.id.button3_green)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                greenColor();
            }
        });
        (findViewById(R.id.button4_orange)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orangeColor();
            }
        });

    }

    public void redColor(){
        colorChangebtn.setBackgroundResource(R.color.red);
        colorChangebtn.setText("Red");
    }

    public void blueColor(){
        colorChangebtn.setBackgroundResource(R.color.blue);
        colorChangebtn.setText("Blue");
    }

    public void greenColor(){
        colorChangebtn.setBackgroundResource(R.color.green);
        colorChangebtn.setText("Green");
    }

    public void orangeColor(){
        colorChangebtn.setBackgroundResource(R.color.orange);
        colorChangebtn.setText("Orange");
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Toast.makeText(getApplicationContext(), "onDown", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Toast.makeText(getApplicationContext(), "onShowPress", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Toast.makeText(getApplicationContext(), "onSingleTapUp", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Toast.makeText(getApplicationContext(), "onScroll", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Toast.makeText(getApplicationContext(), "onLongPress", Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        boolean result = false;
        /*try {
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        //Swipe right
                        view.setBackgroundResource(R.color.blue);
                    } else {
                        //Swipe left
                        view.setBackgroundResource(R.color.green);
                    }
                    result = true;
                }
            }
            else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffY > 0) {
                    //Swipe down
                    view.setBackgroundResource(R.color.orange);
                } else {
                    //Swipe Up
                    view.setBackgroundResource(R.color.red);
                }
                result = true;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }*/
        return result;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
