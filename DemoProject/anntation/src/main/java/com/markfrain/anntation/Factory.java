package com.markfrain.anntation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类名和MD中博客博主的项目一模一样是因为自己编写后发现无法build生成ShapeFactory。
 * 故照搬代码发现，是gradle版本问题。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface Factory {
    /**
     * Factory Name
     */
    Class type();

    String id();
}
