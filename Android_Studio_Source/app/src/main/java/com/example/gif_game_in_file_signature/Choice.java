package com.example.gif_game_in_file_signature;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class Choice extends AppCompatActivity {

    int WIDTH = ((MainActivity)MainActivity.context_main).WIDTH;
    int HEIGHT = ((MainActivity)MainActivity.context_main).HEIGHT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));



    } // protected void onCreate(Bundle savedInstanceState) {


    class MyView extends View {

        MyView(Context context) {
            super(context);
            setBackgroundColor(Color.BLACK);





        } // MyView(Context context) {

        @Override
        protected void onDraw(Canvas canvas) {

            Paint paint = new Paint();


        } // protected void onDraw(Canvas canvas) {

        @Override
        public boolean onTouchEvent(MotionEvent event) {

            int x = 0;
            int y = 0;

            /*
            if(event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE){
                x = (int) event.getX();
                y = (int) event.getY();
            }
            */

            if(event.getAction() == MotionEvent.ACTION_DOWN){
                x = (int) event.getX();
                y = (int) event.getY();
            }





            return true;

        } // public boolean onTouchEvent(MotionEvent event) {

    } // class MyView extends View {

} // public class Choice extends AppCompatActivity {
