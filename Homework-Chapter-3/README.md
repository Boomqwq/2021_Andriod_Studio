# 2021_Andriod_Studio/Homework-Chapter-3
#### 安卓应用开发实训作业3

学号：3190103050

姓名：陶禹升

#### 实现功能： 

##### 	CH3EX1：

- 使用Lottie库实现了一个加载动画，通过CheckBox控制动画是否自动播放，并在手动播放时通过SeekBar来控制动画的进度

##### 	CH3EX2:

- 对同一个实例实现了三种属性动画；体验了RainbowTextView类的使用

##### 	CH3EX3:

- 练习使用了ViewPager以及Fragment，复习了RecycleView的实现方法；完成了一个可以左右滑动的好友列表界面

#### 亮点：

- CH3EX1中，通过将playAnimation方法替换为resumeAnimation方法，实现了动画播放时会从当前状态继续播放的功能。如果使用playAnimation会导致每次播放时动画都会从头开始
- CH3EX1中，修改了SeekBar和CheckBox的初始状态，使动画播放模式与两者的状态能匹配

- CH3EX1中，通过LottieAnimationView下的getProgress函数获取了动画的播放进度，通过转换运算之后，使用SeekBar的setProgress方法将进度赋予SeekBar，使得进度条的值能与动画当前状态相匹配
- CH3EX2中实现了彩虹字体的显示，并理解了RainbowTextView的代码实现

#### 思考：

- CH3EX3中，发现在换页的时候有时需要加载动画有时却不需要加载。在请教老师后得知，这是由于ViewPage特有的预加载功能。会在浏览页面的同时预加载左右一定数量页面的内容。通过查询源码得知，这个预加载页面的数量由setOffscreenPageLimit方法来修改。但其最小值为1，即预加载左右各一个页面。如果想要去掉预加载功能，就需要重写ViewPager，将其中的DEFAULT_OFFSCREEN_PAGES常量改为0
