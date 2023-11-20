package ExamTest2.reasoning;

public class Test3A {
  public static void main(String[] args) {
    int i, s = 0;
    int[] a = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    for (i = 0; i < a.length; i++) if (a[i] % 2 == 0 || a[i] % 3 == 0) s += a[i];
    System.out.println("s=" + s);
  }
}
