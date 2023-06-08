package com.example.atividade3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView show = (TextView) findViewById(R.id.showText);
        String str = getIntent().getStringExtra("data");
        show.setText(str);
    }
}