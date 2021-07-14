package com.example.chapter3.homework;

import java.util.ArrayList;
import java.util.List;

public class TextDataSet {
    public static List<TestData> getData()
    {
        List<TestData> hotlist = new ArrayList<>();
        hotlist.add(new TestData("葡萄", "转发[视频] 14：55"));
        hotlist.add(new TestData("White", "冲冲冲 13：40"));
        hotlist.add(new TestData("土豆", "在吗？ 13：20"));
        hotlist.add(new TestData("杨梅", "[捂脸笑] 13：20"));
        hotlist.add(new TestData("Black", "不是的 13：12"));
        hotlist.add(new TestData("杨桃", "[戳一戳] 13：00"));
        hotlist.add(new TestData("Red", "冲 12：50"));
        hotlist.add(new TestData("草莓", "我也是 12：49"));
        hotlist.add(new TestData("西瓜", "转发[聊天记录] 12：40"));
        hotlist.add(new TestData("Purple", "别想了 12：15"));
        hotlist.add(new TestData("Brown", "是的 12：00"));
        return hotlist;
    }
}
