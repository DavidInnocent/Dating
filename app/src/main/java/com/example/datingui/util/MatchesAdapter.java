package com.example.datingui.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.datingui.R;
import com.example.datingui.models.TextMessages;

import java.util.List;

public class MatchesAdapter extends RecyclerView.Adapter {
    Context context;
    List<TextMessages> messagesList;
    public  MatchesAdapter(Context context,List<TextMessages> messagesList)
    {
        this.context=context;
        this.messagesList=messagesList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
       View view= inflater.inflate(R.layout.messages_items,parent,false);
        return new MatchesAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder hold, int position) {

        MatchesAdapterViewHolder holder=(MatchesAdapterViewHolder)hold;

        holder.imgPhoto.setBackgroundResource(messagesList.get(position).getPhotoOfSender());
        holder.txtTime.setText(messagesList.get(position).getTimeOfMessage());
        holder.txtName.setText(messagesList.get(position).getSenderName());
        holder.txtMessage.setText(messagesList.get(position).getMessageBody());

    }

    @Override
    public int getItemCount() {
        return messagesList.size();
    }

    private class MatchesAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView txtName,txtTime,txtMessage;
        ImageView imgPhoto;
        public MatchesAdapterViewHolder(View view) {
            super(view);

            txtMessage=view.findViewById(R.id.txtMessage);
            txtName=view.findViewById(R.id.txtName);
            txtTime=view.findViewById(R.id.txtTime);
            imgPhoto=view.findViewById(R.id.imgPhoto);
        }
    }
}
