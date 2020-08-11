package com.markfrain.www.factory;


import com.markfrain.anntation.Factory;

@Factory(id = "Triangle", type = Shape.class)
public class Triangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Draw a Triangle");
	}
}
