package com.example.gjunintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class IntentActivity extends AppCompatActivity {
    Button intentButton;
    TextView tv6;
    float chinese, english, math;

    float avg;
    float sum;
    String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        intentButton = findViewById(R.id.button2);
        tv6 = findViewById(R.id.textView6);

        Bundle bundle =  getIntent().getExtras();
        chinese = Float.parseFloat(bundle.getString("chinese")) ;
        english = Float.parseFloat(bundle.getString("english")) ;
        math = Float.parseFloat(bundle.getString("math"));
        sum = chinese+english+math;
        avg = (chinese+english+math)/3;
        tv6.append("國文:" + chinese + "\n英文:" + english + "\n數學:" + math + "\n");
        tv6.append(String.format("總分:%.3f\n,平均:%.2f\n", sum, avg));

        intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        Log.v("活動2", "1.onCreate()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("活動2", "3.onResume()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("活動2", "6.onRestart()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("活動2", "7.onDestroy()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("活動2", "4.onPause()");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("活動2", "2.onStart()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("活動2", "5.onStop()");

    }
}
