package com.example.atividade45;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private Sensor light;
    private Sensor proximity;
    TextView lightValue;
    TextView proximityValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightValue = (TextView) findViewById(R.id.light);
        proximityValue = (TextView) findViewById(R.id.proximity);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        light = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (light != null) {
            sensorManager.registerListener(MainActivity.this, light, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            lightValue.setText("Light sensor not supported");
        }

        proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if (proximity != null) {
            sensorManager.registerListener(MainActivity.this, proximity, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            proximityValue.setText("Proximity sensor not supported");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        if (sensor.getType() == Sensor.TYPE_LIGHT) {
            lightValue.setText("Light intensity: " + sensorEvent.values[0]);
        }

        if (sensor.getType() == Sensor.TYPE_PROXIMITY) {
            proximityValue.setText("Proximity: " + sensorEvent.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}