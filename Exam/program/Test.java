package Exam.program;

public class Test {
  public static void main(String[] args) {
    Geometry geometry = new Circle(3);
    Geometry geometry1 = new Rectangle(2, 3);

    Pillar pillar = new Pillar(geometry, 2);
    System.out.println(pillar.getVolume());

    Pillar pillar1 = new Pillar(geometry1, 3);
    System.out.println(pillar1.getVolume());
  }
}

abstract class Geometry {
  public abstract double getArea();
}

class Pillar {
  private Geometry bottom;
  private double height;

  public double getVolume() {
    return bottom.getArea() * height;
  }

  Pillar(Geometry bottom, double height) {
    this.bottom = bottom;
    this.height = height;
  }
}

class Rectangle extends Geometry {

  private double height;
  private double width;

  @Override
  public double getArea() {
    return height * width;
  }

  Rectangle(double height, double width) {
    this.height = height;
    this.width = width;
  }
}

class Circle extends Geometry {

  private double radius;

  @Override
  public double getArea() {
    return radius * radius;
  }

  Circle(double radius) {
    this.radius = radius;
  }
}
