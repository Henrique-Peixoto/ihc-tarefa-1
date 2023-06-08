package com.example.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSend(View view) {
        Intent i = new Intent(this, MainActivity2.class);
        editText = (EditText)findViewById(R.id.editText);
        i.putExtra("data", editText.getText().toString());
        startActivity(i);
    }
}