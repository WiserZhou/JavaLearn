package Example;

public class Packaging {
  public static void main(String[] args) {
    //    int num = 42;
    Integer intObj = 12;
    int num = intObj;
    String str = "123";
    int num2 = Integer.parseInt(str);
    String str2 = intObj.toString();
    Integer intObj2 = 22;
    int result = intObj.compareTo(intObj2);
    System.out.println(result);
    int max = Integer.MAX_VALUE;
    int min = Integer.MIN_VALUE;
    System.out.println(max);
    System.out.println(min);
  }
}
