# 1
下列哪个是 JDK 提供的编译器____B_____。
A. java.exe B. javac.exe C. javap.exe D. javaw.exe

- A. java.exe - 该命令用于运行Java应用程序。
- B. javac.exe。JDK（Java Development Kit）提供了javac.exe作为Java源代码的编译器。
通过运行javac命令，可以将Java源代码文件编译成字节码文件，以便在Java虚拟机上运行。
- C. javap.exe - 该命令用于反编译class文件，以查看类的详细信息。
- D. javaw.exe - 该命令也用于运行Java应用程序，通常用于GUI程序，它会在没有控制台窗口的情况下运行Java应用程序。

##### 样例
A. java.exe:
```
java HelloWorld
```
这将运行名为HelloWorld的Java应用程序。

B. javac.exe:
```
javac HelloWorld.java
```
这将编译名为HelloWorld.java的Java源文件。

C. javap.exe:
```
javap -c HelloWorld
```
这将反编译名为HelloWorld的class文件，并显示它的字节码。

D. javaw.exe:
```
javaw HelloWorld
```
这将以无控制台窗口的方式运行名为HelloWorld的Java应用程序，通常用于GUI程序。

简单来说，就是javac将编写的java代码编译成类的源文件，java运行此文件执行，javap可以将源文件反编译，
而javaw可以在运行时不创建控制台。



# 2
下面哪个是用 Java 编写的以 Web 服务器为容器的服务器端程序____C_____。
A. Java 应用程序 B. Applet C. Servlet D. Javabean

Servlet是用Java编写的服务器端程序，通常以Web服务器为容器。它们能够接收来自客户端（通常是Web浏览器）的请求，并生成响应。Servlet通常通过HTTP协议与客户端进行通信，因此它们广泛用于开发基于Web的应用程序。

Servlet程序运行在Servlet容器中，这个容器负责管理Servlet的生命周期、线程安全性和其他方面的细节。常见的Servlet容器包括Tomcat、Jetty和GlassFish等。在客户端发送请求时，Servlet容器会调用适当的Servlet来处理请求并生成响应，然后将响应返回给客户端。

相对而言：
A. Java 应用程序通常是独立的应用程序，不依赖于Web服务器。
B. Applet是嵌入到网页中的小型Java程序，用于在客户端执行，但由于安全性和性能问题，已经逐渐被废弃。
D. Javabean是一种可重用的Java组件，通常用于构建用户界面。它们通常不直接用作服务器端程序。


当提及Applet和JavaBean时，以下是它们的基本使用示例：

Applet使用示例：
```java
import java.applet.Applet;
import java.awt.Graphics;

public class HelloWorldApplet extends Applet {
    public void paint(Graphics g) {
        g.drawString("Hello, World!", 20, 20);
    }
}
```
在HTML页面中，可以通过以下方式嵌入Applet：
```html
<applet code="HelloWorldApplet.class" width="200" height="60">
</applet>
```

JavaBean使用示例：
```java
public class PersonBean {
    private String name;
    private int age;

    // 必须有无参构造方法
    public PersonBean() {
    }

    // 属性访问方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
```
在其他Java类中可以使用JavaBean：
```java
public class Main {
    public static void main(String[] args) {
        PersonBean person = new PersonBean();
        person.setName("Alice");
        person.setAge(25);
        System.out.println(person.getName() + " is " + person.getAge() + " years old.");
    }
}
```

需要注意的是，随着技术的发展，Applet已经逐渐被废弃，而JavaBean则更多地被用于构建企业级应用程序中的组件。


JavaBean是一种可重用的软件组件，它是用Java编写的类，遵循特定的约定，可以在各种Java开发环境中使用。JavaBean通常用于构建可视化用户界面（如Swing）或企业级Java应用程序。

JavaBean的特点包括：
1. 遵循特定约定：JavaBean类必须遵循特定的命名约定和方法签名，以便在各种开发工具中进行识别和操作。
2. 可重用性：JavaBean被设计为可重用的组件，可以在不同的应用程序中使用，从而提高代码的复用性和可维护性。
3. 封装性：JavaBean通过封装数据和行为来实现对成员变量的访问控制，提供了更好的安全性和灵活性。
4. 事件支持：JavaBean可以通过事件机制来向外部组件通知自身状态的变化，从而实现与其他组件的交互。
5. 序列化支持：JavaBean可以被序列化为字节流，以便在网络上传输或永久存储。

通常，一个JavaBean类具有以下特征：
- 公共的无参构造方法
- 私有的成员变量
- 公共的getter和setter方法用于对成员变量的访问和修改

JavaBean广泛应用于图形用户界面开发、企业级应用程序开发以及Web开发中，例如在JSP页面中使用JavaBean来处理业务逻辑。


# 3
如果 JDK 安装的路径为“c\java”，若想在命令窗口中任何当前路径下都可以
直接使用 java 命令，需要将环境变量 path 设置为_____B____。
A. c:\java B. c:\java\bin C. c:\jre\bin D. c:\java\lib

JDK（Java开发工具包）安装目录通常包含以下几个重要的子目录：

1. **bin目录**：包含了许多关键的可执行文件，比如java、javac等。这些文件是用于编译、运行Java程序的工具。

2. **jre目录**：Java运行时环境（JRE）的根目录。它包含了JRE的各种文件，包括库文件、支持文件和JRE可执行文件。

3. **lib目录**：包含了Java标准库和其他扩展库的JAR文件。这些库文件对于Java程序的开发和运行非常重要。

4. **include目录**：包含了用于本地方法开发（如使用JNI）所需的头文件。

5. **src.zip文件**：这是JDK的源代码压缩包，其中包含了Java标准库的源代码。这对于学习和调试非常有用。

这些目录和文件共同构成了JDK的核心内容，使得开发人员能够编写、编译和运行Java程序。在配置环境变量时，通常需要将bin目录添加到系统的环境变量path中，以便系统可以在任何路径下找到并执行Java相关的命令。

# 4
下面哪个语句会引起编译错误_____C_____。
A. int a=10; B. short b=2; C. float c=10.5; D. double d=12.8;


**java中带小数点的数值默认为double型，想要赋值float必须在后面加上f，例如10.5f**

# 5
.下面哪个是最早的面向对象语言___D_______。
A. C++ B. Smalltalk C. Java D. Simula 67

当谈到C++、Smalltalk、Java和Simula 67时，我们可以简要地描述它们的特点和发展历程：

1. **C++**：
    - C++是一种通用编程语言，是C语言的扩展。它在C语言的基础上增加了面向对象编程（OOP）的特性，比如类和对象。
    - C++支持面向对象编程、泛型编程和过程式编程，具有高效性和灵活性。
    - C++由Bjarne Stroustrup在1983年首次发布，目前被广泛应用于系统软件、游戏开发、嵌入式系统等领域。

2. **Smalltalk**：
    - Smalltalk是一种纯粹的面向对象编程语言，一切皆为对象。它具有强大的动态特性，支持灵活的对象交互和动态类型。
    - Smalltalk最早由Alan Kay、Adele Goldberg等人在1970s开发，并于1972年首次发布。它对后来的面向对象语言产生了深远影响。

3. **Java**：
    - Java是一种跨平台的面向对象编程语言，被设计用于具有高度移植性的应用程序开发。
    - Java最初由Sun Microsystems开发，1995年首次发布。它吸收了C++的许多概念，并添加了自动内存管理和垃圾回收等功能。
    - Java在客户端应用、企业软件、移动应用和大型系统中都有广泛应用。

4. **Simula 67**：
    - Simula 67被认为是第一个面向对象编程语言，它引入了类、对象、继承、多态等概念。
    - Simula最早由Ole-Johan Dahl和Kristen Nygaard在1960s开发，被视为面向对象编程的奠基之作。其影响深远，影响了后来的面向对象编程语言的设计和发展。

这四种语言各自具有独特的特点和发展历史，对计算机编程和软件开发产生了深远影响。

# 6
下面哪个不是类之间的关系____A_______。
A. 实例化 B. 关联 C. 继承 D. 依赖


正确答案是 A. 实例化。实例化并不是类之间的关系，而是创建一个类的实例，也就是根据类创建一个对象。关联、继承和依赖是类之间常见的关系：

- **关联**：表示两个类之间有某种连接，其中一个类的对象可以使用另一个类的对象。
- **继承**：表示一个类可以从另一个类继承属性和行为，子类可以重用父类的特性。
- **依赖**：表示一个类需要另一个类的协助，通常表现为一个类作为参数传递给另一个类的方法。

因此，实例化并不是类之间的关系，而是创建对象的过程。


当谈论类之间的关系时，我们可以通过具体的例子来说明不同的关系。

1. **关联**：
    - 一个学校（School）类和一个教师（Teacher）类之间可能存在关联关系。教师对象可能属于某个学校，因此在学校类中可能会有一个教师对象的列表，表示学校和教师之间的关联关系。

2. **继承**：
    - 一个动物（Animal）类和一个猫（Cat）类之间可能存在继承关系。猫类可以继承动物类的属性和行为，比如动物类有“呼吸”和“移动”方法，而猫类可以继承这些方法并且添加自己的特有行为，比如“发出喵喵声”。

3. **依赖**：
    - 一个订单（Order）类可能依赖于一个支付方式（Payment）类。在订单类中可能有一个接受支付的方法，这个方法需要使用支付方式类的对象来完成订单支付，因此订单类依赖于支付方式类。

这些例子可以帮助理解类之间的关系以及这些关系在实际编程中的应用。

# 7
在以下什么情况下，构造方法会被调用_____B_______。
A. 类定义时 B. 创建对象时
C. 调用对象方法时 D. 使用对象的变量时


没啥好说的，选B

# 8
8.在 Outer 类中定义一个非静态成员类 Inner，需要在 main()方法中创建 Inner 类
实例对象，以下四种方式哪一种是正确的______A_____。

A. Inner in = new Inner();

B. Inner in = new Outer.Inner();

C. Outer.Inner in = new Outer.Inner();

D. Outer.Inner in = new Outer().new.Inner();

四种子类：
https://www.joshua317.com/article/212
接口：
https://javabetter.cn/oo/interface.html#_01%E3%80%81%E5%AE%9A%E4%B9%89%E6%8E%A5%E5%8F%A3


## 成员内部类:
相当于成员变量
```java
class Outer { // 外部类
private String name;

public static void main(String[] args) {
Outer outerObj = new Outer("joshua317");
Outer.Inner inner = outerObj.new Inner();
inner.InnerFun1();
}

public Outer(String name) {
this.name = name;
}

public void OuterFun1() {
System.out.println("外部类成员方法");
}

class Inner { // 内部类
public void InnerFun1() {
System.out.println(name);
}
}
}

```
在 Java 中，内部类实例化的语法是通过外部类的对象调用 `new` 关键字来创建内部类的对象。这是因为内部类对象与外部类对象有着密切的关联，内部类需要一个外部类的实例作为上下文来存在。

当你使用 `outerObj.new Inner()` 这样的语法时，你其实是告诉编译器要创建外部类 `Outer` 的内部类 `Inner` 的一个新实例，并且这个实例将会和 `outerObj` 相关联。

这种语法反映了内部类的特殊性：它依赖于外部类的实例存在，并且内部类实例始终会隐式地持有一个指向外部类实例的引用。因此，在实例化内部类的时候，需要通过外部类的实例来做到这一点。

当成员内部类拥有和外部类同名的成员变量或者方法时，会根据就近原则，即默认情况下访问的是成员内部类的成员。如果要访问外部类的同名成员，需要以下面的形式进行访问：

外部类.this.成员变量
外部类.this.成员方法

## 局部内部类
相当于局部变量

局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内。

局部内部类语法格式：

```java


  public class Outer {//外部类

  public void OuterFun1() {
  System.out.println("外部类成员方法");
  class Inner {//局部内部类

       }
  }
  }
```

## 匿名内部类

https://www.cnblogs.com/nerxious/archive/2013/01/25/2876489.html

```java
public class Outer { // 外部类

  public static void main(String[] args) {

    /**
     * 底层会分配一个类名Outer$1,去实现Inner接口 class Outer$1 implements Inner { @Override public void
     * innerFun1() { System.out.println("实现接口Inner，匿名内部类方法innerFun1()"); } }
     */
    Inner inner =
        new Inner() {
          @Override
          public void innerFun1() {
            System.out.println("实现接口Inner，匿名内部类方法innerFun1()");
          }
        };
    System.out.println(inner);
    inner.innerFun1();
    // 只有在匿名内部类这里可以将接口直接实例化
    /**
     * 底层会分配一个类名Outer$2，去继承InnerClass class Outer$1 extends InnerClass { @Override public void
     * innerFun1() { System.out.println("匿名类继承了 InnerClass 类，匿名内部类方法innerFun1()"); } }
     */
    Inner inner2 =
        new InnerClass() {
          @Override
          public void innerFun1() {
            System.out.println("匿名类继承了 InnerClass 类，匿名内部类方法innerFun1()");
          }
        };
    System.out.println(inner2);
    inner2.innerFun1();
  }
}

class InnerClass implements Inner {
  @Override
  public void innerFun1() {}
}

interface Inner {
  public void innerFun1();
}

```