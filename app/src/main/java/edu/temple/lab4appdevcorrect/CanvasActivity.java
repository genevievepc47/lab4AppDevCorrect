package edu.temple.lab4appdevcorrect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Intent intent = getIntent();
        String color = intent.getStringExtra("color"); //if it's a string you stored.

        findViewById(R.id.CanvasActivity).setBackgroundColor(Color.parseColor(color));
        TextView tv = (TextView) findViewById(R.id.colorTextView);
        tv.setText(color);
    }
}
