package Exam.Selection;

public class OuterClass {
  private int outerField;

  // 定义一个非静态成员类
  public class InnerClass {
    public void innerMethod() {
      System.out.println("Inner method called");
      System.out.println("Value of outerField: " + outerField);
    }
  }

  public void outerMethod() {
    // 创建外部类的实例
    OuterClass outerInstance = new OuterClass();

    // 创建非静态成员类的实例
    OuterClass.InnerClass innerInstance = new InnerClass();

    // 调用非静态成员类的方法
    innerInstance.innerMethod();
  }

  public static void main(String[] args) {
    // 创建外部类的实例
    OuterClass outer = new OuterClass();

    // 调用外部类方法来间接调用内部类的方法
    outer.outerMethod();
  }
}
