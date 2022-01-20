package com.example.boonda;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DiscussionFragment extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    ImageView ivInfants, ivPregnancy, ivEducation, ivBehaviour, ivToddlers, ivPreschool, ivParenting, ivTopic;
    RecyclerView recview;
    DiscussionAdapter adapter;
    ArrayList<ModelActivity> list;
    DatabaseReference dbref;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_discussion);
        overridePendingTransition(0, 0);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        recview = findViewById(R.id.rv_recent_discuss);
        recview.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<ModelActivity>();
        dbref = FirebaseDatabase.getInstance().getReference().child("discussion");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for(DataSnapshot dataSnapshot1: snapshot.getChildren()){
                    ModelActivity mList = dataSnapshot1.getValue(ModelActivity.class);
                    list.add(0,mList);
                }
                adapter = new DiscussionAdapter(DiscussionFragment.this,list);
                recview.setAdapter(adapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ivInfants =findViewById(R.id.iv_infants);
        ivPregnancy = findViewById(R.id.iv_pregnancy);
        ivEducation = findViewById(R.id.iv_education);
        ivBehaviour = findViewById(R.id.iv_behavior);
        ivToddlers = findViewById(R.id.iv_toddlers);
        ivPreschool = findViewById(R.id.iv_preschool);
        ivParenting = findViewById(R.id.iv_parenting);
        ivTopic = findViewById(R.id.iv_topics);

        ivInfants.setOnClickListener(view1 -> {
            Intent i = new Intent(this, InfantsActivity.class);
            startActivity(i);
        });

        ivPregnancy.setOnClickListener(view1 -> {
            Intent i = new Intent(this, PregnancyActivity.class);
            startActivity(i);
        });

        ivEducation.setOnClickListener(view1 -> {
            Intent i = new Intent(this, EducationActivity.class);
            startActivity(i);
        });

        ivBehaviour.setOnClickListener(view1 -> {
            Intent i = new Intent(this, BehaviorActivity.class);
            startActivity(i);
        });

        ivToddlers.setOnClickListener(view1 -> {
            Intent i = new Intent(this, ToddlersActivity.class);
            startActivity(i);
        });

        ivPreschool.setOnClickListener(view1 -> {
            Intent i = new Intent(this, PreschoolActivity.class);
            startActivity(i);
        });

        ivParenting.setOnClickListener(view1 -> {
            Intent i = new Intent(this, ParentingActivity.class);
            startActivity(i);
        });

        ivTopic.setOnClickListener(view1 -> {
            Intent i = new Intent(this, ToughTopicsActivity.class);
            startActivity(i);
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                startActivity(new Intent(getApplicationContext(), HomeFragment.class));
                overridePendingTransition(0, 0);
                finish();
                return true;

            case R.id.discussion:
                startActivity(new Intent(getApplicationContext(), DiscussionFragment.class));
                overridePendingTransition(0, 0);
                finish();
                return true;

            case R.id.growth:
                startActivity(new Intent(getApplicationContext(), GrowthFragment.class));
                overridePendingTransition(0, 0);
                finish();
                return true;
        }
        return false;
    }
}