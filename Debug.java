import project.src.course.Course;

import java.util.*;

public class Debug {
  public static int sum(int x, int... a) {
    int sum = x;
    for (int i = 0; i < a.length; i++) {
      sum += a[i]; // 可变参数被当作数组来处理
    }
    return sum;
  }

  public static void main(String[] args) {
    int x = 10;
    int a[] = {2, 4, 6, 8};
    // 调用带可变参数的方法，传入多个参数
    System.out.println("x+2+4=" + sum(10, 2, 4));
    System.out.println("x+2+4+6=" + sum(10, 2, 4, 6));
    // 调用带可变参数的方法，传入一个数组
    System.out.println(Book.class);
  }
}

class Department implements Comparable {
  int id; // 学院编码
  String name; // 学院名称
  static List departments = new LinkedList(); // 学院集合

  public Department(int id, String name) {
    this.id = id;
    this.name = name;
  }

  //  @Override
  public int compareTo(Object o) {
    Department d = (Department) (o);
    return this.id - d.id;
  }

  public String toString() {
    return this.id + ":" + this.name;
  }
}

// pack
class Book {}
