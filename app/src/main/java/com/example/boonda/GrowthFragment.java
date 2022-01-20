package com.example.boonda;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GrowthFragment extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    ImageView cvMeasurement, cvGraphs,cvHealth;
    private BottomNavigationView bottomNavigationView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_growth);
        overridePendingTransition(0, 0);
        // Inflate the layout for this fragment

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);



        cvMeasurement = findViewById(R.id.iv_measure);
        cvGraphs = findViewById(R.id.iv_graph);
        cvHealth = findViewById(R.id.iv_health);

        cvMeasurement.setOnClickListener(view1-> {
            Intent i = new Intent(this, MeasurementActivity.class);
            startActivity(i);
        });

        cvGraphs.setOnClickListener(view1-> {
            Intent i = new Intent(this, GraphActivity.class);
            startActivity(i);
        });

        cvHealth.setOnClickListener(view1-> {
            Intent i = new Intent(this, AddChildDataActivity.class);
            startActivity(i);
        });


    }
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