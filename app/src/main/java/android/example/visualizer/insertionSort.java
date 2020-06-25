package android.example.visualizer;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class insertionSort  extends AppCompatActivity {
    SeekBar seek;
    mycanvas canvas;
    CardView b1, b2;
    LinearLayout layout;
    int temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion_sort);
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
                for (int i = 1; i < n; ++i) {
                    int key = canvas.arr[i];
                    int j = i - 1;

                    draw(j,key);

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
    long mil = 100;
    private void draw(final  int j,final  int key) {
        mil = mil + 100 ;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int i = j;
                if(canvas.arr[i]<=key)
                    drawCan();
                else {
                    while (i >= 0 && canvas.arr[i] > key) {
                        layout.removeView(canvas);
                        canvas = new mycanvas(getApplicationContext(), seek.getProgress(), canvas.arr, i + 1, i);
                        layout.invalidate();
                        layout.addView(canvas);
                        canvas.arr[i + 1] = canvas.arr[i];
                        i = i - 1;
                    }
                    canvas.arr[i + 1] = key;
                    drawCan();
                }

            }

        };
        handler.postDelayed(runnable, mil);

    }


    Handler h = new Handler(Looper.getMainLooper());
    private void drawCan() {
        mil = mil + 10 ;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                layout.removeView(canvas);
                canvas = new mycanvas(getApplicationContext(), seek.getProgress(), canvas.arr);
                layout.invalidate();
                layout.addView(canvas);

            }

        };
        h.postDelayed(runnable, mil);

    }


}


