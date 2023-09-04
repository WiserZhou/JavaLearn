import java.awt.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

public class Array {
  public static void main(String[] args) {
    create();
  }

  public static void create() {
    char[] s;
    Date[] dataArray; // 定义数组的时候只是对数组进行了说明，系统没有为其分配内存他们只是引用变量，用来指向一个数组。

    int[] intArray = {1, 2, 3, 4};
    Point[] points = {new Point(1, 2), new Point(3, 4)};
    int length = intArray.length; // 。length表示数组的长度

    int[][] intArrays = {{2, 3}, {1, 4}};
    double[][] doubles = new double[4][4]; // 直接初始化

    String[][] strings = new String[2][];
    strings[0] = new String[3];
    strings[1] = new String[5];
    // 对二维数组进行遍历
    for (int j = 0; j < strings.length; j++) {
      for (int i = 0; i < strings[j].length; i++) {
        strings[j][i] = "hello" + i;
      }
    }
    System.out.println(Arrays.deepToString(strings));
  }

  public void arrayCopy() {
    int[] elements = {1, 2, 3, 4, 5, 6};
    int[] hold = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    System.arraycopy(elements, 0, hold, 0, elements.length); // 将elements数组的所有元素一一对应的放在
    // hold的里面，没有对应的位置保持原状。
  }

  public void vectorUse() {
    Vector myVector = new Vector(100, 50);
    for (int i = 1; i <= 10; i++) {
      myVector.addElement(new Random());
    }
    myVector.insertElementAt("middle", 5);
    myVector.setElementAt("hello", 0);
    myVector.removeElement("middle");
    myVector.removeElementAt(2);
    myVector.removeAllElements();

    String str = (String) myVector.elementAt(0);
    boolean flag = myVector.contains("middle");
    int position = myVector.indexOf("middle", 1); // 从指定位置开始向后搜索，返回与第一个指定对象元素相同的下标位置。
    int position2 = myVector.lastIndexOf("middle", 5); // 向前搜索。
    int size = myVector.size(); // 所含元素的个数
    int capacity = myVector.capacity();
    Enumeration<String> elements = myVector.elements();
    while (elements.hasMoreElements()) {
      System.out.println(elements.nextElement());
    }
    myVector.trimToSize(); // 将vector的容量下调至最小值
    myVector.clone();
  }
}

class Point {
  int x, y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  Point() {
    //    this.x = 0;
    //    this.y = 0;
    this(0, 0); // this直接调用函数使用了类的构造函数，叫做链式调用
  }
}

class MyVector extends Vector {
  public MyVector() {
    super(1, 1);
  }

  public void printVector() {
    Object o;
    int length = size();
    System.out.println("Number of vector elements is " + length + " and they are:");
    for (int i = 0; i < length; i++) {
      o = elementAt(i);
      if (o instanceof char[]) {
        System.out.println(String.copyValueOf((char[]) o));
      } else {
        System.out.println(o.toString());
      }
    }
  }
}
