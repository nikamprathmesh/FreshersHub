package com.example.freshershub;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TnpDetails extends AppCompatActivity {

    TextView tnpName;
    TextView tnpDesignation;
    TextView tnpMail;
    TextView tnpContactNo;
    TextView tnpMessage;
    EditText editTnpName;
    EditText editTnpDesignation;
    EditText editTnpMail;
    EditText editTnpContactNo;
    EditText editTnpMessage;
    Button tnpCancelButton;
    Button tnpSaveButton;
    ImageView tnpeditButton;
    LinearLayout tnpLayout;
    LinearLayout editTnpLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tnp_details);

        tnpName = findViewById(R.id.tnp_name);
        tnpDesignation = findViewById(R.id.tnp_designation);
        tnpMail = findViewById(R.id.tnp_mail);
        tnpContactNo = findViewById(R.id.tnp_contact_no);
        tnpMessage = findViewById(R.id.tnp_message);
        editTnpName = findViewById(R.id.edit_tnp_name);
        editTnpDesignation = findViewById(R.id.edit_tnp_designation);
        editTnpMail = findViewById(R.id.edit_tnp_email);
        editTnpContactNo = findViewById(R.id.edit_tnp_phone_no);
        editTnpMessage = findViewById(R.id.edit_tnp_message);
        tnpSaveButton = findViewById(R.id.tnp_save_button);
        tnpCancelButton = findViewById(R.id.tnp_cancel_button);
        tnpeditButton =findViewById(R.id.tnp_edit_button);
        tnpLayout = findViewById(R.id.tnp_details_layout);
        editTnpLayout = findViewById(R.id.edit_tnp_details_layout);

        tnpeditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTnpLayout.setVisibility(View.VISIBLE);
                tnpLayout.setVisibility(View.GONE);
                editTnpName.setText(tnpName.getText().toString());
                editTnpDesignation.setText(tnpName.getText().toString());
                editTnpMail.setText(tnpMail.getText().toString());
                editTnpContactNo.setText(tnpContactNo.getText().toString());
                editTnpMessage.setText(tnpMessage.getText().toString());
            }
        });

        tnpSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(

                        editTnpName.getText().length()==0 ||
                        editTnpDesignation.getText().length()==0 ||
                        editTnpMail.getText().length()==0 ||
                        editTnpContactNo.getText().length()==0 ||
                        editTnpMessage.getText().length()==0
                ){
                    Toast.makeText(TnpDetails.this, "Enter All Fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    tnpName.setText(editTnpName.getText().toString());
                    tnpDesignation.setText(editTnpDesignation.getText().toString());
                    tnpMail.setText(editTnpMail.getText().toString());
                    tnpContactNo.setText(editTnpContactNo.getText().toString());
                    tnpMessage.setText(editTnpMessage.getText().toString());
                    editTnpName.setText("");
                    editTnpDesignation.setText("");
                    editTnpContactNo.setText("");
                    editTnpMail.setText("");
                    editTnpMessage.setText("");
                    editTnpLayout.setVisibility(View.GONE);
                    tnpLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        tnpCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTnpName.setText("");
                editTnpDesignation.setText("");
                editTnpMessage.setText("");
                editTnpMail.setText("");
                editTnpContactNo.setText("");
                editTnpLayout.setVisibility(View.GONE);
                tnpLayout.setVisibility(View.VISIBLE);

            }
        });
    }
}