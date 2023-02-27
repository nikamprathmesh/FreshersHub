package com.example.freshershub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class AssistantTpo extends AppCompatActivity {


    RecyclerView assistantTpoRecyclerView;
    ArrayList<AssistantTpoItem> assistantTpoList;
    AssistantTpoAdapter assistantTpoAdapter;
    ImageView assistantTpoAddBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assistant_tpo);

        assistantTpoRecyclerView = findViewById(R.id.assistant_tpo_details);
        assistantTpoAddBtn = findViewById(R.id.assistant_tpo_add_button);
        assistantTpoList = new ArrayList<>();
        assistantTpoAdapter = new AssistantTpoAdapter(this, assistantTpoList);

        assistantTpoList.add(new AssistantTpoItem("Computer","R.P. Bagawade","Assistant Professor","tpo.comp@gcoeara.ac.in","bagawaderp@gmail.com","7465479579"));
        assistantTpoList.add(new AssistantTpoItem("Computer","R.P. Bagawade","Assistant Professor","tpo.comp@gcoeara.ac.in","bagawaderp@gmail.com","7465479579"));

        LinearLayoutManager linearLayoutManagerForAssistantTpo = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        assistantTpoRecyclerView.setLayoutManager(linearLayoutManagerForAssistantTpo);
        assistantTpoRecyclerView.setAdapter(assistantTpoAdapter);

        assistantTpoAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assistantTpoList.add(new AssistantTpoItem("","","","","",""));
                assistantTpoAdapter.notifyItemInserted(assistantTpoList.size()-1);
            }
        });
    }
}