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
        String colorName = intent.getStringExtra("color"); //if it's a string you stored.
        int color = intent.getIntExtra("c", 1);

        findViewById(R.id.CanvasActivity).setBackgroundColor(color);
        TextView tv = (TextView) findViewById(R.id.colorTextView);
        tv.setText(colorName);
    }
}
