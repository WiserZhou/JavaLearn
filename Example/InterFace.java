package Example;

public class InterFace implements Shape2D {

  double radius;

  public InterFace(double r) {
    radius = r;
  }

  @Override
  public double area() {
    return pi * radius * radius;
  }
}

interface Shape2D {
  double pi = 3.14;

  double area();
}
