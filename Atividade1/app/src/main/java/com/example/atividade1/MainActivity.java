package com.example.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText editText1, editText2;
    TextView textView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText) findViewById(R.id.number1);
        editText2 = (EditText) findViewById(R.id.number2);
        textView = (TextView) findViewById(R.id.result_text);
        btn = (Button) findViewById(R.id.sum_button);
        onAdd();
    }

    private void onAdd() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1 = Integer.parseInt(editText1.getText().toString());
                int number2 = Integer.parseInt(editText2.getText().toString());
                int result = number1 + number2;
                textView.setText(Integer.toString(result));
            }
        });
    }
}

