package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity_lay);
        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("businessName").toString();
        TextView textView = findViewById(R.id.businessNName);
        textView.setText(name);
        Log.i(MainActivity.TAG, name);
        if (name.equals("GuitPro")) {
            TextView txtv = findViewById(R.id.businessStat);
            txtv.setText("Доход: 100млн Р");
        }
    }

    public void onClick1(View view){
        Intent intent = new Intent();
        intent.putExtra("BusinessN", "Компания успешна");
        setResult(RESULT_OK, intent);
        finish();
    }


}