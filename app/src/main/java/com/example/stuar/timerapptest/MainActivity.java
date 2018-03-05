package com.example.stuar.timerapptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mtextViewWelcome, mtextViewWhatDeviceAreYou;
    Button mbtnFinishMain, mbtnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get UI elements
        mtextViewWelcome = findViewById(R.id.textViewWelcome);
        mtextViewWhatDeviceAreYou = findViewById(R.id.textViewWhatDeviceAreYou);
        mbtnFinishMain = findViewById(R.id.btnFinishMain);
        mbtnStart = findViewById(R.id.btnStartLine);


    }

    @Override
    protected void onStart()
    {
        super.onStart();

        mbtnFinishMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NewEvent.class));
            }
        });
    }
}
