package com.aditya.sometask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.aditya.sometask.databinding.ActivityMain2Binding;
import com.aditya.sometask.viewmodels.MainActivity2ViewModel;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;
    MainActivity2ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        viewModel = new ViewModelProvider(this, new ViewModelFactory(new MainActivity2ViewModel()).createFor()).get(MainActivity2ViewModel.class);

        binding.signInBtn.setOnClickListener(v -> viewModel.CreateAnAccount(binding.editTextTextPersonName.toString(), binding.editTextPhone.toString(), binding.editTextTextPassword.toString(), getApplicationContext()));
    }
}