package com.example.boonda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class HeadAddActivity extends AppCompatActivity {
    private EditText addHead, addAges;
    private Button addButton;
    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_add_head);
        dbref = FirebaseDatabase.getInstance().getReference().child("fachriprtm24").child("David").child("DataHead");
        Date date = Calendar.getInstance().getTime();
        String FormatedDate = DateFormat.getDateInstance(DateFormat.SHORT).format(date);
        addAges = findViewById(R.id.et_ages);
        addHead = findViewById(R.id.et_head);
        addButton = findViewById(R.id.btn_add);



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ages = addAges.getText().toString();
                String Head = addHead.getText().toString();
                HashMap<String,String> headData = new HashMap<>();
                headData.put("ages",ages);
                headData.put("date",FormatedDate);
                headData.put("head",Head);
                dbref.push().setValue(headData);

            }
        });

    }
}