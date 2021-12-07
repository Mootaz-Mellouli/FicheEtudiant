package com.example.ficheetudiant;

import static com.example.ficheetudiant.MainActivity.Extra_Message_Key;
import static com.example.ficheetudiant.MainActivity.Extra_Message_Key2;
import static com.example.ficheetudiant.MainActivity.Extra_Message_Key3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView textView ;
    TextView textView2 ;
    TextView textView3 ;
    Button button ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Intent intent = getIntent();
        String s = intent.getStringExtra(Extra_Message_Key);
        String s2 = intent.getStringExtra(Extra_Message_Key2);
        String s3 = intent.getStringExtra(Extra_Message_Key3);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView.setText(s);
        textView2.setText(s2);
        textView3.setText(s3);


    }
    public void share(View v )
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");

               // Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(sendIntent);


            }
        });
    }
}