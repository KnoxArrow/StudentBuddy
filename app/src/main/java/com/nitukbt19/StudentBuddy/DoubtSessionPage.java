package com.nitukbt19.StudentBuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.nitukbt19.StudentBuddy.Adapter.ChatAdapter;
import com.nitukbt19.StudentBuddy.Models.MessagesModel;
import com.nitukbt19.StudentBuddy.databinding.ActivityDoubtSessionPageBinding;
import com.squareup.picasso.Picasso;
import android.content.Intent;

import java.util.ArrayList;
import java.util.Date;

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
        String receiverId =getIntent().getStringExtra("userId");
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

        final ArrayList<MessagesModel> messagesModels=new ArrayList<>();

        final ChatAdapter chatAdapter=new ChatAdapter(messagesModels,this);
        binding.doubtRecylerView.setAdapter(chatAdapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        binding.doubtRecylerView.setLayoutManager(layoutManager);

        final String senderRoom=senderId+receiverId;
        final String receiverRoom=receiverId+senderId;
        binding.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = binding.etMessage.getText().toString();
                final MessagesModel model=new MessagesModel(senderId,msg);
                model.setTimestamp(new Date().getTime());
                binding.etMessage.setText("");

                database.getReference().child("chats")
                        .child(senderRoom).push()// push triggers messageId w.r.t. Time
                        .setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        database.getReference().child("chats")
                                .child(receiverRoom).push()
                                .setValue(model).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {

                            }
                        });
                    }
                });
            }
        });

    }

}