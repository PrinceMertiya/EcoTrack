package com.example.prime;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.prime.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        // Initialize binding and set the content view
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initially load the HomeFragment
        replaceFragment(new HomeFragment());

        // Set the BottomNavigationView item selection listener
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.home) {
                Log.d("MainActivity", "Home selected");
                replaceFragment(new HomeFragment());

            } else if (itemId == R.id.group) {
                Log.d("MainActivity", "Group selected");
                replaceFragment(new GroupsFragment());

            } else if (itemId == R.id.eco) {
                Log.d("MainActivity", "Eco selected");
                replaceFragment(new EcoFragment());

            } else if (itemId == R.id.insight) {
                Log.d("MainActivity", "Insight selected");
                replaceFragment(new InsightsFragment());

            } else if (itemId == R.id.setting) {
                Log.d("MainActivity", "Setting selected");
                replaceFragment(new SettingFragment());
            }
            return true;
        });
    }

    // Method to replace fragments
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.addToBackStack(null); // Optional: Adds fragment to back stack for better navigation
        fragmentTransaction.commit();
    }
}
