package com.example.anurag.knowyourdisease;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by anurag on 10/4/16.
 */
public class DiseaseDetail extends Activity {
    private  final String LOG_TAG = DiseaseDetail.class.getSimpleName();
    private TextView name;
    private TextView age;
    private TextView height;
    private TextView weight;
    private TextView bmi;
    private TextView disease;
    private TextView cause;
    private TextView symptoms;
    private TextView cure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    }
}
