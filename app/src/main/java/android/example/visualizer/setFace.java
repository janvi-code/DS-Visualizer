package android.example.visualizer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class setFace extends AppCompatActivity
{
    Set<Integer> hash = new HashSet<>();
    Set<Integer> tree = new TreeSet<>();
    String h = "";
    String t = "";
     List<Integer> list;
    Button input;
    EditText val;
    TextView has;
    TextView tre;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_face);

        input = findViewById(R.id.instructionAdd);
        val   = findViewById(R.id.addValue);
        has = findViewById(R.id.hashset);
        tre = findViewById(R.id.treeset);
        hash = new HashSet<>();
        tree = new TreeSet<>();
        list = new ArrayList();
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = val.getText().toString();
                if(n.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Please enter the value",Toast.LENGTH_SHORT).show();
                }

                else {
                         val.setText("");
                    if (hash.contains(Integer.parseInt(n))) {
                        Toast.makeText(getApplicationContext(), "Duplicate Values Are Not Allowed", Toast.LENGTH_SHORT).show();
                    } else {
                        if(h.length()!=0 && h.length()%7==0)
                            h = h + "\n";
                        hash.add(Integer.parseInt(n));
                        h = h + n + ",";
                        has.setText(h);
                        t = "";
                        tree.add(Integer.parseInt(n));
                        list.add(Integer.parseInt(n));
                        Collections.sort(list);
                        for (Integer x : list) {
                            if(t.length()!=0 && t.length()%7==0) {
                                t = t + '\n';
                            }
                            t = t + x + ",";
                        }
                        tre.setText(t);
                    }

                }
            }
        });
    }
}
