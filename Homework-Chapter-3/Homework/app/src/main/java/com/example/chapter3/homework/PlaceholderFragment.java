package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

public class PlaceholderFragment extends Fragment {

    private RecyclerView myrecyclerView;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private LottieAnimationView loading;
    private AnimatorSet animatorSet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件

        View view;
        view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        loading = view.findViewById(R.id.animation_view);
        //获取实例
        myrecyclerView=view.findViewById(R.id.main_recycler);
        initView();

        return view;
    }

    private void initView() {
        //更改数据时不会变更宽高
        myrecyclerView.setHasFixedSize(true);
        //创建线性布局管理器
        layoutManager = new LinearLayoutManager(getContext());
        //设置布局管理器
        myrecyclerView.setLayoutManager(layoutManager);
        //创建Adapter
        myAdapter = new MyAdapter(TextDataSet.getData());
        //设置Adapter
        myrecyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator animator = ObjectAnimator.ofFloat(loading,
                        "alpha",1,0);
                animator.setRepeatCount(0);
                animator.setDuration(1000);
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(myrecyclerView,
                        "alpha",0,1);
                animator1.setStartDelay(500);
                animator1.setRepeatCount(0);
                animator1.setDuration(1000);
                animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator1,animator);
                animatorSet.start();
            }
        }, 5000);
    }
}
