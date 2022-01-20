package com.example.boonda;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;

public class SelectChildAdapter extends RecyclerView.Adapter<SelectChildAdapter.ImageViewHolder>{
    private SelectChildActivity mContext;
    private List<SelectChildModel> mSelectChildModels;

    public SelectChildAdapter(SelectChildActivity context, List<SelectChildModel> selectChildModels) {
        mContext= context;
        mSelectChildModels = selectChildModels;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.card_child, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        SelectChildModel imageCurr = mSelectChildModels.get(position);
        holder.tv_name_child.setText(imageCurr.getChildName());

        //menit ke 6:13
        Glide.with(holder.itemView.getContext())
                .load(imageCurr.getPhotoProfile())
                .apply(new RequestOptions().override(55,55))
                .into(holder.circleImageView);

        holder.circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), MeasurementActivity.class);
                mContext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mSelectChildModels.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        public CircleImageView circleImageView;
        public TextView tv_name_child;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImageView = itemView.findViewById(R.id.civ_child);
            tv_name_child = itemView.findViewById(R.id.tv_child_name_select);

        }
    }

}