package com.example.nguonchhay.ruppandroidclass;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FragmentDemoActivity extends AppCompatActivity implements DemoFragmentCallBack {

    private int currentIndex = 0;
    private List<Fragment> storeFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);
        storeFragments.add(new Demo1Fragment());
        storeFragments.add(new Demo2Fragment());
        storeFragments.add(new Demo3Fragment());

        assignFragmentToActivity();

        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex == 0) {
                    currentIndex = storeFragments.size() - 1;
                } else {
                    currentIndex--;
                }
                assignFragmentToActivity();
            }
        });

        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex == (storeFragments.size() - 1)) {
                    currentIndex = 0;
                } else {
                    currentIndex++;
                }
                assignFragmentToActivity();
            }
        });
    }

    private Fragment getActiveFragment() {
        Fragment activeFragment = (Fragment) storeFragments.get(currentIndex);
        return activeFragment;
    }

    private void assignFragmentToActivity() {
        getFragmentManager()
            .beginTransaction()
            .replace(R.id.fragmentContainer, getActiveFragment())
            .commit();
    }

    @Override
    public void onButtonPressed(int index) {
        currentIndex = index - 1;
        if (currentIndex == (storeFragments.size() - 1)) {
            currentIndex = 0;
        } else {
            currentIndex++;
        }
        assignFragmentToActivity();
    }
}

interface DemoFragmentCallBack {
    public void onButtonPressed(int index);
}
