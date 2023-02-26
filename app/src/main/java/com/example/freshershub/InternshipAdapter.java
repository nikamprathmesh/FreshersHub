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

import java.util.ArrayList;

public class InternshipAdapter extends RecyclerView.Adapter<InternshipAdapter.InternshipViewHolder>{
    Context context ;
    ArrayList<Internship_detail> internshipList;

    static class InternshipViewHolder extends RecyclerView.ViewHolder{
        TextView posName;
        TextView mode;
        TextView orgName;
        TextView startMonth;
        TextView startYear;
        TextView endMonth;
        TextView endYear;
        TextView description;
        EditText editPosName;
        EditText editMode;
        EditText editOrgName;
        EditText editStartMonth;
        EditText editStartYear;
        EditText editEndMonth;
        EditText editEndYear;
        EditText editDescription;
        LinearLayout internshipLayout;
        LinearLayout editInternshipLayout;
        ImageView editInternshipBtn;
        Button editCancelBtn;
        Button editSaveBtn;
        InternshipViewHolder(View view)
        {
            super(view);
            posName = view.findViewById(R.id.internship_pos);
            mode = view.findViewById(R.id.internship_mode);
            orgName = view.findViewById(R.id.internship_org_name);
            startMonth = view.findViewById(R.id.internship_start_month);
            startYear = view.findViewById(R.id.internship_start_year);
            endMonth = view.findViewById(R.id.internship_end_month);
            endYear = view.findViewById(R.id.internship_end_year);
            description = view.findViewById(R.id.internship_description);
            editPosName = view.findViewById(R.id.edit_internship_pos);
            editOrgName = view.findViewById(R.id.edit_internship_org_name);
            editMode = view.findViewById(R.id.edit_internship_mode);
            editStartMonth = view.findViewById(R.id.edit_start_month);
            editStartYear = view.findViewById(R.id.edit_start_year);
            editEndMonth = view.findViewById(R.id.edit_end_month);
            editEndYear = view.findViewById(R.id.edit_end_year);
            editDescription = view.findViewById(R.id.edit_internship_description);
            editInternshipBtn = (ImageView) view.findViewById(R.id.edit_internship_details);
            editCancelBtn = view.findViewById(R.id.edit_internship_cancel_button);
            editSaveBtn = view.findViewById(R.id.edit_internship_save_button);
            internshipLayout = view.findViewById(R.id.internship_layout);
            editInternshipLayout = view.findViewById(R.id.edit_internship_layout);
        }
    }
    public InternshipAdapter(@NonNull Context context,ArrayList<Internship_detail> internshipList)
    {
        this.context = context;
        this.internshipList = internshipList;
    }
    @NonNull
    public InternshipViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        View internView = LayoutInflater.from(parent.getContext()).inflate(R.layout.internships,parent,false);
        return new InternshipViewHolder(internView);
    }
    public void onBindViewHolder(InternshipViewHolder holder, @SuppressLint("RecyclerView") int position)
    {
        Internship_detail internship_detail =  internshipList.get(position);
        holder.posName.setText(internship_detail.getInternshipPos());
        holder.mode.setText(internship_detail.getInternshipMode());
        holder.orgName.setText(internship_detail.getInternshipOrgName());
        holder.startYear.setText(internship_detail.getInternshipStartYear());
        holder.startMonth.setText(internship_detail.getInternshipStartMonth());
        holder.endMonth.setText(internship_detail.getInternshipEndMonth());
        holder.endYear.setText(internship_detail.getGetInternshipEndYear());
        holder.description.setText(internship_detail.getInternshipDescription());

        if(internship_detail.getInternshipPos().length()==0 &&
                internship_detail.getInternshipMode().length()==0 &&
                internship_detail.getInternshipOrgName().length()==0 &&
                internship_detail.getInternshipStartMonth().length()==0 &&
                internship_detail.getInternshipStartYear().length()==0 &&
                internship_detail.getInternshipEndMonth().length()==0 &&
                internship_detail.getInternshipStartYear().length()==0 &&
                internship_detail.getInternshipDescription().length()==0  )
        {
            holder.editPosName.setText(holder.posName.getText().toString());
            holder.editOrgName.setText(holder.orgName.getText().toString());
            holder.editDescription.setText(holder.description.getText().toString());
            holder.editMode.setText(holder.mode.getText().toString());
            holder.editStartYear.setText(holder.startYear.getText().toString());
            holder.editStartMonth.setText(holder.startMonth.getText().toString());
            holder.editEndMonth.setText(holder.endMonth.getText().toString());
            holder.editEndYear.setText(holder.endYear.getText().toString());
            holder.internshipLayout.setVisibility(View.GONE);
            holder.editInternshipLayout.setVisibility(View.VISIBLE);
        }
        holder.editInternshipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.editPosName.setText(holder.posName.getText().toString());
                holder.editOrgName.setText(holder.orgName.getText().toString());
                holder.editDescription.setText(holder.description.getText().toString());
                holder.editMode.setText(holder.mode.getText().toString());
                holder.editStartYear.setText(holder.startYear.getText().toString());
                holder.editStartMonth.setText(holder.startMonth.getText().toString());
                holder.editEndMonth.setText(holder.endMonth.getText().toString());
                holder.editEndYear.setText(holder.endYear.getText().toString());
                holder.internshipLayout.setVisibility(View.GONE);
                holder.editInternshipLayout.setVisibility(View.VISIBLE);
            }
        });

        holder.editCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.editPosName.length()==0 ||
                holder.editOrgName.length()==0 ||
                holder.editDescription.length()==0 ||
                holder.editMode.length()==0 ||
                holder.editStartYear.length()==0 ||
                holder.editStartMonth.length()==0 ||
                holder.editEndMonth.length()==0 ||
                holder.editEndYear.length()==0)
                {
                    internshipList.remove(position);
                    notifyItemRemoved(position);
                }

                holder.editPosName.setText("");
                holder.editOrgName.setText("");
                holder.editDescription.setText("");
                holder.editMode.setText("");
                holder.editStartYear.setText("");
                holder.editStartMonth.setText("");
                holder.editEndMonth.setText("");
                holder.editEndYear.setText("");
                holder.internshipLayout.setVisibility(View.VISIBLE);
                holder.editInternshipLayout.setVisibility(View.GONE);
            }
        });

        holder.editSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(     holder.editPosName.length()<1 ||
                        holder.editOrgName.length()<1 ||
                        holder.editMode.length()<1 ||
                        holder.editStartMonth.length()<1 ||
                        holder.editStartYear.length()<1 ||
                        holder.editEndMonth.length()<1 ||
                        holder.editEndYear.length()<1 ||
                        holder.editDescription.length()<1
                )
                {
                    Toast.makeText(context,"Enter All Fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    holder.posName.setText(holder.editPosName.getText().toString());
                    holder.orgName.setText(holder.editOrgName.getText().toString());
                    holder.mode.setText(holder.editMode.getText().toString());
                    holder.startMonth.setText(holder.editStartMonth.getText().toString());
                    holder.startYear.setText(holder.editStartYear.getText().toString());
                    holder.endMonth.setText("- " + holder.editEndMonth.getText().toString());
                    holder.endYear.setText(holder.editEndYear.getText().toString());
                    holder.description.setText(holder.editDescription.getText().toString());
                    holder.internshipLayout.setVisibility(View.VISIBLE);
                    holder.editInternshipLayout.setVisibility(View.GONE);
                }
            }
        });
    }
    public int getItemCount()
    {
        return internshipList.size();

    }

}
