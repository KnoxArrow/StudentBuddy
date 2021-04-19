package com.nitukbt19.StudentBuddy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nitukbt19.StudentBuddy.DoubtSessionPage;
import com.nitukbt19.StudentBuddy.R;
import com.nitukbt19.StudentBuddy.Models.Users;

import java.util.ArrayList;
import android.content.Intent;
import com.squareup.picasso.Picasso;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    ArrayList<Users> list;
    Context context;

    public UserAdapter(ArrayList<Users> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_show_user, parent, false);

        return new ViewHolder((view));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Users users = list.get(position);
        Picasso.get().load(users.getProfilePic()).placeholder(R.drawable.icon_male_ph).into(holder.image);
        holder.UserName.setText(users.getUserName());

        holder.itemView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context, DoubtSessionPage.class);
                intent.putExtra( "userId", users.getUserId());
                intent.putExtra( "ProfilePic" , users.getProfilePic());
                intent.putExtra( "userName", users.getUserName());
                context.startActivity(intent);
            }
             });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView UserName;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            UserName = itemView.findViewById(R.id.UserName);
            image = itemView.findViewById(R.id.profile_image);
        }
    }
}