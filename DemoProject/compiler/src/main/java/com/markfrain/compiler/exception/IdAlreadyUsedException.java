package com.markfrain.compiler.exception;


import com.markfrain.compiler.module.FactoryAnnotatedClass;
/**
 * 类名和MD中博客博主的项目一模一样是因为自己编写后发现无法build生成ShapeFactory。
 * 故照搬代码发现，是gradle版本问题。
 */
public class IdAlreadyUsedException extends RuntimeException {
    public IdAlreadyUsedException(FactoryAnnotatedClass factoryAnnotatedClass) {

    }
}
