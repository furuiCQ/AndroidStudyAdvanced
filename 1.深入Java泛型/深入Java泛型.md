## 泛型的作用与定义

总结的很详细[https://blog.csdn.net/weixin_45258969/article/details/103461256]

泛型的定义:JDK1.5的一个新特性。Java中泛型只存在于源码中，编译后的字节码中已被替换为指定的原始类型(Raw Type),
对应一些地方加入了强制转换类型的代码。

泛型的作用:将JDK1.5之前的Object变量统一成阅读性较强的指定类型变量，减少了强转的代码,能实现编写期间的错误检查。
对于集合类来说尤其有用，常用场景如RxJava,MVP中自定义BaseActivity，BaseFragment。


泛型的适用范围: 类，方法，接口。

-------

## 通配符与嵌套

? 未知类型 当自定义的泛型的类型无法确定值和类型的时候使用【不能用于泛型方法，泛型类】

T K V E 等泛型字母 为 有类型，类型参数赋予具体的值。

例如:  
	<V extends BaseView> view  
	<P extends BasePresenter> presenter

    List<?> list = new ArrayList<Integer>();//未知类型创建对象时需指定类型

    List<? extend Fruit> list = new ArrayList<Fruit>();//extends表示为后面跟着的类的子类,<=的意思
 	
    List<? super Fruit> list = new ArrayList<Fruit>();//extends表示为后面跟着的类的父类或本身,>=的意思

 	


------

## 泛型上下边界 【规定了泛方法和泛容器的上下界】
	


例子:

`

    public class Fruit {

    }

    public class Apple extends Fruit {

    }

    public class RedApple extends Apple {

    }

    public void test(ArrayList<? extends Apple> list) {
        Fruit apple= list.get(0);
    }

 	public void test(List<? super Apple> list){
        list.add(new Object());
    }




`





1.上界`<? extends T>` 不能往里存，只能往外取
`<? extends Fruit> ` 会使往盘子里放东西的set( )方法失效 
编译器只知道容器内是Fruit或者它的派生类，但具体是什么类型不知道。

2.下界 `<? super T> `不影响往里存，但往外取只能放在Object对象里使用下界`<? super Fruit>`会使从盘子里取东西的get( )方法部分失效，
只能存放到Object对象里。set( )方法正常。因为下界规定了元素的最小粒度的下限，
实际上是放松了容器元素的类型控制。既然元素是Fruit的基类，
那往里存粒度比Fruit小的都可以。但往外读取元素就费劲了，只有所有类的基类Object对象才能装下。
但这样的话，元素的类型信息就全部丢失。

### PECS原则

1、频繁往外读取内容的，适合用上界Extends。

2、经常往里插入的，适合用下界Super。


-------



## RxJava中泛型的使用分析

笔者从RxJava的几个常用操作符出发讲解泛型的转换。

[https://zhuanlan.zhihu.com/p/97521402]


-------


## Json解析泛型与Bean强转原理实践

[待补充]*





