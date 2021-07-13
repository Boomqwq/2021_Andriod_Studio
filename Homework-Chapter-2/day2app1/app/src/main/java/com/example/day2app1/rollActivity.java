package com.example.day2app1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.day2app1.recycler.LinearDecoration;
import com.example.day2app1.recycler.MyAdapter;
import com.example.day2app1.recycler.TestData;
import com.example.day2app1.recycler.TestDataSet;

public class rollActivity extends AppCompatActivity implements MyAdapter.IOnItemClickListener{

    private RecyclerView myrecyclerView;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll);
        initView();
    }

    private void initView() {
        //获取实例
        myrecyclerView = findViewById(R.id.mainrecycler);
        //更改数据时不会变更宽高
        myrecyclerView.setHasFixedSize(true);
        //创建线性布局管理器
        layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        myrecyclerView.setLayoutManager(layoutManager);
        //创建Adapter
        myAdapter = new MyAdapter(TestDataSet.getData());
        //设置Adapter每个item的点击事件
        myAdapter.setOnItemClickListener(this);
        //设置Adapter
        myrecyclerView.setAdapter(myAdapter);
        //分割线
        myrecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //动画
        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setAddDuration(800);
        myrecyclerView.setItemAnimator(animator);
    }

    @Override
    public void onItemCLick(int position, TestData data) {
        Toast.makeText(this, "点击了第" + position + "条", Toast.LENGTH_SHORT).show();
        myAdapter.addData(position + 1, new TestData("新增头条", "0w"));
    }

    @Override
    public void onItemLongCLick(int position, TestData data) {
        Toast.makeText(this, "长按了第" + position + "条", Toast.LENGTH_SHORT).show();
        myAdapter.removeData(position);
    }
}
