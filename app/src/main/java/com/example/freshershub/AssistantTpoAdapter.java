package com.example.freshershub;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AssistantTpoAdapter extends RecyclerView.Adapter<AssistantTpoAdapter.AssistantTpoViewHolder>{
    Context context ;
    ArrayList<AssistantTpoItem> assistantTpoItemList;


    static class AssistantTpoViewHolder extends RecyclerView.ViewHolder{
        TextView assistantTpoDeptName;
        TextView assistantTpoName;
        TextView assistantTpoDesignation;
        TextView assistantTpoWorkMail;
        TextView assistantTpoPersonalMail;
        TextView assistantTpoContactNo;
        EditText editAssistantTpoDeptName;
        EditText editAssistantTpoName;
        EditText editAssistantTpoDesignation;
        EditText editAssistantTpoWorkMail;
        EditText editAssistantTpoPersonalMail;
        EditText editAssistantTpoContactNo;
        Button assistantTpoCancelButton;
        Button assistantTpoSaveButton;
        ImageView assistantTpoEditButton;
        LinearLayout assistantTpoLayout;
        LinearLayout editAssistantTpoLayout;

        AssistantTpoViewHolder(View view)
        {
            super(view);
            assistantTpoDeptName = view.findViewById(R.id.assistant_tpo_dept_name);
            assistantTpoName= view.findViewById(R.id.assistant_tpo_name);
            assistantTpoDesignation= view.findViewById(R.id.assistant_tpo_designation);
            assistantTpoWorkMail= view.findViewById(R.id.assistant_tpo_work_mail);
            assistantTpoPersonalMail= view.findViewById(R.id.assistant_tpo_personal_mail);
            assistantTpoContactNo= view.findViewById(R.id.assistant_tpo_contact_no);
            editAssistantTpoDeptName = view.findViewById(R.id.edit_assistant_tpo_dept_name);
            editAssistantTpoName = view.findViewById(R.id.edit_assistant_tpo_name);
            editAssistantTpoDesignation = view.findViewById(R.id.edit_assistant_tpo_designation);
            editAssistantTpoWorkMail = view.findViewById(R.id.edit_assistant_tpo_work_mail);
            editAssistantTpoPersonalMail = view.findViewById(R.id.edit_assistant_tpo_personal_mail);
            editAssistantTpoContactNo = view.findViewById(R.id.edit_assistant_tpo_contact_no);
            assistantTpoCancelButton = view.findViewById(R.id.assistant_tpo_cancel_button);
            assistantTpoSaveButton = view.findViewById(R.id.assistant_tpo_save_button);
            assistantTpoEditButton = view.findViewById(R.id.assistant_tpo_edit_button);
            assistantTpoLayout = view.findViewById(R.id.assistant_tpo_layout);
            editAssistantTpoLayout = view.findViewById(R.id.edit_assistant_tpo_layout);
        }
    }
    public AssistantTpoAdapter(@NonNull Context context,ArrayList<AssistantTpoItem> assistantTpoItemList)
    {
        this.context = context;
        this.assistantTpoItemList = assistantTpoItemList;
    }
    @NonNull
    public AssistantTpoViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        View assistantTpoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.assistant_tpo_item,parent,false);
        return new AssistantTpoViewHolder(assistantTpoView);
    }
    public void onBindViewHolder(AssistantTpoViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
        AssistantTpoItem assistantTpoItem = assistantTpoItemList.get(position);
        holder.assistantTpoDeptName.setText(assistantTpoItem.getGetAssistantDeptName());
        holder.assistantTpoName.setText(assistantTpoItem.getAssistantTpoName());
        holder.assistantTpoDesignation.setText(assistantTpoItem.getAssistantTpoDesignation());
        holder.assistantTpoWorkMail.setText(assistantTpoItem.getAssistantTpoWorkMail());
        holder.assistantTpoPersonalMail.setText(assistantTpoItem.getAssistantTpoPersonalMail());
        holder.assistantTpoContactNo.setText(assistantTpoItem.getAssistantTpoContactNo());

        if(assistantTpoItem.getGetAssistantDeptName().length()==0 && assistantTpoItem.getAssistantTpoDesignation().length() == 0 && assistantTpoItem.getAssistantTpoWorkMail().length()==0 && assistantTpoItem.getAssistantTpoPersonalMail().length()==0 && assistantTpoItem.getAssistantTpoContactNo().length()==0 ){
            holder.editAssistantTpoDeptName.setText(holder.assistantTpoDeptName.getText().toString());
            holder.editAssistantTpoName.setText(holder.assistantTpoName.getText().toString());
            holder.editAssistantTpoDesignation.setText(holder.assistantTpoDesignation.getText().toString());
            holder.editAssistantTpoWorkMail.setText(holder.assistantTpoWorkMail.getText().toString());
            holder.editAssistantTpoPersonalMail.setText(holder.assistantTpoPersonalMail.getText().toString());
            holder.editAssistantTpoContactNo.setText(holder.assistantTpoContactNo.getText().toString());
            holder.assistantTpoLayout.setVisibility(View.GONE);
            holder.editAssistantTpoLayout.setVisibility(View.VISIBLE);
        }

        holder.assistantTpoEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.editAssistantTpoDeptName.setText(holder.assistantTpoDeptName.getText().toString());
                holder.editAssistantTpoName.setText(holder.assistantTpoName.getText().toString());
                holder.editAssistantTpoDesignation.setText(holder.assistantTpoDesignation.getText().toString());
                holder.editAssistantTpoWorkMail.setText(holder.assistantTpoWorkMail.getText().toString());
                holder.editAssistantTpoPersonalMail.setText(holder.assistantTpoPersonalMail.getText().toString());
                holder.editAssistantTpoContactNo.setText(holder.assistantTpoContactNo.getText().toString());
                holder.assistantTpoLayout.setVisibility(View.GONE);
                holder.editAssistantTpoLayout.setVisibility(View.VISIBLE);
            }
        });

        holder.assistantTpoCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(
                        holder.editAssistantTpoDeptName.length()==0 ||
                        holder.editAssistantTpoName.length()==0 ||
                        holder.editAssistantTpoDesignation.length()==0
                        || holder.editAssistantTpoWorkMail.length()==0
                        || holder.editAssistantTpoPersonalMail.length()==0
                        || holder.editAssistantTpoContactNo.length()==0
                )
                {
                    assistantTpoItemList.remove(position);
                    notifyItemRemoved(position);
                }
                holder.editAssistantTpoDeptName.setText("");
                holder.editAssistantTpoName.setText("");
                holder.editAssistantTpoDesignation.setText("");
                holder.editAssistantTpoWorkMail.setText("");
                holder.editAssistantTpoPersonalMail.setText("");
                holder.editAssistantTpoContactNo.setText("");
                holder.assistantTpoLayout.setVisibility(View.VISIBLE);
                holder.editAssistantTpoLayout.setVisibility(View.GONE);
            }
        });

        holder.assistantTpoSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.editAssistantTpoDeptName.length()==0 ||
                        holder.editAssistantTpoName.length()==0 ||
                        holder.editAssistantTpoDesignation.length()==0
                        || holder.editAssistantTpoWorkMail.length()==0
                        || holder.editAssistantTpoPersonalMail.length()==0
                        || holder.editAssistantTpoContactNo.length()==0
                )
                {
                    Toast.makeText(context,"Enter All Fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    holder.assistantTpoDeptName.setText(holder.editAssistantTpoDeptName.getText().toString());
                    holder.assistantTpoName.setText(holder.editAssistantTpoName.getText().toString());
                    holder.assistantTpoDesignation.setText(holder.editAssistantTpoDesignation.getText().toString());
                    holder.assistantTpoWorkMail.setText(holder.editAssistantTpoWorkMail.getText().toString());
                    holder.assistantTpoPersonalMail.setText(holder.editAssistantTpoPersonalMail.getText().toString());
                    holder.assistantTpoContactNo.setText(holder.editAssistantTpoContactNo.getText().toString());
                    holder.assistantTpoLayout.setVisibility(View.VISIBLE);
                    holder.editAssistantTpoLayout.setVisibility(View.GONE);
                }
            }
        });

    }
    public int getItemCount()
    {
        return assistantTpoItemList.size();

    }

}
