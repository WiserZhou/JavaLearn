package Experiment.Experiment1;

import java.util.Scanner;

public class fourth {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 输入校验
    int m, n;
    do {
      System.out.print("请输入两个正整数（以空格分隔）：");
      m = scanner.nextInt();
      n = scanner.nextInt();
    } while (m <= 0 || n <= 0);

    // 求最大公约数
    int gcd = getGCD(m, n);
    System.out.println("最大公约数：" + gcd);

    // 求最小公倍数
    int lcm = m * n / gcd;
    System.out.println("最小公倍数：" + lcm);
  }

  // 辗转相除法求最大公约数
  public static int getGCD(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return getGCD(b, a % b);
    }
  }
}
