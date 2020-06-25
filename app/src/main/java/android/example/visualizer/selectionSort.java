package android.example.visualizer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class selectionSort  extends AppCompatActivity {
    SeekBar seek;
    mycanvas canvas;
    CardView b1, b2;
    LinearLayout layout;
    int temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_sort);
        layout = findViewById(R.id.linear);
        seek = findViewById(R.id.seek_bar);

        canvas = new mycanvas(getApplicationContext(), seek.getProgress());
        layout.addView(canvas);



        b2 = findViewById(R.id.btn2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.removeView(canvas);
                canvas = new mycanvas(getApplicationContext(), seek.getProgress());
                layout.addView(canvas);
            }
        });

        b1 = findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int n = canvas.arr.length;
                for(int i=0;i<n-1;i++)
                {
                    draw(i);
                }


            }

        });


        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                layout.removeView(canvas);
                canvas = new mycanvas(getApplicationContext(), progress);
                layout.addView(canvas);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    Handler handler = new Handler(Looper.getMainLooper());
    long mil = 500;
    private void draw(final  int  i) {
        mil = mil + 300 ;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int index = 0;
                int min = Integer.MAX_VALUE;
                int j;
                for(j = i+1 ; j<canvas.arr.length ;j++)
                {
                    if(canvas.arr[j]<min)
                    {
                        min = canvas.arr[j];
                        index = j;
                    }
                }
                layout.removeView(canvas);
                canvas = new mycanvas(getApplicationContext(), seek.getProgress(), canvas.arr, i ,index);
                layout.invalidate();
                layout.addView(canvas);

                int temp = canvas.arr[index];
                canvas.arr[index] = canvas.arr[i];
                canvas.arr[i] = temp;


            }

        };
        handler.postDelayed(runnable, mil);

    }

}

