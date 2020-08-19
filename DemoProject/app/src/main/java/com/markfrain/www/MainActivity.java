package com.markfrain.www;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.markfrain.www.factory.ShapeFactory;
/**
 * 类名和MD中博客博主的项目一模一样是因为自己编写后发现无法build生成ShapeFactory。
 * 故照搬代码发现，是gradle版本问题。
 * TODO * 高版本gradle版本无法build生产ShapeFactory原因 待考究
 */
public class MainActivity extends AppCompatActivity {
    ShapeFactory shapeFactory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
