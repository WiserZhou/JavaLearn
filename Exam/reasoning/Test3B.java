package Exam.reasoning;

public class Test3B {
  public static void main(String[] args) {
    int m = 1, n = 1;
    System.out.print(m + " ");
    for (int i = 2; i <= 10; i++) {
      System.out.print(n + " ");
      if (i % 5 == 0) System.out.print("\n");
      n = n + 1;
      m = n - m;
    }
  }
}
