package com.nitukbt19.StudentBuddy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.nitukbt19.StudentBuddy.Models.MessagesModel;
import com.nitukbt19.StudentBuddy.R;

import java.util.ArrayList;

public class ChatAdapter extends RecyclerView.Adapter{

    ArrayList<MessagesModel> msgModels;
    Context context;
    int SENDER_VIEW=1;
    int RECIEVER_VIEW=2;

    public ChatAdapter(ArrayList<MessagesModel> msgModels, Context context) {
        this.msgModels = msgModels;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if(msgModels.get(position).getuId().equals(FirebaseAuth.getInstance().getUid())){
            return SENDER_VIEW;
        }else{
            return RECIEVER_VIEW;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==SENDER_VIEW){
            View view= LayoutInflater.from(context).inflate(R.layout.sample_sender,parent,false);
            return new SenderViewHolder(view);
        }else{
            View view= LayoutInflater.from(context).inflate(R.layout.sample_reciever,parent,false);
            return new SenderViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MessagesModel msgModel=msgModels.get(position);

        if(holder.getClass()==SenderViewHolder.class){
            ((SenderViewHolder)holder).SenderMsg.setText(msgModel.getMessage());
        }else{
            ((RecieverViewHolder)holder).recieverMsg.setText(msgModel.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return msgModels.size();
    }

    public class RecieverViewHolder extends RecyclerView.ViewHolder{

        TextView recieverMsg,receiverTime;
        public RecieverViewHolder(@NonNull View itemView) {
            super(itemView);
            recieverMsg=itemView.findViewById(R.id.tvRecieverMessage);
            receiverTime=itemView.findViewById(R.id.tvRecieverTime);
        }
    }
    public class SenderViewHolder extends RecyclerView.ViewHolder{

        TextView SenderMsg,SenderTime;
        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);
            SenderMsg=itemView.findViewById(R.id.tvSenderMessage);
            SenderTime=itemView.findViewById(R.id.tvSenderTime);
        }
    }


}
