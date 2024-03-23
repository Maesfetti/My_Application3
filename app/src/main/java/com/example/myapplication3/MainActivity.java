package com.example.myapplication3;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = "Company";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_liner);
        /*TextView textView = findViewById(R.id.txtmen);
        textView.setText(getString(R.string.guitPro));

        ImageView imageView = findViewById(R.id.dollarwing);
        imageView.setImageResource(R.drawable.bitok);*/
        findViewById(R.id.buttonTransfer).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // передача объекта с ключом "businessName" и значением "GuitPro"
                //intent.putExtra("businessName", "GuitPro");
                //mStartForResult.launch(intent);
                intent.putExtra("businessName", "GuitPro");
                startActivity(intent);
            }
        });
        /*Button button = findViewById(R.id.buttonL);
        button.setOnClickListener(v -> {
            Log.i("ButtonClicked1", "Button Clicked prog!"); //программно
        });*/



    }

    public void decl(View view) {
        Log.d("buttclick2", "declarClicked");
    }


    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>(){

                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == AppCompatActivity.RESULT_OK){
                        Intent data = result.getData();
                        String returnedData = data.getStringExtra("BusinessN");
                        Log.i(TAG, "returned data from secondact: " + returnedData);
                    }
                    else {
                        Log.i(TAG, "не пришли данные");
                    }
                }
            }
    );

}