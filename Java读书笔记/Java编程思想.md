# Java编程思想

[https://github.com/LingCoder/OnJava8/blob/master/docs/book/01-What-is-an-Object.md]

## 对象的概念

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

## 运算符

加法`+` 、减法`-`、乘法`*`、除法`/`、赋值`=`
所有运算符都能操作基础类型。唯一例外的是`=`、`==`、`!=`,它们能操作所有对象。[String]类支持`+`和`+=`。

### 优先级 

乘除在加减之前完成。

### 赋值

运算符的赋值由`=`完成的。基础类型的赋值是直接的，而对于对象来说，赋值只是对内存的引用赋值。

### 对象传递和返回

当你将引用传递给方法时,它仍指向同一个对象。

```java
	
	class Tank{
		char c;
	}

	public class Test{
		static void f(Tank tk){
			tk.c='z';
		}
		public static void main(String[] args) {
			Tank tank=new Tank();
			tank.c='a';
			System.out.println('1.c='+tank.c)
			f(tank);
			System.out.println('2.c='+tank.c)
		}
	}

```
输出结果:

```java
1.c:a
2.c:z
```

### 算术运算符

加法`+` 、减法`-`、乘法`*`、除法`/`以及取模`%`

### 递增和递减

`++`、`--` 。通常有"前缀"和"后缀","前递增/递减"会执行运算再返回值。而"后递增/递减"会先返回值再执行运算。

### 关系运算符

`<`、`>`、`<=`、`>=`、不能用于基本类型boolean。
`==` 、`!=` 可用于所有基础类型。
关系运算符会产生一个布尔(boolean)结果来表示操作数质检的关系。如果关系为真,则结果为`true`,如果关系为假,则结果为`false`。

比较所有对象(不包含基础类型)是否相等使用`equals`。
`equals`默认比较对象的引用而非内容。自定义类的时候记得重写(Override)`equals`方法来满足自定义的对象比较需求。


### 逻辑运算符

 或`||`、 且`&&`、 非`!`。使用逻辑运算符后一样也会产生一个布尔(boolean)。

### 短路(short-circuiting)

逻辑运算符支持一种称为短路的现象。整个表达式会在运算到明确结果时就停止并返回结果,这意味着该逻辑表达式的后半部分不会被执行到。

```java

	public class ShortCircuit {

    static boolean test1(int val) {
        System.out.println("test1(" + val + ")");
        System.out.println("result: " + (val < 1));
        return val < 1;
    }

    static boolean test2(int val) {
        System.out.println("test2(" + val + ")");
        System.out.println("result: " + (val < 2));
        return val < 2;
    }

    static boolean test3(int val) {
        System.out.println("test3(" + val + ")");
        System.out.println("result: " + (val < 3));
        return val < 3;
    }

    public static void main(String[] args) {
        boolean b = test1(0) && test2(2) && test3(2);
        System.out.println("expression is " + b);
    }
}

```

输出结果

```java
	test1(0)
	result: true
	test2(2)
	result: false
	expression is false
```

示例代码中可以看出test2()方法已经返回false。此时出现短路现象，没必要在执行test3()方法了。所以，运用"短路"可以节省部分不必要的运算，从而提高程序潜在的性能。

### 字面值常量

Long类型 结尾使用大写`L`或小写`l`。但不推荐使用`l`容易与1混淆。
float类型 结尾使用大写的`F`或小写的`f`。
double类型 结尾使用大写的`D`或小写的`d`。
十六进制(以16位基数),适用于所有整形数据类型。由前导`0x`或`0X`表示，后跟0-9或a-f(大写或小写)。
八进制(以8为基础)由0-7之间的数字和前导`0`表示。
Java7引入了二进制，由前导`0b`或`0B`表示，它可以初始化所有的证书类型。

### 下划线

Java7中有一个深思熟虑的补充:我们可以在数字字面量中包含下划线`_`,以使得结果更清晰，对于大数值的显示很有用。

使用规则:
1.仅限单个`_`,不能多条相连。
2.数值的开头和结尾不允许出现`_`。
3.`F`、`D`、`L`的前后禁止出现`_`。
4.二进制前导`b`和十六进制`x`前后禁止出现`_`。


Java用`%n`实现的可以忽略平台差异而生成恰当的换行符，但是在使用`System.out.printf()`或`System.out.format()`时，我们仍需使用`\n`。否则将打印出`%n`而不是换行符。


### 指数计数法

指数总是采用一种很不直观的记号方法.
```java
//"e"表示10的几次幂
	public class Exponents{
		//大写E和小写e的效果相同
		//1.39x10的-43次方
		//编译器通常会将指数作为double类型处理,假如没有后缀字符f,编辑器就会提示我们将double型转换成float型。
		float expFloat=1.39e-43f;
		expFloat=1.39E-43f;
		System.out.println(expFloat);
	}

```

### 位运算

位运算允许我们操作一个整形数字中的单个二进制位。

### 移位运算符

移位运算符面向的运算对象也是二进制的"位"。只能处理整数类型。
左移位运算符`<<` 能将其左边的运算对象向左移动右侧指定的位数(在低位补0)。
右移位运算符`>>` 则相反。
右位移运算符有"正"、"负"值:若值为正，则在高位插入0；若值为负，则在高位插入1.
Java也添加了一种"不分正负"的右移位运算符`>>>`,它使用了"零扩展"(zero extension):无论正负，都在高位插入0.

### 三元运算符(三目运算)

三元运算符，也称为条件运算符。

布尔表达式?值1:值2

### 字符串运算符

`+`与传统`+`不符，用于连接字符串

### 类型转换(Casting)

在适当的时候，Java会将一种数据类型自动转换成另一种.我们也可以在代码中显示的进行强制转换。

```java
	
	public static void main(String[] args) {
		  float num=100;
		  int i=200;
		  long lng=(long)i;
	}
	//除开布尔类型的数据，Java允许任何基本类型的数据转换为另一种基本数据类型的数据。

```

### 截断和舍入

float double在转为整数值时，小数位将被截断。若你想对接过进行四舍五入，可以使用`java.lang.Math`的`round()`方法。


### 类型提升

在我们对小于int的基础数据类型（即char、byte或者short）执行任何算术或者按位操作，这些值会在执行操作之前类型提升为int,并且计算结果值的类型也为int。
通常:表达式中最大的数据类型是决定表达式结果的数据类型。

#### Java没有sizeOf

#### boolean值不允许加减等运算。只能进行赋值和判断。


## 控制流


```java
	
	 public static void main(String[] args) {
        int i = 0;
        //while语句会在每次循环前，判断布尔表达式是否为true
        while (i >= 0) {
            i++;
        }
        //do-while
        //即使条件表达式为false。do-while语句也会至少执行一次。
        do {
            i++;
        } while (i >= 0);
    }

```

### 逗号操作符

在Java中逗号运算符仅用在for循环的初始化和步进控制中定义多个变量。注意:要求定义的变量类型相同。

```java

	public static void main(String[] args) {
        for (int i=1,j=i+10;i<5 ;i++,j=i*2 ) {
            System.out.println("i="+i+" j="+j);
        }
    }

```

### for-in 语法是增强版的for循环

### return 

1.指定一个非void方法的返回值。
2.退出当前方法，并返回作用1中的值。

### break和continue

break跳出当前循环体
continue标识停止本次循环开始下一次循环。

### switch

Java7 增加了字符串switch的用法


## 初始化和清理

Java中构造器名称与类名相同。方便记忆和调用。


### 区分重载方法

Java中如何区分重载方法？每个被重载的方法必须有独一无二的参数列表。

### 重载与基本类型

基本类型可以自动从较小的类型转型为较大的类型。即：小物品可以用大盒子装,而大物品无法装入小盒子里。如果强行装入则会需要强制转化类型，从而损失精度，这损失的精度就相当于 大物品装入了一部分到小盒子里。


### 无参构造器

编辑器将为类创建一个无参构造器。

### this关键字

this关键字只能在非静态方法内部使用。而在一个类的方法内调用该类的其他方法，可以不使用this，直接调用即可。this关键字只用在一些必须使用当前对象引用的特殊场合。

### 在构造器中调用构造器 

```java
	
	public class Flower{
		int count;
		Flower(){
			this(1);
		}
		Flower(int count){
			this.count=count;
		}
	}
	//只能通过this调用一次构造器。必须先调用构造器，否则编译器会报错

```

### static的含义

static方法中不会存在this。你不能在静态方法中调用非静态方法（反之可以）。静态方法是为类而创建的，不需要任何对象。


### 垃圾回收器

垃圾回收器 对于任意"活"的对象，一定能最终追溯到期存活在栈或静态存储区中的引用。这个引用链条可能传过数个对象层次,由此，如果从栈或静态存储区出发，遍历所有引用，你将会发现所有"活"的对象。对于发现的每个引用，必须追踪它所引用的对象，然后是该对象包含的所有引用，如此反复进行，知道访问完"根源于栈或静态存储区的引用"所形成的整个网络。
对于循环引用，这些对象不会被发现，所以会被回收。

惰性评估，意味着即时编译器只有在必要的时候才编译代码。这样，从未被执行的代码也许就压根不会被 JIT 编译。新版 JDK 中的 Java HotSpot 技术就采用了类似的做法，代码每被执行一次就优化一些，所以执行的次数越多，它的速度就越快。


### 可变参数列表

在每种情况下，编译器都会使用自动装箱来匹配重载的方法，然后调用最明确匹配的方法。


```java

	static void test(int... args){
        System.out.println(" length " + args.length)
	}
	public static void main(String[] args) {
		test(1,2,3,4,5);
	}
```

### 枚举类型 enum
在你创建enum时。编译器会自动添加一些有用的特性。如`toString()`,`ordinal()`某个特定enum常量的生命顺序。`static vlaues()`方法按照enum常量的声明顺序，生成这些常量值构成的数组。


## 封装

一件好的作品都要经过反复打磨才变得优秀。这就是重构的原动力。重构使得代码可读，易懂，易维护。


### 包的概念

保内包含一组类，它们被组织在一个单独的命名空间下。
package 和 import 这两个关键字将单一的全局命名空间分隔开，从而避免名称冲突。

### 访问权限修饰符

public,protected，private能控制它的修饰对象，如果不提供修饰符，就意味着"包访问权限"。

### 包访问权限

当前包中所有其他类都可以访问该成员。

protected继承访问权限


-----

## 复用 

### 初始化基类

当你创建派生类的对象时，它包含基类的子对象。Java自动在派生类构造函数中插入对基类构造函数的调用。
无参构造函数java将自动调用基类。而带参构造函数需要使用`super`主动调用基类的构造器。

### 委托

Java不支持委托。

### 保证适当的清理

手动按照创建的相反顺序执行特定类的所有清理工作。不要使用`finalize()`。

### 自我思考

在编写library时，可以private修饰变量。而protected来修饰set get方法。以便维护过程中，逻辑的修改。而常量等使用final定义避免被修改。

### final

一个被static和fianl同时修饰的属性只会占用一段不能改变的存储空间。

### 空白final

当定义了一个final属性，但没有初始化/赋值。必须在定义时/构造器中执行fianl的赋值操作。这使得技能保证一个类的每个对象fianl不同。也能保证这个属性的不变性。

### fianl方法

防止子类覆写改变方法的行为。

### fina和private
 
类中private修饰的方法都隐式地指定为fianl。因为不能访问，所以不能覆写它。

### fianl类

当说一个类是final，意味着它不能被继承。设计的时候希望这个类永远不需要改动，或者处于安全考虑不希望它有子类。

#### 如果把项目视作一个有机的，进化着的生命去培养，而不是视为像摩天大楼一样快速见效，就能获得更多的成功和更迅速的反馈。

----

## 多态

多态是面向对象编程语言中，继数据抽象和继承之外的第三个重要特性。

多态提供了另一个维度的接口与实现分离，以解耦做什么和怎么做。


### 方法调用绑定

将一个方法调用和一个方法主题关联起来称作绑定。

#### 动态绑定/运行时绑定

意味着运行时根据对象的类型进行绑定。

执行过程中会执行,aload和invokevirtual来实现动态绑定。

1. aload:将指定的引用类型本地变量推送至栈顶。

这个好理解，那就是将Animal推送至栈顶。

2. invokevirtual:用于调用对象的实例方法。

这个就是关键了，虚拟机会根据实际类型进行转换。

那么，转换的过程是什么样的呢？

当虚拟机创建Dog类的时候，会创建一个类的方法列表，同时包含父类的方法列表。

同时虚拟机会参数引用的实际地址，找到创建的这个Dog对象，查询方法列表，如果在Dog对象中找到这个方法，就直接调用。

如果没找到，就去查询父类方法，调用父类的方法。


#### 陷阱："重写"私有方法

只有非private方法才能被重写。`@Override`注解可以检测出重写private方法的问题。

#### 构造器和多态

构造器的调用顺序如下
1.基类构造器被调用。这个步骤被递归地重复,这样一来类层次的顶级父类会被最先构造，然后是它的派生类，以次类推，知道最底层的派生类
2.按声明顺序初始化成员。
3.调用派生类构造器的方法体。

### 协变返回类型

Java 5 中引入了协变返回类型，这表示派生类的被重写方法可以返回基类方法返回类型的派生类型。

关键区别在于 Java 5 之前的版本强制要求被重写的 
process() 方法必须返回 Grain 而不是 Wheat，即使 Wheat 派生自 Grain，因而也应该是一种合法的返回类型。协变返回类型允许返回更具体的 Wheat 类型。

```java
	class Grain {
    @Override
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {
    @Override
    public String toString() {
        return "Wheat";
    }
}

class Mill {
    Grain process() {
        return new Grain();
    }
}

class WheatMill extends Mill {
    @Override
    Wheat process() {
        return new Wheat();
    }
}

public class CovariantReturn {
    public static void main(String[] args) {
        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);
        m = new WheatMill();
        g = m.process();
        System.out.println(g);
    }
}

```

### 使用继承设计

首先选择组合，组合更加灵活，而继承要求必须在编译是知道确切的类型。


### 总结

多态可能被滥用。仔细分析代码以确保多态确实能带来好处。

----


## 接口

### 抽象类和方法

包含抽象方法的类叫做抽象类。如果一个类包含一个或多个抽象方法，那么类本身也必须限定为抽象的。讲一个类指明为abstract并不强制所有的方法都是抽象方法。

```java
	abstract class Basic{
		abstract void f();
		public String what(){
			return "test info"
		}
	}
```

### 接口创建

Java 8之前interface中只允许有抽象方法。
Java 8之后允许接口包含默认方法和静态方法。

```java
	interface InterfaceDefault{
		void firstMethod();
		void secondMethod();
		
		default void defaultMethod(){
			System.out.println("defaultMethod");
		} 
	}
	public class Implemention implements InterfaceDefault{
		@Override
		public void firstMethod(){
			System.out.println("firstMethod");
		}
		@Override
		public void secondMethod(){
			System.out.println("secondMethod");
		}
		public static void main(String[] args) {
			InterfaceDefault i=new Implemention();
			i.firstMethod();
			i.secondMethod();
			i.defaultMethod();
		}
	}

	//输出结果
	//firstMethod
	//secondMethod
	//defaultMethod

```

竟然实现接口的类没有定义`defaultMethod()`,但仍然可以使用`defaultMethod()`。

这样可以保证不破坏已使用接口的代码的情况下，在接口中增加新的方法。默认方法有时也被称为守卫方法或虚拟拓展方法。


### 多继承

多继承意味着一个类可能从多个父类型中继承特征和特性。而Java不支持多继承

### 接口中的静态方法

Java 8允许在接口中添加静态方法。这么做能恰当地把工具功能置于接口中，从而操作接口，或者成为通用的工具。

```java
	public interface Operations{
		void execute();
		static void runOps(Operations...ops){
			for (Operations op:ops ) {
				op.execute();
			}
		}
	}

```


### 抽象类和接口

Java8引入default方法之后，选择用抽象类还是用接口变得更加令人困惑。下表做了明确的区分:

|--|--|--|
|特性|接口|抽象类|
|组合|新类可以组合多个接口|只能继承单一抽象类|
|状态|不能包含属性(除了静态属性,不支持对象状态)|必须在子类中实现抽象方法|
|默认方法和抽象方法|不需要在子类中实现默认方法。默认方法可以引用其他接口方法|必须在子类实现抽象方法|
|构造器|没有构造器|可以有构造器|
|可见性|隐式public|可以是protected或包访问|

总结:尽可能地抽象。因此更倾向使用接口而不是抽象类。

### 完全解耦

使用接口可以编写复用性更好的代码。

### 使用继承扩展接口

### 结合接口时的命名冲突

当打算组合接口时，在不同的接口中使用相同的方法名通常会造成代码可读性的混乱，尽量避免这种情况。

### 接口字段

接口中的字段都是自动为static和final的。所以接口就成为了创建一组常量的方便的工具。但是Java 5开始出现了enum。那么常量组就可以用enum来编写。

### 初始化接口中的字段

由于定义额字段不能为非fianl。则可以使用非常量表达式初始化。

```java
	public interface RandVals{
		Random RAND=new Random(47);
		int RANDOM_INT=RAND。nextInt(10);
	}
```

### 接口和工厂方法模式

```java

	interface Service{
		void method1();
	}
	interface ServiceFactory{
		Service getService();
	}

	class ServiceImp implements Service{
		@Override
		public void method1(){
			System.out.println("ServiceImp method1");
		}
	}

	public class Factories{
		public static void serviceConsumer(ServiceFactory fact){
			Service s=fact.getService();
			s.method1;

		}
		public static void main(String[] args) {
			serviceConsumer(new ServiceFactory());
		}
	}

```


### 本章小结

恰当的原则是优先使用类而不是接口。从类开始，如果使用接口的必要性变得很明确，那么就重构。接口是一个伟大的工具，但它们容易被滥用。

----

## 内部类

一个定义在另一个类中的类,叫做内部类。
内部类与组合是完全不同的概念。内部类可以与外部类进行通信(Java 8的Lambda表达式和方法引用减少了编写内部类的需求)。

### 创建内部类

```java

	OuterClassName.InnerClassName clazzName=new OuterClassName.InnerClassName();

	OuterClassName outClazz=new OuterClassName();

	OuterClassName.InnerClassName clazzName1=outClazz.new InnerClassName();

```

内部类的对象只能在与其外部类的对象相关联的情况下才能被创建。构建内部类对象时,需要一个指向其外部类对象的引用,如果编译器访问不到换个引用就会报错。


### 内部类与向上转型

private内部类给类的设计者提供了一种途径，通过这种方式可以完全阻止任何依赖于类型的编码,并且完全隐藏了实现的细节。

### 内部类方法和作用域

#### 局部内部类

```java
	public class Parcel5 {
	    public Destination destination(String s) {
	        final class PDestination implements Destination {
	            private String label;
	          
	            private PDestination(String whereTo) {
	                label = whereTo;
	            }
	          
	            @Override
	            public String readLabel() { return label; }
	        }
	        return new PDestination(s);
	    }
	  
	    public static void main(String[] args) {
	        Parcel5 p = new Parcel5();
	        Destination d = p.destination("Tasmania");
	    }
	}

```

#### 嵌套类

如果不需要内部类对象与外部类对象之间有联系，那么可以将内部类声明为static,这通常称为嵌套类。想要理解static应用于内部类时的含义,就必须记住,普通的内部类对象隐式第保存了一个引用，指向创建它的外部类对象。然而,当内部类是static时，就不是这样了。嵌套类意味着:

1.要创建嵌套类的对象,并不需要其外部类的对象。
2.不能从嵌套类的对象中访问非静态的外部类对象。

### 为什么需要内部类

每个内部类都能独立第继承自一个(接口的)实现，所以无论外部类是否已经继承了某个(接口的)实现，对于内部类都没有影响。

### 闭包与回调

内部类是面向对象的闭包，因为它不仅包含外部类对象(创建内部类的作用域)的信息，还自动拥有一个指向此外部类对象的引用，内部类有权操作所有的成员包含private成员。

Java8之前，内部类是实现闭包的唯一方式。Java8中，我们可以使用lambda表达式来实现闭包行为。

### 内部类可以被覆盖吗

内部类如果要覆盖必须完整继承所要覆盖的内部类。否则对于编译器来说即使你命名的是2个同名的内部类，但是编译后是完全2个独立的实体。

```java

class Egg2 {
    protected class Yolk {
        public Yolk() {
            System.out.println("Egg2.Yolk()");
        }
        public void f() {
            System.out.println("Egg2.Yolk.f()");
        }
    }
    private Yolk y = new Yolk();
    Egg2() { System.out.println("New Egg2()"); }
    public void insertYolk(Yolk yy) { y = yy; }
    public void g() { y.f(); }
}
public class BigEgg2 extends Egg2 {
    //继承后覆盖才能取代原有内部类
    public class Yolk extends Egg2.Yolk {
        public Yolk() {
            System.out.println("BigEgg2.Yolk()");
        }
        @Override
        public void f() {
            System.out.println("BigEgg2.Yolk.f()");
        }
    }
    public BigEgg2() { insertYolk(new Yolk()); }
    public static void main(String[] args) {
        Egg2 e2 = new BigEgg2();
        e2.g();
    }
}

```


### 局部内部类

在方法作用域内定义的内部类。


### 内部类标识符

内部类文件生产的.class文件。
这些类文件的命名有严格的规则：外部类的名字，加上“$"，再加上内部类的名字。例如，LocalInnerClass.java 生成的 .class 文件包括：

```java
interface Counter {
    int next();
}
public class LocalInnerClass {
    private int count = 0;
    Counter getCounter(final String name) {
        // A local inner class:
        class LocalCounter implements Counter {
            LocalCounter() {
                // Local inner class can have a constructor
                System.out.println("LocalCounter()");
            }
            @Override
            public int next() {
                System.out.print(name); // Access local final
                return count++;
            }
        }
        return new LocalCounter();
    }
    // Repeat, but with an anonymous inner class:
    Counter getCounter2(final String name) {
        return new Counter() {
            // Anonymous inner class cannot have a named
            // constructor, only an instance initializer:
            {
                System.out.println("Counter()");
            }
            @Override
            public int next() {
                System.out.print(name); // Access local final
                return count++;
            }
        };
    }
    public static void main(String[] args) {
        LocalInnerClass lic = new LocalInnerClass();
        Counter
                c1 = lic.getCounter("Local inner "),
                c2 = lic.getCounter2("Anonymous inner ");
        for(int i = 0; i < 5; i++)
            System.out.println(c1.next());
        for(int i = 0; i < 5; i++)
            System.out.println(c2.next());
    }
}

Counter.class//Counter interface
LocalInnerClass$1.class //getCounter2中的匿名内部类、这里叫1
LocalInnerClass$LocalCounter.class//局部方法内部类
LocalInnerClass.class//外部类
```

如果内部类是匿名的，编译器会简单地产生一个数字作为其标识符。如果内部类是嵌套在别的内部类之中，只需直接将它们的名字加在其外部类标识符与“$”的后面。


#### 个人总结

内部类可以用于不对外开放的类的实现。保证了代码的安全性。


----

## 集合

java.util库提供了一套相当完整的集合类来解决保存多个对象(对象的引用)的问题。其中基本的类型有List、Set、Queue、Map。这些类统称为容器类(Contanier classes)。

Set对于每个值只保存一个对象
Map是一个关联数组。


### 泛型和类型安全的集合

Java5之前的集合的一个主要问题是编译器允许你向集合中插入不正确的类型。
不过在之后，通过使用泛型，可以提前防止放一起将错误类型的对象放置到集合中。

指定类型未泛型参数时，也可以向上转型。

### 基本概念

Java集合类库采用"持有对象"的思想，分为2个不同的概念。

1.集合(Collection)
一个独立元素的序列，这些元素都服从一条或多条规则。List 必须以插入的顺序保存元素， Set 不能包含重复元素， Queue 按照排队规则来确定对象产生的顺序（通常与它们被插入的顺序相同）。

2.映射(Map)

 一组成对的“键值对”对象，允许使用键来查找值。 ArrayList 使用数字来查找对象，因此在某种意义上讲，它是将数字和对象关联在一起。 map 允许我们使用一个对象来查找另一个对象，它也被称作关联数组（associative array），因为它将对象和其它对象关联在一起；或者称作字典（dictionary），因为可以使用一个键对象来查找值对象，就像在字典中使用单词查找定义一样。 Map 是强大的编程工具。


 注意: 使用`Arrays.asList()`的输出作为一个List,这里的底层实现是数组，无法调整大小。所以生成的List无法调用`add()`或`remove()`。

### 列表List

 ArrayList:擅长随机访问元素,即存储和取值。内部是个数组维护着所有的数据。

 LinkedList:通过代价交底的在List中间进行的插入和删除操作，提供了优化的顺序访问。LinkedList对于随机访问来说相对比较慢。内部存在头尾2个node对象，node对象存储了头尾2个node对象，以次来链接所有的元素,查找则是将数据分为一半，根据索引遍历查找元素。

### 迭代器Iterators

 Interators只能调用`next()`向前移动。

### ListIterators

 ListIterators可以双向移动。`nextIndex()`,`previousIndex()`。

### 堆栈Stack

堆栈是"后进先出"(LIFO)集合。Java6 添加了ArrayDeque,其中包含直接实现堆栈功能的方法。

### 集合Set

Set不保存重复的元素。

HashSet对快速查找进行了优化。内部实质是HashMap维护数据。由于HashMap的key具备唯一性，所以HashSet可以存储不重复的元素。

TreeSet 将元素存储在红-黑树数据结构中.

 LinkedHashSet 因为查询速度的原因也使用了散列.本质是继承与HashSet.创建了一个LinkedHashMap存储元素。


### 映射Map

### 队列Queue

 队列是一个典型的"先进先出"（FIFO）。

 优先级队列PriorityQueue

 PriorityQueue 是允许重复的，最小的值具有最高的优先级（如果是 String ，空格也可以算作值，并且比字母的优先级高）。
 如果想在 PriorityQueue 中使用自己的类，则必须包含额外的功能以产生自然排序，或者必须提供自己的 Comparator 。

### 集合与迭代器

### for-in和迭代器

for-in适用于Collection对象。

### 适配器方法惯用法 --《Head First Java》



### 总结

1.List和数组都是有序集合

2.如果要执行大量的随机访问，则使用 ArrayList ，如果要经常从表中间插入或删除元素，则应该使用 LinkedList 。

3.不要在新代码中使用遗留类 Vector ，Hashtable 和 Stack 。

-----

## 函数式编程

函数式变成的意义:通过合并现有代码生成新功能而不是从头开始编写所有内容,我们可以更快的获得可靠的代码。

OO是抽象数据,FP是抽象行为。

Java 8的Lambda表达式，其参数和函数体被箭头`->`分隔开。箭头右侧是从Lambda返回的表达式。

Java8的方法引用，它以`::`为特征。`::`的左边是类或对象的名称,`::`的右边是方法的名称，但是没有参数列表。

### Lambda表达式

Lambda表达式是使最小可能语法编写的函数定义:
1.Lambda表达式产生函数，而不是类。 在 JVM（Java Virtual Machine，Java 虚拟机）上，一切都是一个类，因此在幕后执行各种操作使 Lambda 看起来像函数 —— 但作为程序员，你可以高兴地假装它们“只是函数”。

2.Lambda语法尽可能少，这正是为了使Lambda易于编写和实用。

```java
	interface Description{
		String brief();
	}
	interface Body{
		String detailed(String head);
	}
	interface Multi{
		String twoArg(String head,Double b);
	}

	public class LambdaExpressions{

		static Body bod=h->h+"No Parens";//[1]
		static Body bod2=(h)->h+"More details";//[2]
		static Description desc=()->"short info";//[3]
		static Multi mult=(h,n)->h+n;//[4]

		static Description moreLines=()->{
			System.out.println("moreLines()");
			return "from moreLines()";
		}

		public static void main(String[] args) {
			System.out.println(bod.detailed("Oh!"));
		    System.out.println(bod2.detailed("Hi!"));
		    System.out.println(desc.brief());
		    System.out.println(mult.twoArg("Pi! ", 3.14159));
		    System.out.println(moreLines.brief());
		}
	}

	//Lambda表达式的基本语法是：
	//1.参数
	//2.接着->,可以视为"产出"
	//3.->之后的内容都是方法体
	//[1]当只有一个参数可以不需要括号
	//[2]也可以用()包裹单个参数
	//[3]没有参数使用()代表空参数列表
	//[4]多个参数按照顺序放在()中。
	//[5]多行代码放在花括号中。这种情况下需要使用return.

```

### 递归

递归函数是一个自我调用的函数。

### 方法引用

方法引用组成:类名或对象名，后面跟`::`,然后跟方法名称。


### 未绑定的方法引用

未绑定的方法引用是指没有关联对象的普通(非静态)方法。使用未绑定的引用时，我们必须先提供对象.

### 构造函数引用



```java
class Dog {
  String name;
  int age = -1; // For "unknown"
  Dog() { name = "stray"; }
  Dog(String nm) { name = nm; }
  Dog(String nm, int yrs) { name = nm; age = yrs; }
}

interface MakeNoArgs {
  Dog make();
}

interface Make1Arg {
  Dog make(String nm);
}

interface Make2Args {
  Dog make(String nm, int age);
}

public class CtorReference {
  public static void main(String[] args) {
    MakeNoArgs mna = Dog::new; // [1]
    Make1Arg m1a = Dog::new;   // [2]
    Make2Args m2a = Dog::new;  // [3]

    Dog dn = mna.make();
    Dog d1 = m1a.make("Comet");
    Dog d2 = m2a.make("Ralph", 4);
  }
}
//[1][2][3]编译器将根据赋值的对象不同找到不同的构造函数来实现。

```

### 函数式接口

如果将方法引用或 Lambda 表达式赋值给函数式接口（类型需要匹配），Java 会适配你的赋值到目标接口。 编译器会在后台把方法引用或 Lambda 表达式包装进实现目标接口的类的实例中。


## TODO 

----

## TODO 流式编程

----

## 异常

### 抛出异常

```java
	if(t==null){
		throw new NullPointerException();
	}
```

### 异常捕获

```java

try{
	//code mit generate exceptions
}catch(Type1 tyde1){
	//handle exceptions of Type1
}catch(Type2 tyde2){
	//handle exceptions of Type2
}

```

### 自定义异常

继承于Exception类,命令与发生的异常意思相近或一致。

```java

class SimpleException extends Exception{
	SimpleException(){}
	SimpleException(String msg){
		super(msg);
	}
}

public class Test{
	public void test() throws SimpleException{
		System.out.println("SimpleException from test()");
		throw new SimpleException();
	}
	public static void main(String[] args) {
		Test test=new Test();
		try{
			test.test();
		}catch(SimpleException e){
			System.out.println("Caught it");
		}
	}
}

```

### 异常声明

编译时被强制检查的异常成为被检查的异常。
编译时异常。

### 栈轨迹

printStackTrace()方法提供的信息可以通过getStackTrace()方法来直接访问。

### 重新抛出异常

有时希望把刚捕获的异常重新抛出，尤其是在使用 Exception 捕获所有异常的时候。既然已经得到了对当前异常对象的引用，可以直接把它重新抛出：

```java
	catch(Exception e){
		throw e;
	}
```

重抛异常会把异常抛给上级环境中的异常处理程序。


### RuntimeException

1.无法预料的错误。比如引用为null.
2.作为程序员，应该在代码中进行检查的错误，比如数组越界ArrayIndexOutOfBoundsException。


### finally

```java

	try {
	// The guarded region: Dangerous activities
	// that might throw A, B, or C
	} catch(A a1) {
	// Handler for situation A
	} catch(B b1) {
	// Handler for situation B
	} catch(C c1) {
	// Handler for situation C
	} finally {
	// Activities that happen every time
	}
```

finnally可以把一些打开的资源进行关闭，比如文件流，网络连接等。


### 异常匹配

抛出异常时，异常处理系统会按照代码的书写顺序找出"最近"的处理程序。

### 异常指南

1.尽可能使用 try-with-resource。
2.在恰当的级别处理问题。（在知道该如何处理的情况下才捕获异常。）
3.解决问题并且重新调用产生异常的方法。
4.进行少许修补，然后绕过异常发生的地方继续执行。
5.用别的数据进行计算，以代替方法预计会返回的值。
6.把当前运行环境下能做的事情尽量做完，然后把相同的异常重抛到更高层。
7.把当前运行环境下能做的事情尽量做完，然后把不同的异常抛到更高层。
8.终止程序。
9.进行简化。（如果你的异常模式使问题变得太复杂，那用起来会非常痛苦也很烦人。）
10.让类库和程序更安全。（这既是在为调试做短期投资，也是在为程序的健壮性做长期投资。）

----

## 代码校验 TODO

----

## 文件

### 文件和目录路径

java.nio.file.Paths类包含一个重载方法static get(),该方法接受一系列String字符串或一个统一资源标识符(URI)作为参数,并且返回一个Path对象。


TODO Java NIO。

----

## 字符串

### 字符串的不可变

`String`对象是不可变的。String类中每一个看起来会修改Strin值的方法，实际上都是创建了一个全新的String对象，以包含修改后的字符串内容。

### +的重载与StringBuilder

String对象是不可变的,你可以给一个String对象添加任意别名。因为String是只读的，所有指向它的任何引用都不可能修改它的值。

操作符`+`可以用来连接String。

### 格式化输出

System.out.fomart()

### Formatter类

|--|--|
|类型|含义|
|d|整型(十进制)|
|c|Unicode字符|
|b|Boolean值|
|s|String|
|f|浮点数(十进制)|
|e|浮点型(科学计数)|
|x|整型(十六进制)|
|h|散列码|
|%|字面值"%"|

### String.format()

### 正则表达式

|--|--|
|表达式|含义|
|B|指定字符B|
|\xhh|十六进制值为0xhh的字符|
|\uhhhh|十六进制表现为0xhhhh的Unicode字符|
|\t|制表符Tab|
|\n|换行符|
|\r|回车|
|\f|换页|
|\e|转义|


|--|--|
|.|任意字符|
|[abc]|包含a、b或c的任何字符(和a|b|c作用相同)|
|[^abc]|除a、b和c之外的任何字符(否定)|
|[a-zA-z]|从a到z或从A到Z的任何字符(范围)|
|[abc[hij]]|a、b、c、h、i、j中的任意字符（与a|b|c|h|i|j作用相同）（合并）|
|[a-z&&[hij]]|任意h、i或j(交)|
|\s|空白符（空格、tab、换行、换页、回车）|
|\S|非空白符（[^\s]）|
|\d|数字([0-9])|
|\D|非数字[^0-9]|
|\w|词字符[a-zA-z_0-9]|
|\W|非词字符[^\w]|


## 类型信息

RTTI(RunTime Type Information 运行时类型信息)能够在程序运行时发现和使用类型信息。

Java是如何在运行时识别对象和类信息的。主要有2种方式:
1."传统的"RTTI: 假定我们在编译时已经知道了所有的类型

2."反射"机制:允许我们在运行时发现和使用类的信息

### 为什么需要RTTI

使用RTTI,我们可以查询某个Shape引用所指向对象的确切类型,然后选择或剔除特例。

### Class对象

类是程序的一部分,每个类都有一个Class对象。换言之，每当我们编写并且编译了一个新类，并会产生一个class对象。为了生成这个类的对象，Java虚拟机(JVM)先会调用ClasssLoader 子系统把这个类加载到内存中。

类加载器子系统可能包含一条类加载器链，但有且只有一个BootClassLoader,它是JVM实现的一部分。BootClassLoader加载的是"可信类"(包含Java API
类).它们通常从本地盘加载的。

所有的类都是第一次使用时动态加载到JVM中的，当程序创建第一个对类的静态成员的引用时，就会加载这个类。

Ps:其实构造器也是类的静态方法，虽然构造器前面并没有 static 关键字。所以，使用 new 操作符创建类的新对象，这个操作也算作对类的静态成员引用。


因此，Java 程序在它开始运行之前并没有被完全加载，很多部分是在需要时才会加载。

### 类字面常量

当使用`.class`来创建对Class对象的引用时,不会自动地初始化Class对象。为了使用类而做的准备工作实际包含三个步骤:

1.加载,这是由ClassLoader执行的。

2.链接。在链接阶段将验证类中的字节码吗,为`static`字段分配存储空间。

3.初始化。如果该类具有超类，则先初始化类，执行`static`初始化器和`static`初始化块。

so,直到第一次引用一个static方法(构造器隐式地是static)或者非常量的`static`字段,才会进行类初始化。


### 泛化的Class引用

### cast() 方法

### 类型转换检查

RTTI类型包括:

1.传统的类型转换,"(Shape)"。执行错误将抛出ClassCastException.

2.代表对象类型的Class对象，通过查询Class对象可以获取运行时所需的信息。

3.instance of

### 一个动态instanceOf函数

Class.isInstance() 方法提供了一种动态测试对象类型的方法。

### TODO 注册工厂

### 反射 运行时类信息

RTTI和反射的真正区别在于，使用RTTI时，编译器在编译时会打开并检查.class文件。通过反射，.class文件在编译时不可用。


### 动态代理

代理是基本的设计模式之一。

[Java 动态代理作用是什么？ - bravo1988的回答 - 知乎
https://www.zhihu.com/question/20794107/answer/658139129]

### Optional类

----

## 泛型 TODO

----

## 数组

数组是简单的线性序列，这使得对元素的访问变得非常快。

Arrays.deepToString() 方法同时适用于基元数组和对象数组：

数组拷贝 copyOf()和copyOfRange()。

并行排序 Java 8 parallelSort();


## 枚举

除了不能继承自一个 enum 之外，我们基本上可以将 enum 看作一个常规的类。也就是说我们可以向 enum 中添加方法。enum 甚至可以有 main() 方法。


所有的enum都继承自Java.lang.Enum类。

EnumMap是一种特殊的Map,它要求其中的键必须来自一个enum。

常量特定方法。Java 的 enum 有一个非常有趣的特性，即它允许程序员为 enum 实例编写方法，从而为每个 enum 实例赋予各自不同的行为。要实现常量相关的方法，你需要为 enum 定义一个或多个 abstract 方法，然后为每个 enum 实例实现该抽象方法。

----

## 注解

```java

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @inerface Test{}


```

### 元注解

|--|--|
|@Target|表示注解可以用于哪些地方。可能的 ElementType 参数包括：
CONSTRUCTOR：构造器的声明
FIELD：字段声明（包括 enum 实例）
LOCAL_VARIABLE：局部变量声明
METHOD：方法声明
PACKAGE：包声明
PARAMETER：参数声明
TYPE：类、接口（包括注解类型）或者 enum 声明|
|@Retention|表示注解信息保存的时长。可选的 RetentionPolicy 参数包括：
SOURCE：注解将被编译器丢弃
CLASS：注解在 class 文件中可用，但是会被 VM 丢弃。
RUNTIME：VM 将在运行期也保留注解，因此可以通过反射机制读取注解的信息。|
|@Documented|将此注解保存在 Javadoc 中|
|@Inherited|允许子类继承父类的注解|
|@Repeatable|允许一个注解可以被使用一次或者多次（Java 8）|


### 注解元素

注解元素可用的类型如下所示：

所有基本类型（int、float、boolean等）
String
Class
enum
Annotation
以上类型的数组


### 默认值限制

编译器对于元素的默认值有些过于挑剔。首先，元素不能有不确定的值。也就是说，元素要么有默认值，要么就在使用注解时提供元素的值。

任何非基本类型的元素，无论是在源代码声明时还是在注解接口中定义默认值时，都不能使用 null 作为其值。这个限制使得处理器很难表现一个元素的存在或者缺失的状态，因为在每个注解的声明中，所有的元素都存在，并且具有相应的值。为了绕开这个约束，可以自定义一些特殊的值，比如空字符串或者负数用于表达某个元素不存在。

### 注解不支持继承

----

## 并发编程

并发是关于正确有效地控制对共享资源的访问。

并行是使用额外的资源来更快的产生效果。

纯并发: 仍然在单个CPU上运行任务。纯并发系统比顺序系统更快地产生结果，但是它的运行速度不会因为处理器的增加而变得更快。

并发-并行：使用并发技术，结果程序可以利用更多处理器更快的产生结果。

并行-并发:使用并行编程技术编写，如果只有一个处理器，结果程序仍然可以运行

纯并行:除非有多个处理器，否则不会运行。


### 并发的新定义

并发性是一系列性能技术,专注于减少等待。


### 线程

每个任务都由一个执行线程来驱动，我们通常将其简称为线程。

### 资源竞争

当运行多个任务时，任何任务都可能同时读写 共享资源 。

### synchronized

### volatile

volatile 应该在何时适用于变量：

该变量同时被多个任务访问。
这些访问中至少有一个是写操作。
你尝试避免同步 （在现代 Java 中，你可以使用高级工具来避免进行同步）。


### 重排与 Happen-Before 原则

### 原子性

### 原子类 

Java 5 引入了专用的原子变量类，例如 AtomicInteger、AtomicLong、AtomicReference 等。这些提供了原子性升级。这些快速、无锁的操作，它们是利用了现代处理器上可用的机器级原子性。

### 临界区

有时，你只是想防止多线程访问方法中的部分代码，而不是整个方法。要隔离的代码部分称为临界区.

### 库组件

#### DelayQueue  延时队列

#### PriorityBlockingQueue 优先级队列


以下是并发编程的步骤:

1.不要使用它。想一些其他方法来使你写的程序变的更快。
2.如果你必须使用它，请使用在 并发编程 - parallel Streams and CompletableFutures 中展示的现代高级工具。
3.不要在任务间共享变量，在任务之间必须传递的任何信息都应该使用 Java.util.concurrent 库中的并发数据结构。
4.如果必须在任务之间共享变量，请使用 java.util.concurrent.atomic 里面其中一种类型，或在任何直接或间接访问这些变量的方法上应用 synchronized。 当你不这样做时，很容易被愚弄，以为你已经把所有东西都包括在内。 说真的，尝试使用步骤 3。
如果步骤 4 5.产生的结果太慢，你可以尝试使用volatile 或其他技术来调整代码，但是如果你正在阅读本书并认为你已经准备好尝试这些方法，那么你就超出了你的深度。 返回步骤＃1。


----

## 设计模式

### 单例模式











