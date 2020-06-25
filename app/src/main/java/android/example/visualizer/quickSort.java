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

public class quickSort  extends AppCompatActivity {
    SeekBar seek;
    mycanvas canvas;
    CardView b1, b2;
    LinearLayout layout;
    int a[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_sort);
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

                a = new int[canvas.arr.length];
                for(int k=0;k<canvas.arr.length;k++)
                    a[k] = canvas.arr[k];

                sort(0,canvas.arr.length-1);

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
    long mil = 400;
    private void draw(final int i,final int j) {
        mil = mil + 200 ;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                drawF(i,j);
                int temp = canvas.arr[i];
                canvas.arr[i] = canvas.arr[j];
                canvas.arr[j] = temp;
            }
        };
        handler.postDelayed(runnable, mil);

    }

    int partition(int low, int high)
    {
        int pivot = a[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            if (a[j] <= pivot) {
                i++;
                draw(i,j);
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        draw(i+1,high);
        int temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;
        return i + 1;
    }
    void sort(int low, int high)
    {
        if (low < high) {
            int pi = partition(low, high);
            sort(low, pi - 1);
            sort(pi + 1, high);

        }
    }

    void drawF(int i,int j)
    {
        layout.removeView(canvas);
        canvas = new mycanvas(getApplicationContext(), seek.getProgress(), canvas.arr,i,j);
        layout.invalidate();
        layout.addView(canvas);
    }

}

