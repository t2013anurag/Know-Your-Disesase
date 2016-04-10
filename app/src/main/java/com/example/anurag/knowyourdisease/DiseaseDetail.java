package com.example.anurag.knowyourdisease;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by anurag on 10/4/16.
 */
public class DiseaseDetail extends AppCompatActivity {
    private  final String LOG_TAG = DiseaseDetail.class.getSimpleName();
    private TextView fname;
    private TextView fage;
    private TextView fheight;
    private TextView fweight;
    private TextView fbmi;
    private TextView fdisease;
    private TextView fcause;
    private TextView fsymptoms;
    private TextView fcure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.disease_view);
        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("name");
        String age = bundle.getString("age");
        String height = bundle.getString("height");
        String weight = bundle.getString("weight");
        String bmi = bundle.getString("bmi");
        String disease = bundle.getString("disease");
        String cause = bundle.getString("cause");
        String symptoms = bundle.getString("symptoms");
        String cure = bundle.getString("cure");
        Log.d(LOG_TAG,"fields " + name+age+height+weight+bmi+disease+cause+symptoms+cure);

        fbmi = (TextView) findViewById(R.id.bmi);
        fbmi.setText(bmi);

        fcause = (TextView) findViewById(R.id.causes);
        fcause.setText(cause);

        fsymptoms = (TextView) findViewById(R.id.symptoms);
        fsymptoms.setText(symptoms);

        fcure = (TextView) findViewById(R.id.cure);
        fcure.setText(cure);

    }
}
