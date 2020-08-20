# Java编程思想[https://github.com/LingCoder/OnJava8/blob/master/docs/book/01-What-is-an-Object.md]

#对象的概念

### 面向对象编程(Object Oriented Programming OOP).

是一种编码思维方式和编码架构。


### 抽象 (abstract)

所有编程语言都提供了抽象机制。问题的复杂度取决于抽象的类型和质量。
汇编语言是对底层机器的轻微抽象。
"命令式"语言(FORTRAN,BASIC,C)是对汇编语言的抽象。

### 对象(object)

机器模型-解决方案空间
问题模型-问题空间
我们将问题空间中的元素以及他们在解决方案空间的表示称为"对象"。

### 类（class/type）

将一群对象抽象化就形成了一类。例如:人类,女人,男人,程序员,建筑设计师。


### 面向对象程序设计方法

1.万物皆对象。(Object)
2.程序是一组对象,通过(方法/Method)消息传递来告知彼此该做什么。
3.每个对象都有自己的存储空间,可以容纳其他对象。(局部变量,封装,继承,多态)
4.每个对象都有一种类型。每个对象都是某个"类"的一个"实例"(类和对象的关系。例如:人类和个体的关系)
5.同一个类所有对象都能接收相同的消息。(可替换性/多态)


一个对象具有自己的状态,行为和标识。即变量/参数,方法,内存地址。


----

### 接口(interface)

规定某些对面能做特定的请求,有哪些行为。这时候就可以为这个类规定它接口的形式。例如如下代码

```java

	public interface Car{
        void run();
        int speed();
    }
    public class Buick implements Car{
        @Override
        public void run() {
            System.out.print(speed());
        }

        @Override
        public int speed() {
            return 0;
        }
    }

```

### 服务

软件设计的基本原则是高内聚:每个组件的内部作用明确,功能紧密。

### 封装

#### 访问修饰符 用于限制方法/变量/类的访问权限等级

1.public (公开) 任何人都能可以访问和实用钙元素

2.private (私有) 除了类本身和类内部的方法,外界无法直接访问该元素

3.protected (受保护) 子类可以访问，但是除开子类的其他外界不能访问该元素。

4.default(默认) 包访问，即该资源可以被同一个包下的其他类的成员访问。


### 复用

复用:减少重新创建新的类来满足一些具有重复的功能。
组合: 一个类的对象作为另一个类的成员变量。如账号类中具有金额这个对象

聚合: 动态的组合。我理解为是:将组合好的类重新根据需求在进行组合为新的类。

### 继承

原始类(基类,超类,父类)。Object类就是java中所有类的基类。
子类(继承类)。继承与父类的类叫子类。子列具备父类的属性/成员变量,方法/行为,但子类也可以和父类表现不一致,即派生/扩展类中的方法/属性。

### 多态

多态即父类派生出子类后呈现的不确定性。面对对象的程序设计语言是通过"动态绑定"的方式来实现对象的多态性的。


### 单继承结构 Object基类

Java是单继承结构的编程语言。单继承的结构使得垃圾收集器的实现更为容易。


### 集合

Java标准库提供的集合类
Array 数组
Collection 集合
List  序列 ArrayList查找元素很搞笑,LinkedList随机查找效率低下，而LinkedList插入元素效率比ArrayList高。
Map 关联数组
Set 保存非重复值
Queue 队列
Tree 树
Stack 栈
Heap 堆

### 泛型

Java 5 之前所有的类型在集合中会向上转型橙Object,从而丢失自己原有的类型特性。Java 5支持了参数化类型机制,即泛型(Generic),使得编辑器能自动识别某个`class`的具体类型并正确执行。

### 对象创建与生命周期

Java使用动态内存分配。每次创建对象时，都是用`new`关键字构建该对象的动态实例。

### 异常处理

异常(Exception) 是一个从出错点抛出(thrown) 后背特定类型的异常程序捕获(catch)的一个对象。

-----


## 万物皆对象

### 对象操纵

Java中操纵对象实质是对对象的"引用"。

### 对象创建 

"引用"用于关联"对象"。在java中,通常我们使用`new`来创建一个新的对象。`new`关键字代表:创建一个新的对象实例。

### 数据存储

程序在运行时，内存分为5个地方来存储数据

1.寄存器(Registers)。位于CPU内部

2.栈内存(Stack)存在于常规内存RAM(随机访问存储器,Random Acess Memory)。通过栈指针获得处理器的直接支持，上移释放内存，下移分配内存。栈内存上存在一些Java数据(如对象引用),但Java对象本身的数据却是存在堆内存的。

3.堆内存(Heap)通用内存池，也在RAM中。`new`一个对象后将在堆中为这个对象分配内存。

4.常量存储(Constant storage) 常量值通常直接放在程序代码中。如需严格保护可以放在ROM(Read Only Memory)中。

5.非RAM存储(Non-RAM storage) 

例如:序列化对象，对象转换成字节流，发送到其他机器，持久化对象:对象呗防止在磁盘上，比如你下的电影放在F盘,你的电脑系统停止了。电影依然存在F盘。
即将存储方式转到非RAM存储介质上，并在需要时回复为RAM的对象。

### 基础类型的存储

boolean、char、byte、short、int、long、float、double、void。

### 高精度数值

BigInteger和BigDecimal用于高精度的计算。

### 数组的存储

当我们创建对象数组时,只是创建了一个引用数组。在使用数组之前，我们必须为每个引用指定一个对象。

```java
	public static void main(String[] args) {
		String[] str=new String[2];
		str[0]="1";
		str[1]="2";
	}
```

### 代码注释

```java
/*
* 多行注释
*/

//单行注释
```

### 对象清理

#### 作用域

作用域决定了该范围内变量名的可见性和生命周期。`{}`通常决定作用域的位置。

```java
	{
		int x=12;
		{
			int q=32;//x和q都可见可用
			int x=48;//重复声明x，报错
		}
		//q不在此作用域中不可见也不可用
	}
```


#### 对象作用域

```java
	{
		String str=new String("test String");
	}
	//作用域终点

```
引用s在作用域终点结束了，但是s指向的字符串对象依然还在占用内存。

Java的垃圾收集器会检查对象是否不可达(可达性分析算法)，从而释放呗占用的内存，防止内存泄漏。


### 类的创建

#### 类型

```java
class TestName{
	//类的内部
}
public static void main(String[] args) {
	TestName testName=new TestName();

}
```

#### 字段(Field,属性/成员变量)

类的字段可以是基本类型,也可以是引用类型(其他对象).

```java
	class TestName{
		int i;
		doube d;
		boolean b;
		TestSub sub;
	}
	class TestSub{
		int test;
	}

	public static void main(String[] args) {
		testName.testSub.test=100;//修改对象内部另一个对象的数据。这里需要把对象内的另一个对象初始化。
	}
```

#### 基础类型默认值

|--|--|
|基础类型|初始值|
|boolean|false|
|char|\u0000(null)|
|byte|(byte)0|
|short|(short)0|
|int|0|
|long|0L|
|float|0.0f|
|double|0.0d|

自定义对象的初始值都是null。需要自己手动new然后赋值给引用。

注意:默认值的赋予只在类的字段中才会提现。在代码块中
```java
{	
	int x;//这里不会初始化为0，编辑器将提示你为x初始化一个值
}
```

#### 方法使用

java中，一个方法决定对象能接收哪些消息。方法由 方法名称、 方法参数、返回类型、方法体构成。方法还包含访问修饰符，用于定义方法的生命周期和访问权限。
方法名和参数列表统称为方法签名。方法签名是方法的唯一标识。

```java
//[访问修饰符][关键字][返回类型][方法名](方法参数列表)
	public    static void    main(String[] args) {
		//方法体
		math(1,2);
	}
//[访问修饰符][关键字][返回类型][方法名](方法参数列表)
	protected static int 	math(int num1,int num2){
		return num1+num2;//方法体
	}
```

类中的方法只能被，这个类的实例/对象调用,且这个对象/实例 必须有权限才能执行这个方法。

```java
	//[引用/实例/对象].[方法名](参数1，参数2，参数3)
	testName.testMethod(testFiled1,testFiled2,testFiled3);

	//没有参数的方法,只有返回类型的方法则可以这样写
	int num=testName.math();

```

##### 参数列表

参数列表规定方法接收的参数的类型，如果传递的参数类型与方法定义中的不匹配，则编译器将报错。


### 程序编写

#### 命名可见性

Java的作者希望我们反向使用自己的网络域名。例如markfrain.com。那么我的utils类库命名为com.markfrain.www.untils。反向域名后,`.`用来代表子目录的划分。即包名。

#### 使用其他组件

`import` 关键字告诉编译器我们需要导入的包是哪一个。

```java
	import java.utils.ArrayList;
	import java.utils.*//当使用* 通配符时，则是导入util下所有的类。
	//上面这句话声明之后，我们将可以在当前.java文件中使用标准库util下的ArrayList类了
	public static void main(String[] args) {
		//like this
		ArrayList list=new ArrayList();
	}
```

#### static关键字

static用于弥补对象的方法/字段不能够直接被外界调用的问题。

static可以用于修饰字段和方法。

```java
	class TestName{
		static int i=47;
	}
	public static void main(String[] args) {
		TestName name1=new TestName();
		TestName name2=new TestName();
		TestName.i++;
		System.out.print(name1.i);
		System.out.print(name2.i);
		//打印结果name1和name2的i都是48
		//由于static修饰了i,i的值不管在哪个对象中都是出于共用的情况
	}

```

### 编码风格

驼峰命名法。类名首字母大写。字段/方法名首字母小写

```java
	class TestClass{
		int testClassFiled;
		void testClassMethod(int testParam){
			//....
		}

		//...
	}

```


