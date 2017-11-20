package com.example.nguonchhay.ruppandroidclass;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Intent intent = getIntent();

        EditText editEmail = (EditText) findViewById(R.id.editEmail);
        editEmail.setText(intent.getStringExtra("email"));
        editEmail.setEnabled(false);

        Button btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editName = (EditText) findViewById(R.id.editName);

                Intent returnIntent = new Intent();
                returnIntent.putExtra("name", editName.getText().toString());
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
