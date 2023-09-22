package JavaExperiment;

import java.lang.management.OperatingSystemMXBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fifth {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int[][] matrix1 = readMatrix(scanner, "请输入第一个矩阵元素：");
    int[][] matrix2 = readMatrix(scanner, "请输入第二个矩阵元素：");

    if (matrix1[0].length != matrix2.length) {
      System.out.println("输入错误！矩阵相乘要求第一个矩阵的列数与第二个矩阵的行数相等！");
      scanner.close();
      return;
    }

    int[][] result = multiplyMatrix(matrix1, matrix2);

    System.out.println("输出的矩阵为：");
    for (int[] row : result) {
      for (int num : row) {
        System.out.print(num + " ");
      }
      System.out.println();
    }

    scanner.close();
  }

  // 读取矩阵输入
  private static int[][] readMatrix(Scanner scanner, String message) {
    System.out.println(message);
    String line;
    List<int[]> rows = new ArrayList<>(); // 创建一个中间二维数组，储存输入的数据
    while (!(line = scanner.nextLine()).equals("exit")) { // 如果输入的值不为exit，则继续执行
      String[] numbers = line.split(" "); // 将读入的数据用空格进行分隔
      int[] row = new int[numbers.length];
      for (int i = 0; i < numbers.length; i++) {
        row[i] = Integer.parseInt(numbers[i]);
      }
      rows.add(row);
    }
    int[][] matrix = new int[rows.size()][rows.get(0).length]; // 动态创建matrix数组
    for (int i = 0; i < rows.size(); i++) {
      matrix[i] = rows.get(i);
    }
    return matrix;
  }

  // 矩阵相乘
  private static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
    int row1 = matrix1.length;
    int col1 = matrix1[0].length;
    int col2 = matrix2[0].length;
    int[][] result = new int[row1][col2];
    for (int i = 0; i < row1; i++) {
      for (int j = 0; j < col2; j++) {
        for (int k = 0; k < col1; k++) {
          result[i][j] += matrix1[i][k] * matrix2[k][j];
        }
      }
    }
    return result;
  }
}
