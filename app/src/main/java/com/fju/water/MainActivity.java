package com.fju.water;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import static com.fju.water.R.string.fee;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText edMonth;
    private EditText edNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d(TAG , "onCreate");
        edMonth = findViewById(R.id.month);
        //edNext = findViewById(R.id.next);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate();
            }
        });



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //Spinner
        Spinner cities = findViewById(R.id.spinner);
        cities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, getResources().getStringArray(R.array.cities)[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG , "onRestart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG , "onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG , "onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG , "onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG , "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG , "onResume");
    }

    public void calculate () {
        if (!TextUtils.isEmpty(edMonth.getText().toString())){
            float degree = Float.parseFloat(edMonth.getText().toString());
            float fee = 0;
            if (degree < 11) {
                fee = 7.35f*degree;
            } else if (degree>11 && degree < 31) {
                fee = 9.45f*degree-21;
            } else if (degree>31 && degree <51) {
                fee = 11.55f*degree-84;
            } else {
                fee = 12.075f*degree-110.25f;
            }
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra(getString(R.string.extra_fee),fee);
            startActivity(intent);
        /*new AlertDialog.Builder(this)
                .setTitle("每月抄表費用")
                .setMessage("費用:" + fee)
                .setPositiveButton("ok",null)
                .show();*/
        }

        if (!TextUtils.isEmpty(edNext.getText().toString())) {
            float degree = Float.parseFloat(edNext.getText().toString());
            float fee = 0;
            if (degree < 21) {
                fee = 7.35f*degree;
            } else if (degree>21 && degree < 61) {
                fee = 9.45f*degree-42;
            } else if (degree>61 && degree <101) {
                fee = 11.55f*degree-168;
            } else {
                fee = 12.075f*degree-220.5f;
            }
                    /*new AlertDialog.Builder(this)
                            .setTitle("隔月抄表費用")
                            .setMessage("費用:" + fee)
                            .setPositiveButton(getString(R.string.ok),null)
                            .show();*/
        } /*if (TextUtils.isEmpty(edMonth.getText().toString())) {
        new AlertDialog.Builder(this)
                .setTitle("無法計算")
                .show();
        }*/
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
