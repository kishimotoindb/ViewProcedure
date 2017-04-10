package com.example.cuihaichen.viewprocedure;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
 * 问题列表：
 * 1.问题1：父容器是wrap_content,子View是match_parent的情况下，子View的展示范围？ 布局文件见problem1.xml
 *   结论：此时子View的match-parent等同于wrap_content，TextView根据自身内容的大小确定自身的尺寸。
 *   原因分析：
 *      在ViewGroup的getChildMeasureSpec方法中，当父容器的MeasureSpec的mode为at_most时，子View的布局参数如果为
 *   match_parent，那么该方法得到的子View的MeasureSpec的mode是at_most.at_most模式下，onMeasure方法是根据控件
 *   的内容确定自身的大小。实际上此时子View填充了父容器，两者的大小相同。
 *      当前布局设置下，google是理解为按照子View实际大小处理。但道理上也可以理解为子View填充父容器可以使用的全部空间，
 *   父容器根据子View的match-parent，自己也适应为match-parent。
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.problem1);
    }
}
