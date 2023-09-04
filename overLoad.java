public class overLoad {
  public static void main(String[] args) {
    int sum1 = MathUtils.add(2, 3); // 调用第一个 add 方法
    double sum2 = MathUtils.add(2.5, 3.7); // 调用第二个 add 方法
    int sum3 = MathUtils.add(2, 3, 4); // 调用第三个 add 方法
  }
}

class MathUtils {
  // 重载的方法，接收两个整型参数
  public static int add(int a, int b) {
    return a + b;
  }

  // 重载的方法，接收两个双精度浮点型参数
  public static double add(double a, double b) {
    return a + b;
  }

  // 重载的方法，接收三个整型参数
  public static int add(int a, int b, int c) {
    return a + b + c;
  }
}
