package ExamTest2.reasoning;

public class Test3B {
  public static void main(String[] args) {
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 6 - i; j++) {
        System.out.print("*");
      }
      System.out.print("\n");
    }
  }
}
