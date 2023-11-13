package Exam.reasoning;

public class Test3C {
  public static void main(String[] args) {
    int i, s = 0;
    int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    for (i = 0; i < a.length; i++) if (a[i] % 3 == 0) s += a[i];
    System.out.println("s=" + s);
  }
}
