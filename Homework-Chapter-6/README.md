# 2021_Andriod_Studio/Homework-Chapter-6
#### 安卓应用开发实训作业6

学号：3190103050

姓名：陶禹升

#### 实现功能： 

- 使用文件存储和读取功能实现一个ToDoList应用

#### 亮点：

- 实现了编辑草稿的存储和加载

#### 笔记：

- 从inputstream中读取数据时，会用一个定长的byte数组来接受内容，但是在将其转化为string时要注意只将其有效内容的部分转化为string，不然会出现很多占位字符。
- 对于较小的数据，sp存储要比file存储代码简单的多。
