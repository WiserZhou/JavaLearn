package Experiment.Experiment2;
public class Test2 {
  public static void main(String[] args) {
    Triangle triangle = new Triangle(3, 4, 5);
    System.out.println(triangle.getPerimeter() + " " + triangle.getArea());

    Trapezoid trapezoid = new Trapezoid(2, 3, 4);
    System.out.println(trapezoid.getArea());

    Circle circle = new Circle(3);
    System.out.println(circle.getPerimeter() + " " + circle.getArea());
  }
}

class Triangle {
  double side1;
  double side2;
  double side3;
  double perimeter;
  double area;

  Triangle(double side1, double side2, double side3) {
    this.side1 = side1;
    this.side2 = side2;
    this.side3 = side3;
  }

  double getPerimeter() {
    this.perimeter = side1 + side2 + side3;
    return this.perimeter;
  }

  double getArea() {
    double p = getPerimeter() / 2;
    this.area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    return area;
  }

  void setSide1(double side1) {
    this.side1 = side1;
  }

  void setSide2(double side2) {
    this.side2 = side2;
  }

  void setSide3(double side3) {
    this.side3 = side3;
  }

  boolean isTriangle() {
    if (side1 + side2 <= side3) return false;
    else if (side2 + side3 <= side1) return false;
    else return !(side3 + side1 <= side2);
  }

  double getSide1() {
    return side1;
  }

  double getSide2() {
    return side2;
  }

  double getSide3() {
    return side3;
  }
}

/** Lander类具有类型为double的上底、下底、高、面积属性，具有返回面积的功能。 */
class Trapezoid {
  double topEdge;
  double bottomEdge;
  double height;
  double area;

  Trapezoid(double topEdge, double bottomEdge, double height) {
    this.topEdge = topEdge;
    this.bottomEdge = bottomEdge;
    this.height = height;
  }

  double getArea() {
    this.area = (topEdge + bottomEdge) * height / 2;
    return area;
  }
}

/* Circle类具有类型为double的半径、周长 * 和面积属性，具有返回周长、面积的功能。 */
class Circle {
  double radius;
  double perimeter;
  double area;

  Circle(double radius) {
    this.radius = radius;
  }

  double getPerimeter() {
    this.perimeter = 2 * Math.PI * radius;
    return perimeter;
  }

  double getArea() {
    this.area = Math.PI * radius * radius;
    return area;
  }
}
