package android.example.visualizer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class sortingFace extends AppCompatActivity {

    CardView buble;
    CardView insert;
    CardView select;
    CardView quickSort;
    CardView mergeSort;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorting_face);
        buble = findViewById(R.id.dash1);
        buble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),bubbleSort.class);
                startActivity(i);
            }
        });

        insert = findViewById(R.id.dash2);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),insertionSort.class);
                startActivity(i);
            }
        });

       select = findViewById(R.id.dash3);
       select.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(getApplicationContext(),selectionSort.class);
               startActivity(i);
           }
       });
       quickSort = findViewById(R.id.dash4);
       quickSort.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(getApplicationContext(),quickSort.class);
               startActivity(i);
           }
       });
       mergeSort = findViewById(R.id.dash5);
       mergeSort.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(getApplicationContext(),mergeSort.class);
               startActivity(i);
           }
       });
    }
}
