//package android.example.visualizer;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class treeMap extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tree_map);
//    }
//}
package android.example.visualizer;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class treeMap extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    List<elemetsMap> list;
    Map<Integer,Integer> map;
    EditText key;
    EditText value;
    Button add;
    String k,val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree_map);

        key = findViewById(R.id.keyValue);
        value = findViewById(R.id.pairValue);
        add = findViewById(R.id.add);
        map = new TreeMap<>();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                k= key.getText().toString();
                val = value.getText().toString();
                if(k.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Null Key",Toast.LENGTH_SHORT).show();
                }
                else if(val.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Null Value",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    map.put(Integer.parseInt(k),Integer.parseInt(val));
                    list = new ArrayList<>();
                    for(Map.Entry<Integer,Integer> x : map.entrySet())
                        list.add(new elemetsMap(x.getKey(),x.getValue()));
                    recyclerView = (RecyclerView) findViewById(R.id.addElementsLayout);
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
                    adapter = new mapAdapter(list,getApplicationContext());
                    recyclerView.setAdapter(adapter);
                }
            }
        });

    }
}
