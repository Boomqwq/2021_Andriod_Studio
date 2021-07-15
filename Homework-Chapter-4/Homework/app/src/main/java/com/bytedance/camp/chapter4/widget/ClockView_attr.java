package com.bytedance.camp.chapter4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;

import com.bytedance.camp.chapter4.R;

public class ClockView_attr{

    private int mRoundcolor;
    private int mHourcolor;
    private int mMinutecolor;
    private int mSecondcolor;

    public ClockView_attr(Context context){
        this(context,null);
    }

    public ClockView_attr(Context context,AttributeSet attrs){
        this(context,attrs,0);
    }

    public ClockView_attr(Context context, AttributeSet attrs, int defStyleAttr){
        TypedArray ta=context.obtainStyledAttributes(attrs, R.styleable.ClockView,defStyleAttr,0);
        mRoundcolor = ta.getColor(R.styleable.ClockView_round_color, Color.WHITE);
        mHourcolor = ta.getColor(R.styleable.ClockView_hour_color, Color.WHITE);
        mMinutecolor = ta.getColor(R.styleable.ClockView_minute_color, Color.WHITE);
        mSecondcolor = ta.getColor(R.styleable.ClockView_second_color, Color.WHITE);
        ta.recycle();
    }

    public void setmHourcolor(int mHourcolor) {
        this.mHourcolor = mHourcolor;
    }

    public void setmMinutecolor(int mMinutecolor) {
        this.mMinutecolor = mMinutecolor;
    }

    public void setmRoundcolor(int mRoundcolor) {
        this.mRoundcolor = mRoundcolor;
    }

    public void setmSecondcolor(int mSecondcolor) {
        this.mSecondcolor = mSecondcolor;
    }

    public int getmRoundcolor(){
        return mRoundcolor;
    }

    public int getmHourcolor() {
        return mHourcolor;
    }

    public int getmMinutecolor() {
        return mMinutecolor;
    }

    public int getmSecondcolor() {
        return mSecondcolor;
    }

}
