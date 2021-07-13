package com.example.day2app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Log.i("TAG", "Practice_onCreate");
        initView();
    }

    private void initView()
    {
        findViewById(R.id.btn_toast).setOnClickListener(this);
        findViewById(R.id.btn_practiceAct).setOnClickListener(this);
        findViewById(R.id.btn_baidu).setOnClickListener(this);
        findViewById(R.id.btn_phone).setOnClickListener(this);
        findViewById(R.id.btn_hot).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_toast:
                Toast.makeText(MyActivity.this,"click",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_practiceAct:
                Intent intent = new Intent(this, PracticeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_baidu:
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent1);
                break;
            case R.id.btn_phone:
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_DIAL);
                startActivity(intent2);
                break;
            case R.id.btn_hot:
                Intent intent3 = new Intent(this, rollActivity.class);
                startActivity(intent3);
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
