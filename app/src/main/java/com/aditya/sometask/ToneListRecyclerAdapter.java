package com.aditya.sometask;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.aditya.sometask.databinding.ListItemBinding;
import com.bumptech.glide.Glide;

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
            } else {
                listdata.get(position).setIsliked(false);
                holder.binding.likeIcon.setImageResource(R.drawable.empty_heart);
            }

        });

        holder.binding.playIcon.setOnClickListener(v -> Toast.makeText(holder.binding.playIcon.getContext(), "Played", Toast.LENGTH_SHORT).show());

        holder.binding.itemParent.setOnClickListener(v -> {
            Intent i = new Intent(holder.binding.itemParent.getContext(), PlayerActivity.class);

            Bundle bundle = new Bundle();
            bundle.putString("TONE_TITLE", listdata.get(position).getToneTitle());
            bundle.putString("TONE_DURATION", listdata.get(position).getToneDuration());
            bundle.putString("TONE_SIZE", listdata.get(position).getToneSize());
            bundle.putString("TONE_IMAGE_URL", listdata.get(position).getImageUrl());
            bundle.putBoolean("IS_LIKED", listdata.get(position).getIsliked());
            i.putExtras(bundle);

            holder.binding.itemParent.getContext().startActivity(i);
        });

        Glide.with(holder.binding.imageView2).load(listdata.get(position).getImageUrl()).into(holder.binding.imageView2);

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