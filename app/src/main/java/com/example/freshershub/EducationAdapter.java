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

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.EducationViewHolder>{
    Context context ;
    ArrayList<EducationItem> educationList;



    static class EducationViewHolder extends RecyclerView.ViewHolder{
        TextView qualification;
        TextView passingYear;
        TextView specialization;
        TextView collegeName;
        TextView percentage;
        EditText editQualification;
        EditText editPassingYear;
        EditText editSpecialization;
        EditText editCollegeName;
        EditText editPercent;

        ImageView editProfileBtn;
        Button editSaveBtn;
        Button editCancelBtn;
        LinearLayout profile_layout;
        LinearLayout edit_profile_layout;

        EducationViewHolder(View view)
        {
            super(view);
            qualification = view.findViewById(R.id.profile_qualification);
            passingYear = view.findViewById(R.id.profile_passing_year);
            specialization = view.findViewById(R.id.profile_specialization);
            collegeName = view.findViewById(R.id.profile_college_name);
            percentage = view.findViewById(R.id.profile_percent);
            editPercent = view.findViewById(R.id.edit_profile_percent);
            editCollegeName = view.findViewById(R.id.edit_profile_college_name);
            editQualification = view.findViewById(R.id.edit_profile_qualification);
            editPassingYear = view.findViewById(R.id.edit_passing_year);
            editSpecialization = view.findViewById(R.id.edit_profile_specialization);
            editProfileBtn = (ImageView) view.findViewById(R.id.edit_profile_button);
            editSaveBtn = view.findViewById(R.id.edit_education_save_button);
            editCancelBtn = view.findViewById(R.id.edit_education_cancel_button);
            profile_layout = view.findViewById(R.id.profile_layout);
            edit_profile_layout = view.findViewById(R.id.edit_profile_layout);
        }
    }
    public EducationAdapter(@NonNull Context context,ArrayList<EducationItem> educationList)
    {
        this.context = context;
        this.educationList = educationList;
    }
    @NonNull
    public EducationViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
    {
        View educationView = LayoutInflater.from(parent.getContext()).inflate(R.layout.education_item,parent,false);
        return new EducationViewHolder(educationView);
    }
    public void onBindViewHolder(EducationViewHolder holder, @SuppressLint("RecyclerView") int position)
    {

        EducationItem educationItem =  educationList.get(position);
        holder.qualification.setText(educationItem.getQualification());
        holder.passingYear.setText(educationItem.getPassingYear());
        holder.specialization.setText(educationItem.getSpecialization());
        holder.collegeName.setText(educationItem.getCollege_name());
        holder.percentage.setText(educationItem.getPercent());

        if(educationItem.getQualification().length()==0 &&
            educationItem.getSpecialization().length()==0 &&
            educationItem.getCollege_name().length()==0 &&
            educationItem.getPassingYear().length()==0 &&
            educationItem.getPercent().length()==0
        )
        {
            holder.editSpecialization.setText(holder.specialization.getText().toString());
            holder.editCollegeName.setText(holder.collegeName.getText().toString());
            holder.editPercent.setText(holder.percentage.getText().toString());
            holder.editQualification.setText(holder.qualification.getText().toString());
            holder.editPassingYear.setText(holder.passingYear.getText());
            holder.edit_profile_layout.setVisibility(View.VISIBLE);
            holder.profile_layout.setVisibility(View.GONE);
        }

        holder.editProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.editSpecialization.setText(holder.specialization.getText().toString());
                holder.editCollegeName.setText(holder.collegeName.getText().toString());
                holder.editPercent.setText(holder.percentage.getText().toString());
                holder.editQualification.setText(holder.qualification.getText().toString());
                holder.editPassingYear.setText(holder.passingYear.getText());
                holder.edit_profile_layout.setVisibility(View.VISIBLE);
                holder.profile_layout.setVisibility(View.GONE);
            }
        });
        holder.editSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(
                        holder.editQualification.length()<1 ||
                        holder.editSpecialization.length()<1 ||
                        holder.editCollegeName.length()<1 ||
                        holder.editPassingYear.length()<1 ||
                        holder.editPercent.length()<1
                )
                {
                    Toast.makeText(context,"Enter All Fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    holder.percentage.setText(holder.editPercent.getText().toString());
                    holder.specialization.setText(holder.editSpecialization.getText().toString());
                    holder.collegeName.setText(holder.editCollegeName.getText().toString());
                    holder.passingYear.setText(holder.editPassingYear.getText().toString());
                    holder.qualification.setText(holder.editQualification.getText().toString());
                    holder.edit_profile_layout.setVisibility(View.GONE);
                    holder.profile_layout.setVisibility(View.VISIBLE);
                }
            }
        });
        holder.editCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(
                        holder.editQualification.length()==0 ||
                        holder.editSpecialization.length()==0 ||
                        holder.editCollegeName.length()==0 ||
                        holder.editPassingYear.length()==0 ||
                        holder.editPercent.length()==0
                )
                {
                    educationList.remove(position);
                    notifyItemRemoved(position);
                }
                holder.edit_profile_layout.setVisibility(View.GONE);
                holder.profile_layout.setVisibility(View.VISIBLE);
                holder.editQualification.setText("");
                holder.editSpecialization.setText("");
                holder.editCollegeName.setText("");
                holder.editPassingYear.setText("");
                holder.editPercent.setText("");
            }
        });

    }
    public int getItemCount()
    {
            return educationList.size();
    }

}
