package edu.temple.lab4appdevcorrect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class PaletteActivity extends AppCompatActivity {

    int c[] = {Color.rgb(255,0,0), Color.rgb(0, 0, 255), Color.rgb(0, 255, 0), Color.rgb(128, 128, 128), Color.rgb(0, 255, 255), Color.rgb(255,0,255), Color.rgb(255,255,0), Color.rgb(211,211,211), Color.rgb(169,169,169), Color.rgb(0,255,255), Color.rgb(255,0,255) };
    String[] colors;
    //MAKE AN ARRAY OF THE COLOR CODES FOR THE COLORS, DISPLAY THE COLOR CODE, NOT THE PARSE COLOR


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        colors = res.getStringArray(R.array.colors_array);


        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);
        mySpinner.setAdapter(new ColorAdapter(PaletteActivity.this, colors));

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                if(colors[position] != colors[0])
                {
                    //change color of layout background
                    findViewById(R.id.PaletteActivity).setBackgroundColor(c[position-1]);
                }


                //change color of selected text view to white
                TextView textView = (TextView)parent.getChildAt(0);
                textView.setBackgroundColor(Color.rgb(255,255,255));


                if(colors[position] != colors[0])
                {
                    //launch the new activity and pass it data
                    Intent myIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    myIntent.putExtra("color", colors[position]); //Optional parameters
                    myIntent.putExtra("c", c[position-1]);
                    PaletteActivity.this.startActivity(myIntent);

                }




            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
