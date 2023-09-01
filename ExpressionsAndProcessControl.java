import java.text.DecimalFormat;
import java.util.Scanner;

public class ExpressionsAndProcessControl {
  public static void main(String[] args) {

    String message;
    System.out.println("Enter a line of text:");
    Scanner scanner = new Scanner(System.in); // System.in 表示标准输入流，默认是指键盘。
    message = scanner.nextLine(); // 读取一整行

    System.out.println("You entered: \"" + message + "\"");

    int age;
    double weight, height, bmi;

    age = scanner.nextInt(); // 读取整数值

    weight = scanner.nextDouble(); // 读取double数据

    height = scanner.nextDouble();

    bmi = weight / (height * height);
    DecimalFormat decimalFormat = new DecimalFormat("0.###"); // DecimalFormat十进制格式化对象，设置输出的格式。
    System.out.println("BMI:" + decimalFormat.format(bmi));
  }

  private String name;
}

class Customer {
  String name;

  public void print() {
    System.out.println(Math.sin(0));
    System.out.println(Math.cos(0));
    System.out.println(Math.tan(0));
    System.out.println(Math.round(4.6)); // 四舍五入
    System.out.println(Math.ceil(4.2)); // 向上取整
    System.out.println(Math.floor(4.3)); // 向下取整
    System.out.println(Math.exp(3)); // e的指数
  }

  public void create() {
    Customer customer = new Customer();
    {
      String name = "Tom David";
      customer.name = name;
      System.out.println("The customer's name:" + customer.name);
    }
    String name = "John Smith";
    customer.name = name;
    System.out.println("The customer's name:" + customer.name);
  }
}
