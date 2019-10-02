package com.example.aplikasiberita;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.aplikasiberita.Fragment.FragmentAbout;
import com.example.aplikasiberita.Fragment.FragmentCategory;
import com.example.aplikasiberita.Fragment.FragmentHome;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{


    BottomNavigationView bottom;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottom = findViewById(R.id.bottom);
        bottom.setOnNavigationItemSelectedListener(this);
        fragmentClick(new FragmentHome());
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int userId = menuItem.getItemId();
        Fragment fragment = null;

        switch (userId){
            case R.id.home:
                fragment = new FragmentHome();
                break;
            case R.id.piring:
                fragment = new FragmentCategory();
                break;

            case R.id.calendar:
                fragment = new FragmentAbout();
                break;

        }
        return fragmentClick(fragment);
    }

    private boolean fragmentClick(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();
        }
        return false;

    }
}