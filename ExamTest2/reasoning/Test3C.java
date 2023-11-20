package ExamTest2.reasoning;

public class Test3C {
  static long number = 120456;

  public static void main(String[] args) {
    long a = 0;
    long digit;
    while (number > 0) {
      digit = number % 10;
      a = a * 10 + digit;
      number = number / 10;
    }
    System.out.println(a);
  }
}
