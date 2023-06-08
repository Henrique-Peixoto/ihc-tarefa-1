package com.example.atividade3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    EditText x_edit, y_edit, z_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        x_edit = findViewById(R.id.x_coord);
        y_edit = findViewById(R.id.y_coord);
        z_edit = findViewById(R.id.z_coord);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if (sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];

            x_edit.setText(Float.toString(sensorX));
            y_edit.setText(Float.toString(sensorY));
            z_edit.setText(Float.toString(sensorZ));

            if (sensorY > 7) {
                Intent i = new Intent(this, MainActivity2.class);
                i.putExtra("data", "Y > 7");
                startActivity(i);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        return;
    }
}