package ExamTest2.program;

import java.util.Scanner;

public class Test1 {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    double sum = 0;
    for (int i = 0; i < n; i++) {
      sum += (double) 1 / (2 * i - 1);
    }
    System.out.println(sum);
  }
}
