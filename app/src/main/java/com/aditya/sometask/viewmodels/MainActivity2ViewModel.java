package com.aditya.sometask.viewmodels;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aditya.sometask.ToneListActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity2ViewModel extends ViewModel {
    public MutableLiveData<String> nameLive = new MutableLiveData<>();
    public MutableLiveData<String> phoneLive = new MutableLiveData<>();
    public MutableLiveData<String> passwordLive = new MutableLiveData<>();
    public MutableLiveData<Boolean> INTENT_FLAG = new MutableLiveData<>();
    Context context;

    public MainActivity2ViewModel(Context context) {
        this.context = context;
    }

    public void CreateAnAccount(String name, String phone, String password) {
        if (!name.equals("")) {
            if (!phone.equals(""))
                if (!password.equals(""))
                    Toast.makeText(context, "Registered", Toast.LENGTH_SHORT).show();

        else
            Toast.makeText(context, "Please fill all the details!", Toast.LENGTH_SHORT).show();
        }

        validateNumber(name, phone, password);
    }

    private void validateNumber(String name, String phone, String password) {
        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!(snapshot.child("Users").child(phone).exists())) {
                    HashMap<String, Object> userDataMap = new HashMap<>();
                    userDataMap.put("phone", phone);
                    userDataMap.put("name", name);
                    userDataMap.put("password", password);

                    RootRef.child("Users").child(phone).updateChildren(userDataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                          if (task.isSuccessful()) {
                              INTENT_FLAG.setValue(true);
                          }
                          else
                              Toast.makeText(context, "Some Error occurred", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    Toast.makeText(context, "This phone number already exists in the database", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}


