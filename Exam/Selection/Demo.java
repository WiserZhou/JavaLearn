package Exam.Selection;

class InnerClass implements Inner {
  @Override
  public void innerFun1() {

  }
}

interface Inner {
  public void innerFun1();
}


class Person {
  public void eat() {
    int a = 1;
  }
  public void drink(){
    System.out.println("eee");
  }
}

public class Demo {
  public static void main(String[] args) {
    Person p =
        new Person() {
          public void eat() {
            System.out.println("eat something");
          }
          public void drink(){

          }
        };

    p.eat();
    p.drink();
  }
}

class Outer2 { // 外部类
  private String name;

  public static void main(String[] args) {
    Outer2 outerObj = new Outer2("joshua317");
    Outer2.Inner inner = outerObj.new Inner();
    inner.InnerFun1();
  }

  public Outer2(String name) {
    this.name = name;
  }

  public void OuterFun1() {
    System.out.println("外部类成员方法");
  }

  class Inner { // 内部类
    public void InnerFun1() {
      System.out.println(name);
    }
  }
}
