package com.example.prime;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Activityf extends Fragment {

    private ImageView backButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_page, container, false);

        // Initialize the back button
        backButton = view.findViewById(R.id.backtoinsight); // Ensure this ID matches your button in XML

        // Set up the back button listener
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to InsightsFragment when back button is clicked
                navigateBackToInsights();
            }
        });

        return view;  // Return the inflated view
    }

    private void navigateBackToInsights() {
        // Replace current fragment with InsightsFragment
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the fragment in the container (frameLayout) with InsightsFragment
        fragmentTransaction.replace(R.id.frameLayout, new InsightsFragment());
        fragmentTransaction.addToBackStack(null); // Optional: Adds fragment to back stack
        fragmentTransaction.commit();  // Commit the transaction
    }
}
