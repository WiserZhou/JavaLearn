package Example;

public class string {
  public static void main(String[] args) {
    String str1 = new String("hello");
    System.out.println(str1.hashCode());
    str1 = "hello";
    System.out.println(str1.hashCode());

    // String interning is a process where all string literals with the same value share the same
    // memory address to save space and improve performance.
  }
}
