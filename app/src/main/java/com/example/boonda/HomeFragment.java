package com.example.boonda;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class HomeFragment extends Fragment {
    private FirebaseAuth mAuth;
    private TextView user;
    private EditText name, weight, height, head;
    private Button submit;

    DatabaseReference dbref;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        //get current user
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser userr = mAuth.getCurrentUser();
        String curr= userr.getEmail();
        curr = curr.replace("@", "").replace(".", "");

        user = view.findViewById(R.id.curr_user);
        user.setText(curr);
        return view;
    }
}