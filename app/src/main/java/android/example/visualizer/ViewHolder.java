package android.example.visualizer;

import android.view.View;
import android.widget.TextView;

class ViewHolder {
    TextView tv;
    ViewHolder(View view)
    {
        tv = view.findViewById(R.id.nodeView);
    }
}
