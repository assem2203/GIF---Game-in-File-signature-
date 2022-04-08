package com.example.gif_game_in_file_signature;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 화면의 가로, 세로 값을 다른 엑티비티에 넘겨주기 위해 선언
    public static Context context_main;

    // 바트 맵 및 아래 변수들은 초기 테스트를 위한 변수
    Bitmap testButtonChoice;
    int testButtonChoiceX, testButtonChoiceY;

    Bitmap testButtonBlank;
    int testButtonBlankX, testButtonBlankY;


    Bitmap testButtonDb;
    int testButtonDbX, testButtonDbY;

    int testButtonWidth, testButtonHeight;

    // screen size
    public int WIDTH, HEIGHT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));

        context_main = this;

    } // protected void onCreate(Bundle savedInstanceState) {


    // 화면은 구성하는 부분
    class MyView extends View {

        // 화면의 초기 설정 부분
        MyView(Context context) {
            super(context);
            setBackgroundColor(Color.WHITE);

            // 화면읜 가로, 세로를 크기 호출
            Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
            WIDTH = display.getWidth();
            HEIGHT = display.getHeight();

            testButtonWidth = WIDTH * 2 / 3;
            testButtonHeight = HEIGHT * 1 / 9;

            testButtonChoice = BitmapFactory.decodeResource(getResources(), R.drawable.choice);
            testButtonChoiceX = testButtonWidth / 4;
            testButtonChoiceY = HEIGHT / 9;
            testButtonChoice = Bitmap.createScaledBitmap(testButtonChoice, testButtonWidth, testButtonHeight, true);

            testButtonBlank = BitmapFactory.decodeResource(getResources(), R.drawable.blank);
            testButtonBlankX = testButtonWidth / 4;
            testButtonBlankY = HEIGHT * 4 / 9;
            testButtonBlank = Bitmap.createScaledBitmap(testButtonBlank, testButtonWidth, testButtonHeight, true);

            testButtonDb = BitmapFactory.decodeResource(getResources(), R.drawable.db);
            testButtonDbX = testButtonWidth / 4;
            testButtonDbY = HEIGHT * 7 / 9;
            testButtonDb = Bitmap.createScaledBitmap(testButtonDb, testButtonWidth, testButtonHeight, true);



        } // MyView(Context context) {

        // 실제 화면을 그리는 부분
        @Override
        protected void onDraw(Canvas canvas) {

            Paint paint = new Paint();

            canvas.drawBitmap(testButtonChoice, testButtonChoiceX, testButtonChoiceY, paint);
            canvas.drawBitmap(testButtonBlank, testButtonBlankX, testButtonBlankY, paint);
            canvas.drawBitmap(testButtonDb, testButtonDbX, testButtonDbY, paint);


        } // protected void onDraw(Canvas canvas) {

        // 화면의 터치 이벤트 부분
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

            if((x > testButtonChoiceX) && (x < testButtonChoiceX + testButtonWidth) && (y > testButtonChoiceY) && (y < testButtonChoiceY + testButtonHeight)) {

                Intent intentChoice = new Intent(MainActivity.this, Choice.class);
                startActivity(intentChoice);
                finish();

                //Toast.makeText(MainActivity.this, "Choice touch test", Toast.LENGTH_SHORT).show();
            }

            if((x > testButtonBlankX) && (x < testButtonBlankX + testButtonWidth) && (y > testButtonBlankY) && (y < testButtonBlankY + testButtonHeight)) {

                Intent intentBlank = new Intent(MainActivity.this, Blank.class);
                startActivity(intentBlank);
                finish();

                //Toast.makeText(MainActivity.this, "Blank touch test", Toast.LENGTH_SHORT).show();
            }

            if((x > testButtonDbX) && (x < testButtonDbX + testButtonWidth) && (y > testButtonDbY) && (y < testButtonDbY + testButtonHeight)) {

                Intent intentDb = new Intent(MainActivity.this, Db.class);
                startActivity(intentDb);
                finish();

                //Toast.makeText(MainActivity.this, "Db touch test", Toast.LENGTH_SHORT).show();
            }



            return true;

        } // public boolean onTouchEvent(MotionEvent event) {

    } // class MyView extends View {

} // public class MainActivity extends AppCompatActivity {