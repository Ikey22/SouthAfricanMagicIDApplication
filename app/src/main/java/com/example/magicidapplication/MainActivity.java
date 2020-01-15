package com.example.magicidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etID;
    Button btnSubmit;
    TextView tvResults;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etID = findViewById(R.id.etID);
        tvResults = findViewById(R.id.tvResults);
        btnSubmit = findViewById(R.id.btnSubmit);

        tvResults.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String idNumber = etID.getText().toString().trim();

                String dob = idNumber.substring(0,6);

                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));

                String sGender;

                if (gender<5)
                    sGender = getString(R.string.female);
                else
                    sGender = getString(R.string.male);
                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));

                String snationality;

                if (nationality == 0)
                    snationality = getString(R.string.sacit);
                else
                    snationality = getString(R.string.permanent);

                String text = getString(R.string.dob) + dob + "\n" +
                        getString(R.string.gender) + sGender + "\n" +
                        getString(R.string.nationality) + snationality;

                tvResults.setText(text);

                tvResults.setVisibility(View.VISIBLE);
            }
        });



    }
}
