package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn_change);
        final TextView tv1 = findViewById(R.id.tv_text);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setText("好耶！");
                Log.d("Main", "change_textview1 ");
            }
        });

        EditText text1= findViewById(R.id.edit_text);
        text1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.d("Main", "beforeTextChanged_"+start+"_count_"+count+"_after_"+after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d("Main", "onTextChanged_"+start+"_count_"+count+"_before_"+before);
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.d("Main", "afterTextChanged");
            }
        });
        SeekBar seekbar1 = findViewById(R.id.seekbar_test);
        final TextView tv2 = findViewById(R.id.txt_cur);
        seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv2.setText("当前进度值: " + progress + "  / 100 ");
                Log.d("Main", "change_seekbar1_as_"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        RadioGroup rg = findViewById(R.id.rg_sex);
        final RadioButton rb_Male = findViewById(R.id.rb_Male);
        final RadioButton rb_Female = findViewById(R.id.rb_FeMale);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_FeMale:
                        // 当用户选择女性时
                        Log.i("Main", "chose_"+rb_Female.getText().toString());
                        break;
                    case R.id.rb_Male:
                        // 当用户选择男性时
                        Log.i("Main", "chose_"+rb_Male.getText().toString());
                        break;
                }
            }
        });
    }
}
