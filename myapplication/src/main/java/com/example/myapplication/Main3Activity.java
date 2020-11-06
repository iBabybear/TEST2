package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
    private final static String TAG ="Main3Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Main口","调用onCreate方法");



        Button normalBtn = findViewById(R.id.start_normal_activity);
        normalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent1 = new Intent(Main3Activity.this, NormalActivity.class);
                startActivity(intent1);*/
                Intent intent1 = new Intent(Main3Activity.this, NormalActivity.class);
               startActivityForResult(intent1,1);
            }
        });
        Button dialogBtn = findViewById(R.id.start_dialog_activity);
        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Main3Activity.this, DialogActivity.class);
                startActivity(intent2);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==1){
            if (resultCode ==RESULT_OK){
                String msg =data.getStringExtra("msg");
                Log.d(TAG,"msg="+ msg);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Main口","调用onStart方法");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Main口","调用onResume方法");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main口","调用onPause方法");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Main口","调用onRestart方法");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Main口","调用onStop方法");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Main口","调用onDestory方法");
    }


}
