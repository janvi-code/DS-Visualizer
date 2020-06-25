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

public class bubbleSort extends AppCompatActivity {
    SeekBar seek;
    mycanvas canvas;
    CardView b1, b2;
    LinearLayout layout;
    int temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_bubble_sort);
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
                for (int i = 0; i < canvas.arr.length; i++) {
                    for (int j = 0; j < canvas.arr.length - i - 1; j++) {
                        draw(i, j);
                    }
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

    private void draw(final int i, final int j) {
        mil = mil + 10;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (canvas.arr[j] > canvas.arr[j + 1]) {
                    layout.removeView(canvas);
                    canvas = new mycanvas(getApplicationContext(), seek.getProgress(), canvas.arr, j, j+1);
                    layout.invalidate();
                    layout.addView(canvas);

                    temp = canvas.arr[j];
                    canvas.arr[j] = canvas.arr[j + 1];
                    canvas.arr[j + 1] = temp;

                    layout.removeView(canvas);
                    canvas = new mycanvas(getApplicationContext(), seek.getProgress(), canvas.arr);
                    layout.invalidate();
                    layout.addView(canvas);
                } else {
                    layout.removeView(canvas);
                    canvas = new mycanvas(getApplicationContext(), seek.getProgress(), canvas.arr);
                    layout.invalidate();
                    layout.addView(canvas);
                }
            }

    };
        handler.postDelayed(runnable, mil);

    }


}
