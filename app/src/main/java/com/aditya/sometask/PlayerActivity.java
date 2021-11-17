package com.aditya.sometask;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.aditya.sometask.databinding.ActivityPlayerBinding;
import com.aditya.sometask.viewmodels.PlayerViewModel;
import com.bumptech.glide.Glide;

public class PlayerActivity extends AppCompatActivity {

    ActivityPlayerBinding binding;
    String title, duration, size, url;
    Boolean isLiked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_player);
        Bundle bundle = getIntent().getExtras();

        title = bundle.getString("TONE_TITLE");
        duration = bundle.getString("TONE_DURATION");
        size = bundle.getString("TONE_SIZE");
        url = bundle.getString("TONE_IMAGE_URL");
        isLiked = bundle.getBoolean("IS_LIKED");

        Glide.with(binding.imageView6).load(url).into(binding.imageView6);
        binding.toneTitle.setText(title);
        binding.appbarlayoutToolBar.setNavigationOnClickListener(v -> finish());

        if (isLiked) {
            // api call for like/dislike icon
            binding.imageView5.setImageResource(R.drawable.full_heart);
        } else {
            // api call for like/dislike icon
            binding.imageView5.setImageResource(R.drawable.empty_heart);
        }

        binding.imageView5.setOnClickListener(v -> {
            if (isLiked) {
                binding.imageView5.setImageResource(R.drawable.empty_heart);
                isLiked = false;
            }
            else {
                {
                    binding.imageView5.setImageResource(R.drawable.full_heart);
                    isLiked = true;
                }
            }
        });
    }
}