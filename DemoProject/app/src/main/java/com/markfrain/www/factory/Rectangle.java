package com.markfrain.www.factory;


import com.markfrain.anntation.Factory;

@Factory(id = "Rectangle", type = Shape.class)
public class Rectangle implements Shape {
	@Override
	public void draw() {
		System.out.println("Draw a Rectangle");
	}
}
