package com.aditya.sometask;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.aditya.sometask.databinding.ActivityMain2Binding;
import com.aditya.sometask.viewmodels.MainActivity2ViewModel;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;
    MainActivity2ViewModel viewModel;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        viewModel = new ViewModelProvider(this, new ViewModelFactory(new MainActivity2ViewModel(getApplicationContext())).createFor()).get(MainActivity2ViewModel.class);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        initObserver();
        clickEvents();

    }

    private void clickEvents() {
        binding.signUpBtn.setOnClickListener(v -> {
            signUpVisibilities();
        });
        binding.registrationBtn.setOnClickListener(v -> {
            progressDialog.show();
            viewModel.CreateAnAccount(binding.editTextTextPersonName.getText().toString(),
                    binding.editTextPhone.getText().toString(),
                    binding.editTextTextPassword.getText().toString());

        });
        binding.alreadyAMember.setOnClickListener(v -> mainScreenVisibilities());
    }

    private void signUpVisibilities() {
        binding.signInBtn.setVisibility(View.GONE);
        binding.signUpBtn.setVisibility(View.GONE);
        binding.editTextTextPassword.setVisibility(View.VISIBLE);
        binding.editTextPhone.setVisibility(View.VISIBLE);
        binding.editTextTextPersonName.setVisibility(View.VISIBLE);
        binding.registrationBtn.setVisibility(View.VISIBLE);
    }

    private void mainScreenVisibilities() {
        binding.signInBtn.setVisibility(View.VISIBLE);
        binding.signUpBtn.setVisibility(View.VISIBLE);
        binding.editTextTextPassword.setVisibility(View.GONE);
        binding.editTextPhone.setVisibility(View.GONE);
        binding.editTextTextPersonName.setVisibility(View.GONE);
        binding.registrationBtn.setVisibility(View.GONE);
    }

    private void initObserver() {
        viewModel.INTENT_FLAG.observe(this, b -> {
            if (b) {
                Intent intent = new Intent(this, ToneListActivity.class);
                startActivity(intent);
                progressDialog.dismiss();
                mainScreenVisibilities();
            }
        });
    }
}