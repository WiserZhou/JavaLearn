package Example;

interface Animal1 {
  void eat();

  void sleep();
}

public class Main11 {
  public static void main(String[] args) {
    Animal1 animal =
        new Animal1() {
          @Override
          public void eat() {
            System.out.println("Animal is eating");
          }

          @Override
          public void sleep() {
            System.out.println("Animal is sleeping");
          }
        };

    animal.eat(); // 调用 eat() 方法
    animal.sleep(); // 调用 sleep() 方法
  }
}
