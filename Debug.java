public class Debug {
  public static void main(String[] args) {
    boolean a = false;
    //        System.out.println((int)a);  禁止
    float v = 2.1F;
    double x = 2.13D;

    float naN = Float.NaN;

    Point p = new Point(10, 20);

    p.x = 1;
    System.out.println(p.x);
  }
}
