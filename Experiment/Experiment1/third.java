package Experiment.Experiment1;

import java.util.Scanner;

public class third {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt(); // 输入
    int sum; // 定义求和变量
    for (int j = 1; j <= n; j++) { // 从1到n之间循环查找
      sum = 0;
      for (int i = 1; i <= j / 2; i++) { // 从1开始到j/2的区间内寻找所有的因子
        if (j % i == 0) sum += i;
      }
      if (sum == j) System.out.println(j);
    }
  }
}
