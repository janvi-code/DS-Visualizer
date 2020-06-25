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

public class mergeSort  extends AppCompatActivity {
    SeekBar seek;
    mycanvas canvas;
    CardView b1, b2;
    LinearLayout layout;
    int a[];
    int al[];
    int ar[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merge_sort);
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
    long mil = 100;
    private void drawL(final int i,final int j) {
        mil = mil + 100 ;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                drawF(i,j);
                canvas.arr[i] = al[j];

            }
        };
        handler.postDelayed(runnable, mil);
    }
    Handler h = new Handler(Looper.getMainLooper());
    private void drawR(final int i,final int j) {
        mil = mil + 300 ;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                drawF(i,j);
                canvas.arr[i] = ar[j];

            }
        };
        h.postDelayed(runnable, mil);
    }
    void merge(int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        al = new int[n1];
        ar = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            al[i] = a[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            ar[j] = a[m + 1 + j];
        }

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (al[i] <= ar[j]) {
                drawL(k,i);
                a[k] = al[i];
                i++;
            }
            else {
                drawR(k,j);
                a[k] = ar[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            drawL(k,i);
            a[k] = al[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            drawR(k,j);
            a[k] = ar[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            sort(l, m);
            sort(m + 1, r);

            // Merge the sorted halves
            merge(l, m, r);
        }
    }

    void drawF(int i,int j)
    {
        layout.removeView(canvas);
        canvas = new mycanvas(getApplicationContext(), seek.getProgress(), canvas.arr,i,j);
        layout.invalidate();
        layout.addView(canvas);
    }
    void draw()
    {
        layout.removeView(canvas);
        canvas = new mycanvas(getApplicationContext(), seek.getProgress(), canvas.arr);
        layout.invalidate();
        layout.addView(canvas);
    }

}

