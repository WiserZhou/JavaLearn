package Exam.reasoning;

public class Test3A {
  public static void main(String[] args) {
    int i, j;
    outer:
    for (i = 1; i < 4; i++) {
      inner:
      for (j = 1; j < 4; j++) {
        if (j == 2) {
          continue outer;
        }
        System.out.println("i=" + i + ",j=" + j);
      }
    }
  }
}
