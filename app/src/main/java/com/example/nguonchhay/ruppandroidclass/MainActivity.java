package com.example.nguonchhay.ruppandroidclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final int MAIN_ACTIVITY_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editEmail = (EditText) findViewById(R.id.editEmail);

                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                intent.putExtra("email", editEmail.getText().toString());
                startActivityForResult(intent, MAIN_ACTIVITY_CODE);
            }
        });

        Button btnLinearLayout = (Button) findViewById(R.id.btnLinearLayout);
        btnLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
                startActivity(intent);
            }
        });

        Button btnRelativeLayout = (Button) findViewById(R.id.btnRelativeLayout);
        btnRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RelativeLayoutActivity.class);
                startActivity(intent);
            }
        });

        Button btnFragment = (Button) findViewById(R.id.btnFragment);
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FragmentDemoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MAIN_ACTIVITY_CODE) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                Toast.makeText(this, "Welcome to: " + name, Toast.LENGTH_LONG).show();
            }
        }
    }
}
