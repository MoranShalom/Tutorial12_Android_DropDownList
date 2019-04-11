package com.example.tutorial12_dropdownlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mySpinner=(Spinner) findViewById(R.id.spinner);


        //create arry adapter for the listview- must!!!
        ArrayAdapter<String> mAdapter= new ArrayAdapter<String>(MainActivity.this,
                 android.R.layout.simple_list_item_1,//- the title on the spinner on the toolbar will be the first item of the spinner
                // android.R.layout- this will color the text of the spinner on the toolbar in defult color- black
               // R.layout.custom_spinner_item, // this layout we just created is for the color white
                getResources().getStringArray(R.array.countries));

        mAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(mAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position ==1) // '0' will be the first item on the list, wich is the title of the spinner- 'Please select a value'
                    // so we dont want it to be a clicked itm so we start the if with '1'
                {
                        Toast.makeText(MainActivity.this,
                                "The selected item is:" + mySpinner.getSelectedItem().toString(),
                                Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));

                }else{
                    Toast.makeText(MainActivity.this,
                            "The selected item is:" + mySpinner.getSelectedItem().toString(),
                            Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


}
