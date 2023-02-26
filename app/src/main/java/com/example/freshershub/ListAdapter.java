package com.example.freshershub;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.SkillViewHolder> {
    Context context;
    ArrayList<String> itemList;

    static class SkillViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView;
        ImageView deleteImageView;
        SkillViewHolder(View view){
            super(view);
            nameTextView = view.findViewById(R.id.list_item_name);
            deleteImageView = view.findViewById(R.id.list_item_delete);
        }
    }

    public ListAdapter(@NonNull Context context, ArrayList<String> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    public SkillViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new SkillViewHolder(itemView);
    }

    public void onBindViewHolder(SkillViewHolder holder, @SuppressLint("RecyclerView") int position){
        String item = itemList.get(position);
        holder.nameTextView.setText(item);


        holder.deleteImageView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
               itemList.remove(position);
               notifyDataSetChanged();
            }
        });
    }

    public int getItemCount(){
        return itemList.size();
    }

}
