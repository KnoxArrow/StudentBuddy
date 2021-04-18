package com.nitukbt19.StudentBuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.nitukbt19.StudentBuddy.databinding.ActivityDoubtSessionPageBinding;
import com.squareup.picasso.Picasso;
import android.content.Intent;

public class DoubtSessionPage extends AppCompatActivity {
    ActivityDoubtSessionPageBinding binding;
FirebaseDatabase database;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDoubtSessionPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database =FirebaseDatabase.getInstance();
          auth=FirebaseAuth.getInstance();
       final String senderId = auth.getUid();
        String reciveId =getIntent().getStringExtra("userId");
        String userName =getIntent().getStringExtra("userName");

        String ProfilePic =getIntent().getStringExtra("ProfilePic");
        binding.userName.setText(userName);
        Picasso.get().load(ProfilePic).placeholder(R.drawable.icon_male_ph).into(binding.profileImage);
        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(DoubtSessionPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}