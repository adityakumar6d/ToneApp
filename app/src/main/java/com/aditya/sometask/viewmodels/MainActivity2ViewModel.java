package com.aditya.sometask.viewmodels;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivity2ViewModel extends ViewModel {
    public MutableLiveData<String> nameLive = new MutableLiveData<>();
    public MutableLiveData<String> phoneLive = new MutableLiveData<>();
    public MutableLiveData<String> passwordLive = new MutableLiveData<>();

    public MainActivity2ViewModel() {
    }

    public void CreateAnAccount(String name, String phone, String password, Context context) {
        if (name != null) {
            if (phone != null) {
                if (password != null) {
                    Toast.makeText(context, "Registered", Toast.LENGTH_SHORT).show();
                }
            }
        }

        else {
            Toast.makeText(context, "Please fill all the details!", Toast.LENGTH_SHORT).show();
        }
    }
}


