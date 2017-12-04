package com.example.nguonchhay.ruppandroidclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class RelativeLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);

        EditText editReminderName = (EditText) findViewById(R.id.editReminderName);
        editReminderName.setText("Nguonchhay Touch");
    }
}
