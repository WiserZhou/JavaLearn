# 1、编写一个应用程序计算 1/1+1/3+1/5+…+的前 n 项值并在控制台中输出，例如，n=4，计算 1/1+1/3+1/5+1/7 的值。

```java
package ExamTest2.program;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (double) 1 / (2 * i - 1);
        }
        System.out.println(sum);
    }
}

```

# 2

2、编写一个 Java 应用程序，该程序中有三个类：Triangle、Trapezoid 和 Circle，
分别用来刻画“三角形”、“梯形”和“圆形”。具体要求如下：
1)Triangle 类具有类型为 double 的三个边，以及周长、面积属性，Triangle
类具有返回周长、面积以及修改三个边的功能。此外，Triangle 类还有一个
boolean 型的属性，该属性用来判断三个数能够构成一个三角形。完成上述操作
后，给 Triangle 再增加 3 个方法，分别用来返回 3 个边 sideA, sideB, sideC 的值。
2)Lander 类具有类型为 double 的上底、下底、高、面积属性，具有返回面
积的功能。
3)Circle 类具有类型为 double 的半径、周长和面积属性，具有返回周长、面
积的功能。
编写一个测试类 Test，分别创建类 Triangle、Trapezoid 和 Circle 的对象，并
计算三角形、梯形和圆形的周长和面积。

```java
package ExamTest2.program;

public class Test2 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 4, 5);
        if (triangle.isTriangle()) {
            System.out.println(
                    "Triangle: sideA="
                            + triangle.getSideA()
                            + ", sideB="
                            + triangle.getSideB()
                            + ", sideC="
                            + triangle.getSideC()
                            + ", perimeter="
                            + triangle.getPerimeter()
                            + ", area="
                            + triangle.getArea());
        } else {
            System.out.println("Invalid triangle!");
        }

        Trapezoid trapezoid = new Trapezoid(2, 4, 3);
        System.out.println(
                "Trapezoid: upperBase="
                        + trapezoid.getUpperBase()
                        + ", lowerBase="
                        + trapezoid.getLowerBase()
                        + ", height="
                        + trapezoid.getHeight()
                        + ", area="
                        + trapezoid.getArea());

        Circle circle = new Circle(5);
        System.out.println(
                "Circle: radius="
                        + circle.getRadius()
                        + ", perimeter="
                        + circle.getPerimeter()
                        + ", area="
                        + circle.getArea());
    }
}

class Circle {
    private final double radius;
    private double perimeter;
    private double area;

    public Circle(double radius) {
        this.radius = radius;
        calculatePerimeter();
        calculateArea();
    }

    public double getRadius() {
        return radius;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    private void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }

    private void calculateArea() {
        area = Math.PI * radius * radius;
    }
}

class Trapezoid {
    private final double upperBase; // 上底
    private final double lowerBase; // 下底
    private final double height; // 高
    private double area;

    public Trapezoid(double upperBase, double lowerBase, double height) {
        this.upperBase = upperBase;
        this.lowerBase = lowerBase;
        this.height = height;
        calculateArea();
    }

    public double getUpperBase() {
        return upperBase;
    }

    public double getLowerBase() {
        return lowerBase;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return area;
    }

    private void calculateArea() {
        area = (upperBase + lowerBase) * height / 2;
    }
}

class Triangle {
    private final double sideA;
    private final double sideB;
    private final double sideC;
    private double perimeter;
    private double area;
    private final boolean isTriangle;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.isTriangle = checkTriangle(sideA, sideB, sideC);
        if (isTriangle) {
            calculatePerimeter();
            calculateArea();
        }
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    public boolean isTriangle() {
        return isTriangle;
    }

    private boolean checkTriangle(double a, double b, double c) {
        return a + b > c && b + c > a && c + a > b;
    }

    private void calculatePerimeter() {
        perimeter = sideA + sideB + sideC;
    }

    private void calculateArea() {
        double p = perimeter / 2;
        area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }
}

```

# 3、编写一个应用程序，该程序可以将一个文件中的内容输出到控制台中。

```java
package ExamTest2.program;

import java.io.*;
import java.util.Scanner;

class Test31 {

  public static void main(String[] args) {
    // 指定文件路径
    String filePath = "C:\\Users\\86186\\Desktop\\JavaLearn\\ExamTest2\\program\\text.txt";

    try {
      // 创建File对象
      File file = new File(filePath);

      // 创建Scanner对象以读取文件内容
      Scanner scanner = new Scanner(file);

      // 逐行输出文件内容
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        System.out.println(line);
      }

      // 关闭Scanner对象
      scanner.close();

    } catch (FileNotFoundException e) {
      System.out.println("文件未找到: " + filePath);
    }
  }
}

public class Test3 {

  public static void main(String[] args) {
    // 指定文件路径
    String filePath = "C:\\Users\\86186\\Desktop\\JavaLearn\\ExamTest2\\program\\text.txt";

    try {
      // 创建FileReader和BufferedReader对象
      FileReader fileReader = new FileReader(filePath);
      BufferedReader bufferedReader = new BufferedReader(fileReader);

      // 逐行输出文件内容
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        System.out.println(line);
      }

      // 关闭资源
      bufferedReader.close();
      fileReader.close();

    } catch (IOException e) {
      System.out.println("读取文件时出错: " + e.getMessage());
    }
  }
}

class FileContentOutput {

  public static void main(String[] args) {
    // 指定文件路径
    String filePath = "path/to/your/file.txt";

    try {
      // 创建File对象和FileInputStream对象
      File file = new File(filePath);
      FileInputStream fis = new FileInputStream(file);

      // 创建InputStreamReader和BufferedReader对象
      InputStreamReader isr = new InputStreamReader(fis);
      BufferedReader br = new BufferedReader(isr);

      // 逐行输出文件内容
      String line;
      while ((line = br.readLine()) != null) {
        System.out.println(line);
      }

      // 关闭资源
      br.close();
      isr.close();
      fis.close();

    } catch (IOException e) {
      System.out.println("读取文件时出错: " + e.getMessage());
    }
  }
}

```
# 4
利用 Java Socket 编写一个简单的通信程序。客户端通过 Socket 与 IP 地址为
202.102.144.106、端口号为 5432 的服务器端程序建立连接，向其传递 10 个整
数，服务器端通过 ServerSocke 接收客户端发送的 10 个整数后，获取其中最大
的整数返回给客户端。

```java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        // 指定服务器端口号
        int port = 5432;

        try {
            // 创建ServerSocket对象，并监听指定端口
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务器正在监听端口 " + port);

            // 等待客户端连接
            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接");

            // 创建DataInputStream和DataOutputStream对象
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // 接收客户端发送的10个整数
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < 10; i++) {
                int num = dis.readInt();
                System.out.println("接收到整数: " + num);
                
                if (num > max) {
                    max = num;
                }
            }

            // 将最大整数发送给客户端
            dos.writeInt(max);
            System.out.println("发送最大整数: " + max);

            // 关闭资源
            dis.close();
            dos.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            System.out.println("服务器运行时出错: " + e.getMessage());
        }
    }
}

```

```java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

  public static void main(String[] args) {
    // 指定服务器的IP地址和端口号
    String serverIP = "202.102.144.106";
    int serverPort = 5432;

    try {
      // 创建Socket对象，指定服务器的IP地址和端口号
      Socket socket = new Socket(serverIP, serverPort);
      System.out.println("连接服务器成功");

      // 创建DataInputStream和DataOutputStream对象
      DataInputStream dis = new DataInputStream(socket.getInputStream());
      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

      // 发送10个整数给服务器
      for (int i = 1; i <= 10; i++) {
        dos.writeInt(i);
        System.out.println("发送整数: " + i);
      }

      // 接收服务器返回的最大整数
      int max = dis.readInt();
      System.out.println("接收到最大整数: " + max);

      // 关闭资源
      dis.close();
      dos.close();
      socket.close();

    } catch (IOException e) {
      System.out.println("客户端运行时出错: " + e.getMessage());
    }
  }
}

```