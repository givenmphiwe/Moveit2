package given.Consultants.moveit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>  {
    //where i list every text view to display and images

    private static final String Tag = "RecyclerView";
    private Context mContext;
    private ArrayList<Messages> messagesList;

    public RecyclerAdapter(Context mContext, ArrayList<Messages> messagesList) {
        this.mContext = mContext;
        this.messagesList = messagesList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // the info for viewing the text
        holder.pric.setText(messagesList.get(position).getPric());
        holder.locatio.setText(messagesList.get(position).getLoca());
        holder.bedroo.setText(messagesList.get(position).getBeds());
        holder.squ.setText(messagesList.get(position).getSqua());

        //ImageView : Glide Library
        Glide.with(mContext)
                .load(messagesList.get(position).getImageUrl())
                .into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //Widgets
        ImageView imageView;
        TextView pric;
        TextView locatio;
        TextView bedroo;
        TextView squ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            pric = itemView.findViewById(R.id.price);
            locatio = itemView.findViewById(R.id.location);
            bedroo = itemView.findViewById(R.id.bedroom);
            squ = itemView.findViewById(R.id.sq);
        }
    }


}
