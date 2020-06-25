package android.example.visualizer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mapStart extends AppCompatActivity {
    CardView c1;
    CardView c2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_start);

        c1 = findViewById(R.id.dash1);
        c2 = findViewById(R.id.dash3);

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),mapFace.class);
                startActivity(i);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),treeMap.class);
                startActivity(i);
            }
        });

    }
}
