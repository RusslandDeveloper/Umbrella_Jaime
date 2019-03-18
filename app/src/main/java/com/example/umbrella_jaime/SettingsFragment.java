package com.example.umbrella_jaime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;


public class SettingsFragment extends  AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private static final String TAG = "SettingsFragment";

    public static int value_zip;
    public static String value_metrics;
    ImageButton imgButton;

     EditText zipText;



    SharedPreferences preferences;

    public static String sharedPrefile = "com.example.umbrella_jaime",
            Key_zip = "Zip", Key_metric = "metrics";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_fragment);
        preferences = getSharedPreferences(sharedPrefile, MODE_PRIVATE);

        textLength();
        configButtons();
        StartPref();



    }


    private void textLength(){
        // Sets a limit of characters to the editText
        EditText editText = findViewById(R.id.txtE_zip);
        int maxlength = 5;
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxlength)});

    }

    private void configButtons(){
        imgButton = findViewById(R.id.Ibtn_settings_frag1);
        zipText = findViewById(R.id.txtE_zip);

        // Spinner adapter

        Spinner spinner = findViewById(R.id.measure_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.measure_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);


        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(zipText.getText().length() == 5 ) {
                    SavePref();

                    Intent intent = new Intent(SettingsFragment.this, MainActivity.class);
                    startActivity(intent);
                } else{

                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Set full zip code, please",
                            Toast.LENGTH_SHORT);
                    toast.show();

                }
            }
        });

    }


    private void SavePref(){


        int z = Integer.parseInt(zipText.getText().toString());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(Key_zip, z);
        editor.putString(Key_metric,value_metrics);
        editor.commit();


    }

    private void StartPref(){


        if(preferences.contains(Key_zip)){


           zipText.setText(Integer.toString(preferences.getInt(Key_zip,0)));
           value_zip = preferences.getInt(Key_zip,0);



        }
        if(preferences.contains(Key_metric)){
           // Incoming set preferences for the picker
            value_metrics =preferences.getString(Key_metric,"");
        }


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){

            case 0:
                value_metrics = "metric";
                break;

            case 1:
                value_metrics = "imperial";

                break;

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        value_metrics = "metric";
    }
}
