package com.markfrain.www.factory;


import com.markfrain.anntation.Factory;

@Factory(id = "Circle", type = Shape.class)
public class Circle implements Shape {  //  TypeElement

    private int i; //   VariableElement
    private Triangle triangle;  //  VariableElement

    public Circle() {
    } //    ExecuteableElement


    public void draw(   //  ExecuteableElement
                        String s)   //  VariableElement
    {
        System.out.println(s);
    }

    @Override
    public void draw() {    //  ExecuteableElement
        System.out.println("Draw a circle");
    }
}
