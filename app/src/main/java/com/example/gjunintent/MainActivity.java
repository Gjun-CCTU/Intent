package com.example.gjunintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int REQUEST_CODE = 100;
    Button mainButton, btn2;
    EditText et1, et2, et3, et4, et5;
    TextView tv9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainButton = findViewById(R.id.button);
        et1 = findViewById(R.id.editText1);
        et2 = findViewById(R.id.editText2);
        et3 = findViewById(R.id.editText3);
        btn2 = findViewById(R.id.button3);
        et4 = findViewById(R.id.editText4);
        et5 = findViewById(R.id.editText5);
        tv9 = findViewById(R.id.textView9);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntentActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("chinese", et1.getText().toString());
                bundle.putString("english", et2.getText().toString());
                bundle.putString("math", et3.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultAcitvity.class);
                Bundle bundle = new Bundle();
                bundle.putString("h", et4.getText().toString());
                bundle.putString("w", et5.getText().toString());
                intent.putExtras(bundle);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
        Log.v("活動1", "1.onCreate()");

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case REQUEST_CODE:
                if(resultCode == RESULT_OK){
                    Bundle bundle =  data.getExtras();
                    String msg = bundle.getString("result");
                    tv9.setText(msg);
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("活動1", "3.onResume()");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("活動1", "6.onRestart()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("活動1", "7.onDestroy()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("活動1", "4.onPause()");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("活動1", "2.onStart()");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("活動1", "5.onStop()");

    }
}
