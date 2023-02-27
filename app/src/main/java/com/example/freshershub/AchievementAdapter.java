package com.example.freshershub;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class AchievementAdapter extends RecyclerView.Adapter<AchievementAdapter.AchievementViewHolder>{
    Context context ;
    ArrayList<AchievementItem> achievementList;


    static class AchievementViewHolder extends RecyclerView.ViewHolder{
        TextView achievementTitle;
        TextView achievementIssuer;
        TextView achievementIssueDate;
        TextView achievementDescription;
        EditText editAchievementTitle;
        EditText editAchievementIssuer;
        EditText editAchievementIssueDate;
        EditText editAchievementDescription;
        Button achievementCancelBtn;
        Button achievementSaveBtn;
        ImageView achievementEditBtn;
        LinearLayout achievementLayout;
        LinearLayout editAchievementLayout;

        AchievementViewHolder(View view)
        {
            super(view);
            achievementTitle = view.findViewById(R.id.achievment_title);
            achievementIssuer = view.findViewById(R.id.achievment_issuer);
            achievementIssueDate = view.findViewById(R.id.achievment_issue_date);
            achievementDescription = view.findViewById(R.id.achiement_description);
            editAchievementTitle = view.findViewById(R.id.edit_achievment_title);
            editAchievementIssuer = view.findViewById(R.id.edit_achievment_issuer);
            editAchievementIssueDate = view.findViewById(R.id.edit_achievment_issue_date);
            editAchievementDescription = view.findViewById(R.id.edit_achiement_description);
            achievementCancelBtn = view.findViewById(R.id.achievment_cancel_button);
            achievementSaveBtn = view.findViewById(R.id.achievment_save_button);
            achievementEditBtn = view.findViewById(R.id.achievment_edit_button);
            achievementLayout = view.findViewById(R.id.achievment_layout);
            editAchievementLayout = view.findViewById(R.id.edit_achievment_layout);

        }
    }
    public AchievementAdapter(@NonNull Context context,ArrayList<AchievementItem> achievementList)
    {
        this.context = context;
        this.achievementList = achievementList;
    }
    @NonNull
    public AchievementViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        View achievementView = LayoutInflater.from(parent.getContext()).inflate(R.layout.achievement_item,parent,false);
        return new AchievementViewHolder(achievementView);
    }
    public void onBindViewHolder(AchievementViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
        AchievementItem achievementItem = achievementList.get(position);
        holder.achievementTitle.setText(achievementItem.getAchievementTitle());
        holder.achievementIssuer.setText(achievementItem.getAchievementIssuer());
        holder.achievementIssueDate.setText(achievementItem.getAchievementIssueDate());
        holder.achievementDescription.setText(achievementItem.getAchievementDescription());

        if(achievementItem.getAchievementTitle().length()==0 && achievementItem.getAchievementIssuer().length() == 0 && achievementItem.getAchievementIssueDate().length()==0 && achievementItem.getAchievementDescription().length()==0 ){
            holder.editAchievementTitle.setText(holder.achievementTitle.getText().toString());
            holder.editAchievementIssuer.setText(holder.achievementIssuer.getText().toString());
            holder.editAchievementIssueDate.setText(holder.achievementIssueDate.getText().toString());
            holder.editAchievementDescription.setText(holder.achievementDescription.getText().toString());
            holder.achievementLayout.setVisibility(View.GONE);
            holder.editAchievementLayout.setVisibility(View.VISIBLE);
        }


        holder.achievementEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.editAchievementTitle.setText(holder.achievementTitle.getText().toString());
                holder.editAchievementIssuer.setText(holder.achievementIssuer.getText().toString());
                holder.editAchievementIssueDate.setText(holder.achievementIssueDate.getText().toString());
                holder.editAchievementDescription.setText(holder.achievementDescription.getText().toString());
                holder.achievementLayout.setVisibility(View.GONE);
                holder.editAchievementLayout.setVisibility(View.VISIBLE);
            }
        });

        holder.achievementCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.editAchievementTitle.length()==0
                    || holder.editAchievementIssuer.length()==0
                    || holder.editAchievementDescription.length()==0
                    || holder.editAchievementIssueDate.length()==0)
                {
                    achievementList.remove(position);
                    notifyItemRemoved(position);
                }
                holder.editAchievementTitle.setText("");
                holder.editAchievementIssuer.setText("");
                holder.editAchievementIssueDate.setText("");
                holder.editAchievementDescription.setText("");
                holder.achievementLayout.setVisibility(View.VISIBLE);
                holder.editAchievementLayout.setVisibility(View.GONE);
            }
        });

        holder.achievementSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.editAchievementTitle.length()<1 ||
                        holder.editAchievementIssuer.length()<1
                        || holder.editAchievementIssueDate.length()<1 ||
                        holder.editAchievementDescription.length()<1)
                {
                    Toast.makeText(context,"Enter All Fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    holder.achievementTitle.setText(holder.editAchievementTitle.getText().toString());
                    holder.achievementIssuer.setText(holder.editAchievementIssuer.getText().toString());
                    holder.achievementIssueDate.setText(holder.editAchievementIssueDate.getText().toString());
                    holder.achievementDescription.setText(holder.editAchievementDescription.getText().toString());
                    holder.achievementLayout.setVisibility(View.VISIBLE);
                    holder.editAchievementLayout.setVisibility(View.GONE);
                }
            }
        });

    }
    public int getItemCount()
    {
        return achievementList.size();

    }

}
