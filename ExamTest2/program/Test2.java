package ExamTest2.program;

public class Test2 {
  public static void main(String[] args) {
    Triangle triangle = new Triangle(3, 4, 5);
    if (triangle.isTriangle()) {
      System.out.println(
          "Triangle: sideA="
              + triangle.getSideA()
              + ", sideB="
              + triangle.getSideB()
              + ", sideC="
              + triangle.getSideC()
              + ", perimeter="
              + triangle.getPerimeter()
              + ", area="
              + triangle.getArea());
    } else {
      System.out.println("Invalid triangle!");
    }

    Trapezoid trapezoid = new Trapezoid(2, 4, 3);
    System.out.println(
        "Trapezoid: upperBase="
            + trapezoid.getUpperBase()
            + ", lowerBase="
            + trapezoid.getLowerBase()
            + ", height="
            + trapezoid.getHeight()
            + ", area="
            + trapezoid.getArea());

    Circle circle = new Circle(5);
    System.out.println(
        "Circle: radius="
            + circle.getRadius()
            + ", perimeter="
            + circle.getPerimeter()
            + ", area="
            + circle.getArea());
  }
}

class Circle {
  private final double radius;
  private double perimeter;
  private double area;

  public Circle(double radius) {
    this.radius = radius;
    calculatePerimeter();
    calculateArea();
  }

  public double getRadius() {
    return radius;
  }

  public double getPerimeter() {
    return perimeter;
  }

  public double getArea() {
    return area;
  }

  private void calculatePerimeter() {
    perimeter = 2 * Math.PI * radius;
  }

  private void calculateArea() {
    area = Math.PI * radius * radius;
  }
}

class Trapezoid {
  private final double upperBase; // 上底
  private final double lowerBase; // 下底
  private final double height; // 高
  private double area;

  public Trapezoid(double upperBase, double lowerBase, double height) {
    this.upperBase = upperBase;
    this.lowerBase = lowerBase;
    this.height = height;
    calculateArea();
  }

  public double getUpperBase() {
    return upperBase;
  }

  public double getLowerBase() {
    return lowerBase;
  }

  public double getHeight() {
    return height;
  }

  public double getArea() {
    return area;
  }

  private void calculateArea() {
    area = (upperBase + lowerBase) * height / 2;
  }
}

class Triangle {
  private final double sideA;
  private final double sideB;
  private final double sideC;
  private double perimeter;
  private double area;
  private final boolean isTriangle;

  public Triangle(double sideA, double sideB, double sideC) {
    this.sideA = sideA;
    this.sideB = sideB;
    this.sideC = sideC;
    this.isTriangle = checkTriangle(sideA, sideB, sideC);
    if (isTriangle) {
      calculatePerimeter();
      calculateArea();
    }
  }

  public double getSideA() {
    return sideA;
  }

  public double getSideB() {
    return sideB;
  }

  public double getSideC() {
    return sideC;
  }

  public double getPerimeter() {
    return perimeter;
  }

  public double getArea() {
    return area;
  }

  public boolean isTriangle() {
    return isTriangle;
  }

  private boolean checkTriangle(double a, double b, double c) {
    return a + b > c && b + c > a && c + a > b;
  }

  private void calculatePerimeter() {
    perimeter = sideA + sideB + sideC;
  }

  private void calculateArea() {
    double p = perimeter / 2;
    area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
  }
}
