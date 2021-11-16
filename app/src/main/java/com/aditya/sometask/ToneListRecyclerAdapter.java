package com.aditya.sometask;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.sometask.databinding.ListItemBinding;

import java.util.List;


public class ToneListRecyclerAdapter extends RecyclerView.Adapter<ToneListRecyclerAdapter.ViewHolder> {
    private List<ToneListData> listdata;

    public ToneListRecyclerAdapter(List<ToneListData> listdata) {
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateToneList(final List<ToneListData> listdata) {
        this.listdata.clear();
        this.listdata = listdata;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.binding.toneTitle.setText(listdata.get(position).getToneTitle());
//        holder.binding.toneSize.setText("Size: " + listdata.get(position).getToneSize() + "MB");
//        holder.binding.toneDuration.setText("Duration: " + listdata.get(position).getToneDuration());
        holder.binding.likeIcon.setOnClickListener(v -> {
            if (!listdata.get(position).getIsliked()) {
                listdata.get(position).setIsliked(true);
                holder.binding.likeIcon.setImageResource(R.drawable.full_heart);
                Toast.makeText(holder.binding.likeIcon.getContext(), "Liked", Toast.LENGTH_SHORT).show();
            } else {
                listdata.get(position).setIsliked(false);
                holder.binding.likeIcon.setImageResource(R.drawable.empty_heart);
                Toast.makeText(holder.binding.likeIcon.getContext(), "Unliked", Toast.LENGTH_SHORT).show();
            }

        });

        holder.binding.playIcon.setOnClickListener(v -> {
            Toast.makeText(holder.binding.playIcon.getContext(), "Played", Toast.LENGTH_SHORT).show();
        });

        holder.binding.itemParent.setOnClickListener(v -> {
            Intent i = new Intent(holder.binding.itemParent.getContext(), PlayerActivity.class);
//            i.putExtra(listdata.get(position).)
            holder.binding.itemParent.getContext().startActivity(i);
        });

//        Glide.with(holder.binding.imageView2).load("https://picsum.photos/100").into(holder.binding.imageView2);

    }


    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ListItemBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}