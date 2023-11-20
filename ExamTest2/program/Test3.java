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
