package com.example.freshershub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_ViewProfile extends AppCompatActivity {

    EditText editProfilePrimaryName;
    EditText editProfilePrimaryRollNo;
    EditText editProfilePrimaryQualification;
    EditText editProfilePrimaryPassingYear;
    EditText editProfilePrimaryStream;
//    professional title added code
    EditText editProfilePrimaryProfessionalTitle;
//    professional title added code end

    TextView profilePrimaryName;
    TextView profilePrimaryRollNo;
    TextView profilePrimaryQualification;
    TextView profilePrimaryPassingYear;
    TextView profilePrimaryStream;
    //    professional title added code
    TextView profilePrimaryProfessionalTitle;
    //    professional title added code end
    ImageView profileImage;

    LinearLayout profilePrimaryLayout;
    LinearLayout editProfilePrimaryLayout;

    Button profilePrimarySaveBtn;
    Button profilePrimaryCancelBtn;
    ImageView profilePrimaryEditBtn;

    LinearLayout editSkillLayout;
    EditText editSkill;
    Button editSkillCancelbtn;
    Button editSkillSavebtn;
    EditText editContactNo;
    EditText editWorkEmail;
    EditText editPersonalEmail;
    EditText editAddress;
    TextView contactNo;
    TextView workEmail;
    TextView personalEmail;
    TextView address;
    ImageView editContactBtn;
    Button editContactCancelBtn;
    Button editContactSaveBtn;
    LinearLayout contactLayout;
    LinearLayout editContactLayout;

    RecyclerView skillListView;
    ArrayList<String> skillList;
    ListAdapter listAdapter;
    ImageView addSkillsBtn;

    RecyclerView internshipRecyclerView;
    ArrayList<Internship_detail> internshipDetailsArrayList;
    InternshipAdapter internshipAdapter;
    ImageView addInternshipBtn;

    RecyclerView  educationListView;
    ArrayList<EducationItem> educationItemArrayList;
    EducationAdapter educationAdapter;
    ImageView addEducationBtn;

    RecyclerView projectRecyclerView;
    ArrayList<ProjectItem> projectArrayList;
    ProjectAdapter projectAdapter;
    ImageView addProjectBtn;

    RecyclerView achievementsRecyclerView;
    ArrayList<AchievementItem> achievementItemArrayList;
    AchievementAdapter achievementAdapter;
    ImageView addAchievementBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);

        profilePrimaryName = findViewById(R.id.profile_primary_name);
        profilePrimaryRollNo = findViewById(R.id.profile_primary_roll_no);
        profilePrimaryQualification = findViewById(R.id.profile_primary_qualification);
        profilePrimaryPassingYear = findViewById(R.id.profile_primary_passing_year);
        profilePrimaryStream = findViewById(R.id.profile_primary_stream);
        //    professional title added code
        profilePrimaryProfessionalTitle = findViewById(R.id.profile_professional_title);
        //    professional title added code end
        profileImage = findViewById(R.id.profile_primary_image);


        editProfilePrimaryName = findViewById(R.id.edit_profile_primary_name);
        editProfilePrimaryRollNo = findViewById(R.id.edit_profile_primary_roll_no);
        editProfilePrimaryQualification = findViewById(R.id.edit_profile_primary_qualification);
        editProfilePrimaryPassingYear = findViewById(R.id.edit_profile_primary_passing_year);
        editProfilePrimaryStream = findViewById(R.id.edit_profile_primary_stream);
        //    professional title added code
        editProfilePrimaryProfessionalTitle = findViewById(R.id.edit_profile_professional_title);
        //    professional title added code end

        profilePrimaryCancelBtn = findViewById(R.id.profile_primary_cancel_button);
        profilePrimarySaveBtn = findViewById(R.id.profile_primary_save_button);
        profilePrimaryEditBtn = findViewById(R.id.edit_profile_primary_details);
        profilePrimaryLayout = findViewById(R.id.profile_primary_layout);
        editProfilePrimaryLayout = findViewById(R.id.edit_profile_primary_layout);

        editSkillCancelbtn = findViewById(R.id.skills_cancel_button);
        editSkillSavebtn = findViewById(R.id.skills_save_button);
        editSkillLayout = findViewById(R.id.edit_skill_layout);
        editSkill = findViewById(R.id.edit_skill);
        skillList = new ArrayList<>();
        skillListView = findViewById(R.id.skillslistview);
        listAdapter = new ListAdapter(this, skillList);
        addSkillsBtn = findViewById(R.id.skills_add_button);

        addInternshipBtn = findViewById(R.id.internship_add_button);
        addEducationBtn = findViewById(R.id.education_add_button);
        addProjectBtn = findViewById(R.id.project_add_button);
        addAchievementBtn =(ImageView) findViewById(R.id.achievement_add_button);
        editContactNo = findViewById(R.id.edit_profile_contact_no);
        editPersonalEmail = findViewById(R.id.edit_profile_personal_email);
        editWorkEmail = findViewById(R.id.edit_profile_work_email);
        workEmail = findViewById(R.id.profile_work_email);
        personalEmail = findViewById(R.id.profile_personal_email);
        contactNo = findViewById(R.id.profile_contact_no);
        address = findViewById(R.id.profile_address);
        editAddress = findViewById(R.id.edit_profile_address);
        editContactBtn = findViewById(R.id.edit_contact_edit_button);
        editContactCancelBtn = findViewById(R.id.edit_contact_cancel_button);
        editContactSaveBtn = findViewById(R.id.edit_contact_save_button);
        contactLayout = findViewById(R.id.contact_layout);
        editContactLayout = findViewById(R.id.edit_contact_layout);





        profilePrimaryEditBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editProfilePrimaryLayout.setVisibility(View.VISIBLE);
            }
        });
        profilePrimaryCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editProfilePrimaryName.setText("");
                editProfilePrimaryRollNo.setText("");
                editProfilePrimaryQualification.setText("");
                editProfilePrimaryPassingYear.setText("");
                editProfilePrimaryStream.setText("");
                //    professional title added code
                editProfilePrimaryProfessionalTitle.setText("");
                //    professional title added code end
                editProfilePrimaryLayout.setVisibility(View.GONE);
            }
        });

        profilePrimarySaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(
                        editProfilePrimaryName.getText().length()==0 ||
                        editProfilePrimaryRollNo.getText().length()==0 ||
                        editProfilePrimaryQualification.getText().length()==0 ||
                        editProfilePrimaryPassingYear.getText().length()==0 ||
                        editProfilePrimaryStream.getText().length()==0 ||
                                //    professional title added code
                        editProfilePrimaryProfessionalTitle.getText().length()==0
                    //    professional title added code end
                )
                {
                    Toast.makeText(Activity_ViewProfile.this, "Enter Valid Data", Toast.LENGTH_SHORT).show();
                }
                else{
                    profilePrimaryName.setText(editProfilePrimaryName.getText().toString());
                    profilePrimaryRollNo.setText(editProfilePrimaryRollNo.getText().toString());
                    profilePrimaryQualification.setText(editProfilePrimaryQualification.getText().toString());
                    profilePrimaryPassingYear.setText(" "+editProfilePrimaryPassingYear.getText().toString());
                    profilePrimaryStream.setText(" ("+editProfilePrimaryStream.getText().toString()+")");
                    //    professional title added code
                    profilePrimaryProfessionalTitle.setText(editProfilePrimaryProfessionalTitle.getText().toString());
                    //    professional title added code end
                    editProfilePrimaryName.setText("");
                    editProfilePrimaryRollNo.setText("");
                    editProfilePrimaryQualification.setText("");
                    editProfilePrimaryPassingYear.setText("");
                    editProfilePrimaryStream.setText("");
                    //    professional title added code
                    editProfilePrimaryProfessionalTitle.setText("");
                    //    professional title added code end
                    editProfilePrimaryLayout.setVisibility(View.GONE);
                }
            }
        });
        skillList.add("Java");
        skillList.add("SQL");
        skillList.add("Front End");
        skillList.add("Python");

        internshipDetailsArrayList = new ArrayList<>();
        internshipRecyclerView = findViewById(R.id.internship_details_view);
        internshipAdapter = new InternshipAdapter(this, internshipDetailsArrayList);

        internshipDetailsArrayList.add(new Internship_detail("Android Developer", "Offline", "Freshers Hub","Mar","2021","Feb","2022", "hello"));
        internshipDetailsArrayList.add(new Internship_detail("Web Developer", "Online", "TCS", "June","2021","Sept","2021", "Develop frontend application"));

        projectArrayList = new ArrayList<>();
        projectRecyclerView = findViewById(R.id.project_details_view);
        projectAdapter = new ProjectAdapter(this,projectArrayList);

        projectArrayList.add(new ProjectItem("Qr Code Generator","Web development","Build a web portal to learn the different courses. Technologies Used : HTML, CSS, ReactJs, NodeJS, MongoDB. "));
        projectArrayList.add(new ProjectItem("Learning App","Android development","Visualize and present the charts, graphs on web.\n" +
                "Implement dashboard design for the best user experience. Technologies used : HTML, CSS, React.Node, ChartJS, MongoDB. "));


        educationItemArrayList = new ArrayList<>();
        educationListView = findViewById(R.id.educationListView);
        educationAdapter = new EducationAdapter(this,educationItemArrayList);

        educationItemArrayList.add(new EducationItem("SSC","2017","Science","Shri Bhairavanath Vidyalaya, Khadki","89.80"));
        educationItemArrayList.add(new EducationItem("HSC","2019","Science","Vidya Pratishthan Baramati","64.15"));
        educationItemArrayList.add(new EducationItem("BE","2023","Computer","Government college of Engineering and Research Avasari","89.80"));

        achievementItemArrayList = new ArrayList<>();
        achievementsRecyclerView = findViewById(R.id.achievements_details_view);
        achievementAdapter = new AchievementAdapter(this,achievementItemArrayList);

        achievementItemArrayList.add(new AchievementItem("AIR1","College","20-03-2022","Got 1st Rank"));
        achievementItemArrayList.add(new AchievementItem("AIR1","College","20-03-2022","Got 1st Rank"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        skillListView.setLayoutManager(linearLayoutManager);
        skillListView.setAdapter(listAdapter);

        LinearLayoutManager linearLayoutManagerForInternship = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        internshipRecyclerView.setLayoutManager(linearLayoutManagerForInternship);
        internshipRecyclerView.setAdapter(internshipAdapter);

        LinearLayoutManager linearLayoutManagerForEducation = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        educationListView.setLayoutManager(linearLayoutManagerForEducation);
        educationListView.setAdapter(educationAdapter);

        LinearLayoutManager linearLayoutManagerForProject = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        projectRecyclerView.setLayoutManager(linearLayoutManagerForProject);
        projectRecyclerView.setAdapter(projectAdapter);

        LinearLayoutManager linearLayoutManagerForAchievement = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        achievementsRecyclerView.setLayoutManager(linearLayoutManagerForAchievement);
        achievementsRecyclerView.setAdapter(achievementAdapter);




        editContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editPersonalEmail.setText(personalEmail.getText().toString());
                editContactNo.setText(contactNo.getText().toString());
                editWorkEmail.setText(workEmail.getText().toString());
                editAddress.setText(address.getText().toString());
                contactLayout.setVisibility(View.GONE);
                editContactLayout.setVisibility(View.VISIBLE);
            }
        });

        editContactCancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editContactNo.getText().toString().length()<1 && editPersonalEmail.getText().toString().length()<1 && editWorkEmail.getText().toString().length()<1 && editAddress.getText().toString().length()<1)
                {
                    contactLayout.setVisibility(View.GONE);
                }
                else{
                    contactLayout.setVisibility(View.VISIBLE);
                }

                editPersonalEmail.setText("");
                editWorkEmail.setText("");
                editContactNo.setText("");
                editAddress.setText("");

                editContactLayout.setVisibility(View.GONE);
            }
        });

        editContactSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!validateContactData())
                {
                    Toast.makeText(Activity_ViewProfile.this, "Enter All Fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    workEmail.setText(editWorkEmail.getText().toString());
                    personalEmail.setText(editPersonalEmail.getText().toString());
                    contactNo.setText(editContactNo.getText().toString());
                    address.setText(editAddress.getText().toString());
                    contactLayout.setVisibility(View.VISIBLE);
                    editContactLayout.setVisibility(View.GONE);

                }
            }
        });


        addProjectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                projectArrayList.add(new ProjectItem("","",""));
                projectAdapter.notifyItemInserted(projectArrayList.size()-1);
            }
        });

        addInternshipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                internshipDetailsArrayList.add(new Internship_detail("","","","","","","",""));
                internshipAdapter.notifyItemInserted(internshipDetailsArrayList.size()-1);
            }
        });
        addEducationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                educationItemArrayList.add(new EducationItem("","","","",""));
                educationAdapter.notifyItemInserted(educationItemArrayList.size()-1);
            }
        });

        addSkillsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editSkillLayout.setVisibility(view.VISIBLE);
            }
        });

        editSkillCancelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editSkill.setText("");
                editSkillLayout.setVisibility(View.GONE);
            }
        });
        editSkillSavebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editSkill.getText().length()<1)
                {
                    Toast.makeText(Activity_ViewProfile.this, "Enter valid data", Toast.LENGTH_SHORT).show();
                }
                else{
                    skillList.add(editSkill.getText().toString());
                    listAdapter.notifyItemInserted(skillList.size()-1);
                    editSkill.setText("");
                    editSkillLayout.setVisibility(View.GONE);
                }
            }
        });

        addAchievementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                achievementItemArrayList.add(new AchievementItem("","","",""));
                achievementAdapter.notifyItemInserted(achievementItemArrayList.size()-1);
            }
        });

    }

    private boolean validateContactData()
    {
        if(editContactNo.getText().length()!=10)
        {
            editContactNo.setError("Enter Valid Phone Number");
            return false;
        }
        if(editPersonalEmail.getText().length()<1)
        {
            editPersonalEmail.setError("Enter valid Email");
            return false;
        }
        else if(!editPersonalEmail.getText().toString().contains("@")){
            editPersonalEmail.setError("Enter valid Email");
            return false;
        }
        if(editWorkEmail.getText().length()<1)
        {
            editWorkEmail.setError("Enter valid college Email");
            return false;
        }
        else if(!editWorkEmail.getText().toString().contains("@gcoeara.ac.in")){
            editWorkEmail.setError("Enter valid college Email");
            return false;
        }
        if(editAddress.getText().toString().length()<1)
        {
            editAddress.setError("Enter valid Address");
            return false;
        }
        return true;
    }
}