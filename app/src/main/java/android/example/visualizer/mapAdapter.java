package android.example.visualizer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class mapAdapter extends RecyclerView.Adapter<mapAdapter.ViewHolder> {
    private List<elemetsMap> list;
    private Context context;

    public mapAdapter(List<elemetsMap> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.mapview,parent,false);
         return new ViewHolder(itemView);
    }
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        elemetsMap item = list.get(position);
        holder.t1.setText(Integer.toString(item.getKey()));
        holder.t2.setText(Integer.toString(item.getVal()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
         public TextView t1;
         public TextView t2;
        public ViewHolder(View itemView) {
            super(itemView);
            t1 = (TextView) itemView.findViewById(R.id.block1);
            t2 = (TextView) itemView.findViewById(R.id.block2);
        }
    }
}
