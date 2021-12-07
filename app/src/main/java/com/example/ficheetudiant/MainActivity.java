package com.example.ficheetudiant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText nom ;
    EditText email ;
    EditText dateNaissance ;
    //EditText classe ;
    ImageButton button ;
    Snackbar snackbar ;
    Spinner spinner ;
    LinearLayout mainlayout ;
    public static final String Extra_Message_Key="com.example.ficheetudiant.extra.message";
    public static final String Extra_Message_Key2="com.example.ficheetudiant.extra.message2";
    public static final String Extra_Message_Key3="com.example.ficheetudiant.extra.message3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nom=findViewById(R.id.nom);
        email=findViewById(R.id.email);
        dateNaissance=findViewById(R.id.dateNaissance);
        spinner=findViewById(R.id.classe);
        button=findViewById(R.id.btn_add);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.classe, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }
    public void ajouter(View v)
    {
        if (nom.getText().length()!=0 && email.getText().length()!=0 && dateNaissance.getText().length()!=0 )
        {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(MainActivity.this,Activity2.class);
                    intent.putExtra(Extra_Message_Key,nom.getText().toString());
                    intent.putExtra(Extra_Message_Key2,email.getText().toString());
                    intent.putExtra(Extra_Message_Key3,spinner.getSelectedItem().toString());
                    startActivity(intent);
                }
            });
        }
        else
        {
            Toast.makeText(MainActivity.this, "please try again!", Toast.LENGTH_LONG).show();
           // Snackbar.make(mainlayout,"Snack Bar !",Snackbar.LENGTH_LONG).show();
        }
}

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}