package com.example.gjunintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultAcitvity extends AppCompatActivity {
    TextView tv10;
    Button btn4;
    private StringBuilder sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_acitvity);
        tv10 = findViewById(R.id.textView10);
        btn4 = findViewById(R.id.button4);
        Bundle bundle =  getIntent().getExtras();
        sb = new StringBuilder("BMI計算結果如下:\n");
        if(bundle != null){
            float h = Float.parseFloat(bundle.getString("h"));
            float w = Float.parseFloat(bundle.getString("w"));
            float bmi = w/(h/100*h/100);
            sb.append("身高:" + h +"公分\n");
            sb.append("體重:" + w +"公斤\n");
            sb.append("BMI:" + bmi +"\n");
            tv10.setText(sb);
        }
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("result", sb.toString());
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
