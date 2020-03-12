package edu.temple.lab4appdevcorrect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.OnFragmentInteractionListener {

    String[] colors = {"select a color", "red", "blue", "green", "gray", "cyan", "magenta", "yellow", "lightgray", "darkgray", "aqua", "fuchsia"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set up and send info to the palette fragment
        Bundle bundle = new Bundle();
        bundle.putStringArray("colorArray",colors);

        PaletteFragment paletteFragment = new PaletteFragment();
        paletteFragment.setArguments(bundle);


        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container1, paletteFragment)
                .commit();




        //Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);
        //mySpinner.setAdapter(new ColorAdapter(PaletteActivity.this, colors));

        //mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

          //  @Override
            //public void onItemSelected(AdapterView<?> parent, View view,
              //                         int position, long id) {
                /*
                if(colors[position] != "select a color")
                {
                    //change color of layout background
                    findViewById(R.id.PaletteActivity).setBackgroundColor(Color.parseColor(colors[position]));
                }


                //change color of selected text view to white
                TextView textView = (TextView)parent.getChildAt(0);
                textView.setBackgroundColor(Color.parseColor("white"));

                 */





            //}

            //@Override
            //public void onNothingSelected(AdapterView<?> parent) {

            //}
        //});





    }
    // The Activity handles receiving a message from one Fragment
    // and passing it on to the other Fragment
    @Override
    public void onFragmentInteraction(String color) {
        Bundle bundle = new Bundle();
        bundle.putString("color",color);

        CanvasFragment canvasFragment = new CanvasFragment();
        canvasFragment.setArguments(bundle);


        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container2, canvasFragment)
                .commit();
    }

}
