package com.example.stuar.timerapptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NewEvent extends AppCompatActivity {

    TextView editTextEventName, editTextEventDistance, editTextEventLocation;
    Spinner spinnerEventType;
    Button btnNewEventOk, btnNewEventCancel;

    String eventName, eventLocation, eventType, eventDistance;

    String[] eventDetails = new String[4];

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);

        //Get UI elements
        editTextEventName = findViewById(R.id.textViewEventName);
        editTextEventDistance = findViewById(R.id.textViewEventDistance);
        editTextEventLocation = findViewById(R.id.textViewEventLocation);
        btnNewEventOk = findViewById(R.id.btnNewEventOk);
        btnNewEventCancel = findViewById(R.id.btnNewEventCancel);

        spinnerEventType = findViewById(R.id.spinnerEventType);
        String[] items = new String[]{"Out and Back", "Point to Point"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinnerEventType.setAdapter(adapter);

        btnNewEventOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editTextEventName = (EditText) findViewById(R.id.editTextEventName);
                eventName = editTextEventName.getText().toString();

                editTextEventLocation = (EditText) findViewById(R.id.editTextEventLocation);
                eventLocation = editTextEventLocation.getText().toString();

                editTextEventDistance = (EditText) findViewById(R.id.editTextEventDistance);
                eventDistance = editTextEventDistance.getText().toString();

                eventType = spinnerEventType.getSelectedItem().toString();

                eventDetails[0] = eventName;
                eventDetails[1] = eventDistance;
                eventDetails[2] = eventType;
                eventDetails[3] = eventLocation;




            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();

    }
}
