package com.example.day2app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class PracticeActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        Log.i("TAG", "Practice_onCreate");
        initView();
    }

    private void initView() {
        findViewById(R.id.btn_back).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                Intent intent = new Intent(this, MyActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG", "Practice_onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG", "Practice_onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG", "Practice_onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG", "Practice_onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "Practice_onDestroy");
    }
}
