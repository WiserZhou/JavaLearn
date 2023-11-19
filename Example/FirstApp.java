package Example;

public class FirstApp {
  /**
   * @param args 命令行参数
   */
  public static void main(String[] args) {
    boolean flag = false;
    char a = '\t';
    byte b = 123;
    short c = 123;
    int d = 1222;
    long e = 1;
    float g = 123.2323f;
    double h = 23.2312;
    byte f = (byte) e;
    System.out.println("Hello World! " + Float.MAX_VALUE + "   " + Float.NaN);
  }

  public void show() {
    int x = Car.speed; // 在类中定义的静态变量是全局变量，可以被任何地方所共用。
    Date mybirth = new Date(), yourbirth = new Date();
    mybirth.day = 23;
    yourbirth.month = 2;
  }
}

class Date {
  int day;
  int month;
  int year;
}

class Car {
  int color;
  static int speed = 0;

  void brake() {}

  void speedUp() {
    speed += 20;
  }
}

abstract class Shape {
  int y;

  abstract void draw();

  Shape(int x) {
    y = x;
  }
}

abstract class Round extends Shape {

  Round(int x) {
    super(x);
  }

  final double pi = 3.1415;

  abstract void draw();

  abstract double area();
}

class Circle extends Round {

  Circle(int x) {
    super(x);
  }

  @Override
  void draw() {}

  @Override
  double area() {
    return 0;
  }
}
