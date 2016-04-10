package com.example.anurag.knowyourdisease;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private  final String LOG_TAG = MainActivity.class.getSimpleName();
    private Spinner spinner;
    private EditText text_name;
    private EditText text_age;
    private EditText text_weight;
    private EditText text_height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        Button button = (Button) findViewById(R.id.button);
        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              spinner = (Spinner) findViewById(R.id.spinner1);
              String spinner_text = spinner.getSelectedItem().toString();
              Log.d(LOG_TAG, spinner_text);
              //Toast.makeText(MainActivity.this, spinner_text, Toast.LENGTH_SHORT).show();
              text_name = (EditText) findViewById(R.id.name);
              final String name = text_name.getText().toString();
              Log.d(LOG_TAG, name);

              text_age = (EditText) findViewById(R.id.age);
              final String age = text_age.getText().toString();
              Log.d(LOG_TAG, age);

              text_height = (EditText) findViewById(R.id.height);
              final String height = text_height.getText().toString();
              Log.d(LOG_TAG, height);

              text_weight = (EditText) findViewById(R.id.weight);
              final String weight = text_weight.getText().toString();
              Log.d(LOG_TAG, weight);

              Toast.makeText(MainActivity.this, name+age+height+weight+spinner_text, Toast.LENGTH_LONG).show();
          }
      });


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
