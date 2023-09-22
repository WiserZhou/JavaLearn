package JavaExperiment;

import java.util.Scanner;

public class first {
  public static void main(String[] args) { // 主函数，程序入口
    Scanner scanner = new Scanner(System.in); // 创建输入对象与标准输入关联起来
    Integer n = scanner.nextInt(); //
    for (int i = 2; i <= n; i++) {
      if (isPrime(i)) System.out.println(i);
    }
  }

  public static boolean isPrime(int x) {
    if (x <= 1) return false; // 质数肯定是大于1的
    if (x <= 3) return true; // 质数2和3是肯定的
    if (x % 2 == 0 || x % 3 == 0) return false; // 质数肯定不会被2或者3整除
    for (int i = 5; i * i <= x; i += 6) { // 整数除了是2和3的倍数，剩下的只能表示为6k±1的形式，从5开始迭代，正好可以全覆盖
      if (x % i == 0 || x % (i + 2) == 0) {
        return false;
      }
    }
    return true;
  }
}
