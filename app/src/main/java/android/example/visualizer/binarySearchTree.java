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

public class binarySearchTree extends AppCompatActivity {
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
            ArrayList<TreeNode> treeNodes = (ArrayList<TreeNode>) temp.getChildren();
            if (treeNodes.size() == 0) {
                temp.addChild(new TreeNode(val));
            } else {
                int parentVal;
                int curVal;
                while (temp != null) {
                    parentVal = Integer.parseInt(temp.getData().toString());
                    curVal = Integer.parseInt(val);
                    treeNodes = (ArrayList<TreeNode>) temp.getChildren();
                    if (treeNodes.size() == 0) {
                        temp.addChild(new TreeNode(val));
                        break;
                    } else if (treeNodes.size() == 1) {

                        int sideVal = Integer.parseInt(treeNodes.get(0).getData().toString());
                        if (parentVal < curVal && sideVal<parentVal) {
                            temp.addChild(new TreeNode(val));
                            break;
                        } else if (parentVal > curVal && sideVal>parentVal) {

                            String pVal = treeNodes.get(0).getData().toString();
                            pVal = pVal + val;
                            val = pVal.substring(0, (pVal.length() - val.length()));
                            pVal = pVal.substring(val.length());

                            temp.addChild(new TreeNode(val));
                            treeNodes.get(0).setData(pVal);
                            treeNodes.get(1).setData(val);
                            break;
                        }
                        else
                        {
                            temp = treeNodes.get(0);
                        }

                    }
                    else {
                        if (parentVal > curVal) {
                            temp = treeNodes.get(0);
                        } else {
                            temp = treeNodes.get(1);
                        }
                    }
                }


            }
        }

    }
}


