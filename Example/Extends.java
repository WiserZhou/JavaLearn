package Example;

public class Extends extends dateLearn {

  private String day;

  public Extends(String day) {}

  @Override
  public void hello() {
    this.day = "1";
    System.out.println("hello2");
    super.hello();
  }

  public static void main(String[] args) {
    Extends ex = new Extends("hello");
    System.out.println(ex.getClass());
    System.out.println(ex.toString());
    System.out.println(ex instanceof dateLearn);
    ex.hello();
  }
}

class Animal {
  public void makeSound() {
    System.out.println("Animal makes a sound");
  }
}

class Dog extends Animal {
  @Override
  public void makeSound() {
    System.out.println("Dog barks");
  }

  public void fetch() {
    System.out.println("Dog fetches a ball");
  }
}

class Cat extends Animal {
  @Override
  public void makeSound() {
    System.out.println("Cat meows");
  }

  public void scratch() {
    System.out.println("Cat scratches");
  }
}

/**
 * 虽然用子类的构造方法创造了一个新的子类对象，并将其赋值给父类对象，但是实际 赋值成功 的只有子类和父类共同都有的类型 和方法空间，对于父类没有的则没有赋值。
 *
 * <p>当将父类对象转化为子类对象时，同时也会为此对象添加他本身没有的而在子类中多出来的属性和方法。
 */
class Main {
  public static void main(String[] args) {
    Animal animal1 = new Dog(); // animal1称为多态变量
    Animal animal2 = new Cat();

    animal1.makeSound(); // 输出：Dog barks
    animal2.makeSound(); // 输出：Cat meows

    // 下面两行代码会产生编译错误，因为Animal类型的引用无法调用子类特有的方法
    // animal1.fetch();
    // animal2.scratch();

    // 将Animal类型的引用转换为Dog类型，然后调用fetch方法
    if (animal1 instanceof Dog) {
      Dog dog = (Dog) animal1;
      dog.fetch(); // 输出：Dog fetches a ball
    }

    // 将Animal类型的引用转换为Cat类型，然后调用scratch方法
    if (animal2 instanceof Cat) {
      Cat cat = (Cat) animal2;
      cat.scratch(); // 输出：Cat scratches
    }

    Animal animal;
    boolean condition = false;
    if (condition) {
      animal = new Dog();
    } else {
      animal = new Cat();
    }
    /** 这个过程称为动态绑定 */
    animal.makeSound(); // 在运行时决定调用哪个实现类的方法
  }
}
