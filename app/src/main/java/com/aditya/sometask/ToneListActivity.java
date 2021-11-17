package com.aditya.sometask;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.aditya.sometask.databinding.ActivityToneListBinding;
import com.aditya.sometask.viewmodels.ToneListViewModel;

public class ToneListActivity extends AppCompatActivity {
    private ToneListViewModel viewModel;
    private ActivityToneListBinding binding;
    ToneListRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tone_list);
        viewModel = new ViewModelProvider(this).get(ToneListViewModel.class);
        viewModel.populateList();
        adapter = new ToneListRecyclerAdapter(viewModel.toneListData);
        recyclerFunc();
    }

    private void recyclerFunc() {
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
    }

}