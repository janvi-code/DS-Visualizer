package android.example.visualizer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView sort;
    CardView set;
    CardView map;
    CardView tree;
    CardView graph;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sort = findViewById(R.id.card1);
        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),sortingFace.class);
                startActivity(i);
            }
        });

        set = findViewById(R.id.card2);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),setFace.class);
                startActivity(i);
            }
        });

        map = findViewById(R.id.card3);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),mapStart.class);
                startActivity(i);
            }
        });
        tree = findViewById(R.id.card4);
        tree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),treeFace.class);
                startActivity(i);
            }
        });


    }
}
