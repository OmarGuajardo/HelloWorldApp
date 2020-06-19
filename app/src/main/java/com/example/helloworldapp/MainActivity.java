package com.example.helloworldapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Spinner mySpinner = (Spinner)findViewById(R.id.spinner);
        final Button mainButton = (Button)findViewById(R.id.button);
        final EditText mainEditText = (EditText)findViewById(R.id.editText);
        final TextView mainTextView = (TextView)findViewById(R.id.textView);
        final TextView secondTextView = (TextView)findViewById(R.id.textView2);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
               android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.pre_sets) );

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);
        mySpinner.setOnItemSelectedListener(this);

        Toast.makeText(getApplicationContext(),"Welcome to my first FBU Application",Toast.LENGTH_LONG).show();

        findViewById(R.id.rootView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: reset to default settings

                mainTextView.setText("Hello from Omar!");
                mainButton.setBackground(getResources().getDrawable(R.drawable.preset_button_1));
                mainButton.setTextColor(getResources().getColor(R.color.colorPrimary));
                mainEditText.setTextColor(getResources().getColor(R.color.colorPrimary));
                mainTextView.setTextColor(getResources().getColor(R.color.colorPrimary));
                findViewById(R.id.rootView).setBackgroundColor(getResources().getColor(R.color.white));
                secondTextView.setTextColor(getResources().getColor(R.color.grey));
            }
        });

        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String new_text = mainEditText.getText().toString();
                if(TextUtils.isEmpty(new_text)){
                    mainTextView.setText("Hello From Omar!");
                }
                else{
                    mainTextView.setText(new_text);
                }
                mainEditText.setText("");
            }
        });


    }



    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String choice = adapterView.getItemAtPosition(i).toString();
        change_theme(choice);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void change_theme(String choice){
        Button mainButton = (Button)findViewById(R.id.button);
        EditText mainEditText = (EditText)findViewById(R.id.editText);
        TextView mainTextView = (TextView)findViewById(R.id.textView);
        TextView secondTextView = (TextView)findViewById(R.id.textView2);
        RelativeLayout rootView = findViewById(R.id.rootView);
        switch (choice){
            case "Preset 1":
                //changing button attributes
                mainButton.setBackground(getResources().getDrawable(R.drawable.preset_button_1));
                mainButton.setTextColor(getResources().getColor(R.color.colorPrimary));

                //changing edit text
                mainEditText.setTextColor(getResources().getColor(R.color.colorPrimary));
                mainTextView.setTextColor(getResources().getColor(R.color.colorPrimary));

                //changing text views
                secondTextView.setTextColor(getResources().getColor(R.color.grey));

                //changing overall background
                rootView.setBackgroundColor(getResources().getColor(R.color.white));
                break;
            case "Preset 2":

                //changing button attributes
                mainButton.setBackground(getResources().getDrawable(R.drawable.preset_button_2));
                mainButton.setTextColor(getResources().getColor(R.color.white));

                //changing edit text
                mainEditText.setTextColor(getResources().getColor(R.color.white));

                //changing text views
                mainTextView.setTextColor(getResources().getColor(R.color.white));
                secondTextView.setTextColor(getResources().getColor(R.color.white));

                //changing overall background
                rootView.setBackgroundColor(getResources().getColor(R.color.grey));
                break;
            case "Preset 3":

                //changing button attributes
                mainButton.setBackground(getResources().getDrawable(R.drawable.preset_button_3));
                mainButton.setTextColor(getResources().getColor(R.color.preset3PrimaryDark));

                //changing edit views
                mainEditText.setTextColor(getResources().getColor(R.color.preset3PrimaryDark));

                //changing text views
                mainTextView.setTextColor(getResources().getColor(R.color.preset3PrimaryDark));
                secondTextView.setTextColor(getResources().getColor(R.color.preset3PrimaryDark));
                //changing overall background
                rootView.setBackgroundColor(getResources().getColor(R.color.preset3Primary));
                break;
        }
    }

}
