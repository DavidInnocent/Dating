package com.david.datingui.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.david.datingui.R;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter {
    private Context context;
    List<Integer> images;
    public ImageAdapter(List<Integer> images, Context context) {
        this.images=images;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.photo_items,parent,false);

        return new ImagesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ImagesHolder imagesHolder=(ImagesHolder)holder;

        imagesHolder.imageView.setBackgroundResource(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    private class ImagesHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public ImagesHolder(View view) {
            super(view);
            imageView=view.findViewById(R.id.images);
        }
    }
}
