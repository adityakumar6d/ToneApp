package com.aditya.sometask;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.aditya.sometask.databinding.ActivityPlayerBinding;
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
        clickEvents();

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

    private void clickEvents() {
        binding.appbarlayoutToolBar.setNavigationOnClickListener(v -> finish());
        binding.imageView7.setOnClickListener(v -> Toast.makeText(this, "Play button", Toast.LENGTH_SHORT).show());
        binding.imageView8.setOnClickListener(v -> Toast.makeText(this, "Play Previous Track", Toast.LENGTH_SHORT).show());
        binding.imageView9.setOnClickListener(v -> Toast.makeText(this, "Play Next Track", Toast.LENGTH_SHORT).show());
        binding.imageView4.setOnClickListener(v -> Toast.makeText(this, "Menu Button", Toast.LENGTH_SHORT).show());
    }
}