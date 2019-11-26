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
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import static com.fju.water.R.string.fee;

public class MainActivity extends AppCompatActivity {
    private EditText edMonth;
    private EditText edNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edMonth = findViewById(R.id.month);
        edNext = findViewById(R.id.next);
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
