# 1

## 简述什么是抽象类和抽象方法。

抽象类是指不能被实例化的类，它只能作为其他类的父类来派生出子类。在Java中，使用关键字"abstract"来定义抽象类。抽象类可以包含抽象方法，也可以包含具体的方法实现。

抽象方法是指在抽象类中声明但没有具体实现的方法。在Java中，使用关键字"abstract"来定义抽象方法。抽象方法不包含方法体，它只有方法签名，而具体的实现则由继承该抽象类的子类来完成。**子类必须实现（重写）抽象类中的所有抽象方法，否则子类也必须声明为抽象类。**

让我们以动物为例来说明抽象类和抽象方法的概念。

首先，我们定义一个抽象类Animal：

```java
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 定义抽象方法
    public abstract void makeSound();
}
```

在这个例子中，Animal是一个抽象类，其中包含了一个抽象方法makeSound()。这个抽象方法表示动物发出声音的行为，但具体每种动物发出的声音是不同的，因此我们让这个方法成为抽象方法，具体的实现交给子类去完成。

接下来，我们可以创建几个具体的动物类来继承Animal类并实现makeSound()方法：

```java
public class Dog extends Animal {
  public Dog(String name) {
    super(name);
  }

  @Override
  public void makeSound() {
    System.out.println(getName() + "在汪汪叫");
  }
}

public class Cat extends Animal {
  public Cat(String name) {
    super(name);
  }

  @Override
  public void makeSound() {
    System.out.println(getName() + "在喵喵叫");
  }
}

```

在这里，Dog类和Cat类都继承自Animal类，并实现了makeSound()方法。每个子类根据自己的特性实现了发出声音的具体行为。

通过这个例子，我们可以看到抽象类和抽象方法的作用：抽象类Animal定义了一个模板，要求其子类必须实现makeSound()方法，从而确保了每个具体动物类都有自己特定的发声行为。


# 2
## 简述关联、依赖和继承关系的含义。

关联、依赖和继承是面向对象编程中常用的三种关系，它们描述了不同类之间的交互和联系方式。

1. 关联（Association）：关联表示两个类之间有联系，通常表现为一个类中包含对另一个类的引用。这种关系是一种拥有的关系，通常是一对多的关系。例如，学校和学生之间就存在一种关联关系，学校拥有多个学生。

2. 依赖（Dependency）：依赖表示一个类使用另一个类，但并不拥有对方。当一个类的方法中需要使用另一个类的对象作为参数、返回值或局部变量时，就存在依赖关系。依赖关系是一种临时性的关系，一个类的改变可能会影响到另一个类。例如，一个订单类可能依赖于一个支付类来完成支付操作。

3. 继承（Inheritance）：继承表示一个类（子类）从另一个类（父类）派生而来，并且继承了父类的属性和方法。子类可以扩展父类的功能，同时也可以重写父类的方法。继承是一种 "is-a" 关系，表示子类是父类的一种特例。例如，狗是动物的一种，所以可以使用继承来描述这种关系。

总之，关联表示拥有的关系，依赖表示临时性的使用关系，继承表示父子类之间的继承关系。在设计面向对象的系统时，正确理解和运用这些关系对于建立清晰的类之间的联系非常重要。

# 3
## 简述什么是终极类、终极方法和终极变量。

在面向对象编程中，"终极类"、"终极方法"和"终极变量"通常指的是不可被子类继承、重写或修改的类、方法和变量。

1. 终极类（Final Class）：终极类是指不能被其他类所继承的类。在Java等编程语言中，可以通过在类的定义前加上关键字 "final" 来将一个类声明为终极类。终极类的设计常用于那些不希望被继承或修改的类，例如一些工具类或者不需要被修改的核心类。

2. 终极方法（Final Method）：终极方法是指不能被子类重写或修改的方法。同样地，在Java等编程语言中，可以通过在方法的定义前加上关键字 "final" 来将一个方法声明为终极方法。这样做的目的是确保该方法的行为不会被子类改变，从而保持程序的稳定性和可靠性。

3. 终极变量（Final Variable）：终极变量是指只能被赋值一次且不能被修改的变量。在Java中，可以使用关键字 "final" 来声明一个终极变量。一旦被赋予初值，终极变量的数值将永远不会改变。

使用终极类、终极方法和终极变量可以帮助开发人员确保程序的稳定性，并防止意外的修改导致的错误。

# 4
## 简述采用实现 Runnable 接口创建线程的步骤。
当使用实现Runnable接口创建线程时，可以按照以下步骤：

1. 创建一个实现了Runnable接口的类，例如MyRunnable，其中包含run()方法来定义线程的执行逻辑。

```java
public class MyRunnable implements Runnable {
    public void run() {
        System.out.println("这是在新线程中执行的代码逻辑。");
    }
}
```

2. 实例化该实现类，创建一个Runnable对象。

```java
MyRunnable myrunnable = new MyRunnable();
```

3. 将MyRunnable对象作为参数传递给Thread类的构造函数，创建一个新的Thread对象。

```java
Thread thread = new Thread(myrunnable);
```

4. 最后，调用Thread对象的start()方法，启动线程。

```java
thread.start();
```

通过以上步骤，就可以成功地使用实现了Runnable接口的类创建并启动新的线程。这样做的好处是能够更好地组织代码，提高代码的可读性和可维护性。

简化方式，使用匿名内部类实现这个步骤的过程
```java
new Thread(new Runnable(){
    @Override
    public void run(){
        //````
    }
  }).start();
```


