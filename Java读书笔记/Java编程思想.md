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





