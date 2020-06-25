package android.example.visualizer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class treeFace extends AppCompatActivity {
  CardView c1;
  CardView c2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_face);

        c1 = findViewById(R.id.dash1);
        c2 = findViewById(R.id.dash3);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),binaryTree.class);
                startActivity(i);
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),binarySearchTree.class);
                startActivity(i);
            }
        });
    }
}
