package com.turinglaureate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.turinglaureate.activities.LaureatesActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(view -> {
            Intent laurInt = new Intent(MainActivity.this, LaureatesActivity.class);
            startActivity(laurInt);
        });
    }
}