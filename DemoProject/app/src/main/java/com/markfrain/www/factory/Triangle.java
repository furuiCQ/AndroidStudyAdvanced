package com.markfrain.www.factory;


import com.markfrain.anntation.Factory;
/**
 * 类名和MD中博客博主的项目一模一样是因为自己编写后发现无法build生成ShapeFactory。
 * 故照搬代码发现，是gradle版本问题。
 */
@Factory(id = "Triangle", type = Shape.class)
public class Triangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Draw a Triangle");
	}
}
