package android.example.visualizer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import de.blox.treeview.BaseTreeAdapter;
import de.blox.treeview.TreeNode;
import de.blox.treeview.TreeView;

public class binaryTree extends AppCompatActivity {
    TreeView treeView;
    Button add;
    EditText tex;
    Set<String> set;
    TreeNode root;
    Queue<TreeNode> queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_search_tree);

        treeView = findViewById(R.id.tre);
        final BaseTreeAdapter<ViewHolder> adapter = new BaseTreeAdapter<ViewHolder>(getApplicationContext(), R.layout.node) {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(View view) {
                return new ViewHolder(view);
            }

            @Override
            public void onBindViewHolder(ViewHolder viewHolder, Object data, int position) {
                viewHolder.tv.setText(data.toString());
            }
        };
        treeView.setAdapter(adapter);
        set = new HashSet<>();
        add = findViewById(R.id.addBtn);
        tex = findViewById(R.id.editText);
        root = null;
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String val = tex.getText().toString();
                if (val.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter a value", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (set.contains(val)) {
                    Toast.makeText(getApplicationContext(), "Duplicate Values Not Allowed", Toast.LENGTH_SHORT).show();
                    return;
                }
                set.add(val);
                insert(val);
                adapter.setRootNode(root);

            }
        });

    }

    private void insert(String val) {
        queue = new LinkedList<>();
        if (root == null)
            root = new TreeNode(val);
        else {
            TreeNode temp = root;
            queue.add(temp);
            while(!queue.isEmpty())
            {
                TreeNode t = queue.peek();
                ArrayList<TreeNode> treeNodes = (ArrayList<TreeNode>) t.getChildren();
                if(treeNodes.size()==2) {
                    queue.poll();
                    queue.add(treeNodes.get(0));
                    queue.add(treeNodes.get(1));
                }
                else
                {
                    t.addChild(new TreeNode(val));
                    break;
                }

            }


        }

    }
}


