package com.example.umbrella_jaime;

import com.example.umbrella_jaime.Presenter.Presenter;
import com.example.umbrella_jaime.View.ViewContract;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ViewContract{

    private static final String TAG = "MainActivity";


    ImageButton imgButton;
    TextView place_label, temp_label;

    public static String Base_URL;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Initializing components from the layout
        place_label = findViewById(R.id.txtV_state);
        temp_label = findViewById(R.id.txtV_temperature);


        //Getting the URL to access the API
        Base_URL =getString(R.string.baseURL);

        Presenter presenter = new Presenter( this);
        presenter.initializeRetrofit();
        presenter.GetForecast();






        imgButton =  findViewById(R.id.Ibtn_settings_main);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsFragment.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public String getBaseURL() {
        return Base_URL;
    }


    @Override
    public void fillData(   String name, Double temperature ){

        place_label.setText(name);
        temp_label.setText(String.valueOf(temperature));


    }

    @Override
    public void showError(String errorMessage) {

        Toast.makeText(MainActivity.this, "UUUUU fail!!!", Toast.LENGTH_SHORT).show();
    }


}
