package com.markfrain.www.factory;


import com.markfrain.anntation.Factory;
/**
 * 类名和MD中博客博主的项目一模一样是因为自己编写后发现无法build生成ShapeFactory。
 * 故照搬代码发现，是gradle版本问题。
 */
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
