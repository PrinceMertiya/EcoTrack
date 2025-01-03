package com.example.prime;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class InsightsFragment extends Fragment {

    private Button navigateButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insights, container, false);

        // Initialize the navigate button
        navigateButton = view.findViewById(R.id.button); // Ensure this ID matches your button in XML

        // Set an OnClickListener for the button to navigate to Activityf
        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to Activityf fragment
                navigateToActivityf();
            }
        });

        return view;  // Return the inflated view
    }

    private void navigateToActivityf() {
        // Replace current fragment (InsightsFragment) with Activityf
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the fragment in the container (frameLayout) with Activityf
        fragmentTransaction.replace(R.id.frameLayout, new Activityf());
        fragmentTransaction.addToBackStack(null); // Optional: Adds fragment to back stack
        fragmentTransaction.commit();  // Commit the transaction
    }
}
