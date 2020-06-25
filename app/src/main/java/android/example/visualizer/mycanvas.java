package android.example.visualizer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import java.util.Random;

import static android.os.SystemClock.sleep;

public class mycanvas extends View {
    Paint paint = new Paint();
    Rect our_rect = new Rect();
    Canvas canvas;
    int pro;
    public static int arr[] ;
    public  int a[] = new int[1];
    static int k =-1,l=-1;

    public mycanvas(Context context, int progress) {
        super(context);
        pro = progress;
    }

    public mycanvas(Context context ,int progress,int bb_ar[])
    {
        super(context);
        pro = progress;
        a = new int[bb_ar.length];
        for(int i=0;i<bb_ar.length;i++)
            a[i] = bb_ar[i];

    }
    public mycanvas(Context context ,int progress,int bb_ar[],int f,int s)
    {
        super(context);
        pro = progress;
        a = new int[bb_ar.length];
        for(int i=0;i<bb_ar.length;i++)
            a[i] = bb_ar[i];
        k=f;
        l=s;

    }


    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        if(a.length==1 && k==-1 && l==-1){
            randomnize();
            draw();
        }
        else if(a.length!=1 && k==-1 && l==-1)
            b_draw(a);
        else
        {
            change_draw(a,k,l);
            k=-1;
            l=-1;
        }


    }


    public void change_draw(int a[],int f,int l)
    {
        int width = canvas.getWidth() / a.length;
        int w = 0;
        for (int i = 0; i < a.length; i++) {
            if(i==f || i==l)
                paint.setColor(Color.BLACK);
            else
                paint.setColor(Color.RED);
            our_rect.set(w, 10, w + width, a[i] * 10);
            canvas.drawRect(our_rect, paint);
            w = w + width + 1;
        }
    }

    public void randomnize() {
        arr = new int[canvas.getWidth() / pro];
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            int num = rand.nextInt(canvas.getHeight() / 15) + 1;
            arr[i] = num;
        }

    }

    public  void b_draw(int bb_a[])
    {
        int width = canvas.getWidth() / bb_a.length;
        paint.setColor(Color.RED);
        int w = 0;
        for (int i = 0; i < bb_a.length; i++) {
            our_rect.set(w, 10, w + width, bb_a[i] * 10);
            canvas.drawRect(our_rect, paint);
            w = w + width + 1;
        }
    }


    public void draw() {
        int width = canvas.getWidth() / arr.length;
        int w = 0;
        for (int i = 0; i < arr.length; i++) {
            our_rect.set(w, 10, w + width, arr[i] * 10);
            canvas.drawRect(our_rect, paint);
            w = w + width + 1;
        }
    }

}
