package JavaExperiment;

import static java.lang.Math.pow;

public class second {
  public static void main(String[] args) {
    for (int i = 100; i < 1000; i++) {
      int a = i % 10; // 获得个位数字
      int b = i / 10 % 10; // 获得十位数
      int c = i / 100; // 获得百位数

      int sum = c * c * c + b * b * b + a * a * a; // 计算立方和

      if (sum == i) {
        System.out.println(i); // 判断并输出
      }

      if (sum > i) {
        break; // 立方和已经超过当前数值，提前结束循环
      }
    }
  }
}
