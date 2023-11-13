package Exam.program;

import java.io.*;

class FileReadWrite {
  public void addBooks(String fileName) {
    try {
      FileOutputStream fos = new FileOutputStream(fileName);
      DataOutputStream dos = new DataOutputStream(fos);

      dos.writeUTF("学号\t姓名\t年龄\t平均成绩");
      dos.writeUTF("151110101\t张三\t21\t80.5");
      dos.writeUTF("151110102\t李四\t21\t83.0");
      dos.writeUTF("151110103\t王五\t22\t95.6");

      dos.close();
      fos.close();
      System.out.println("学生信息已写入文件：" + fileName);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void getBooks(String fileName) {
    try {
      FileInputStream fis = new FileInputStream(fileName);
      DataInputStream dis = new DataInputStream(fis);

      String line;
      while ((line = dis.readUTF()) != null) {
        System.out.println(line);
      }

      dis.close();
      fis.close();
    } catch (EOFException e) {
      // 文件读取结束
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

public class Reader {
  public static void main(String[] args) {
    FileReadWrite fileReadWrite = new FileReadWrite();
    String fileName = "students.txt";

    fileReadWrite.addBooks(fileName);
    fileReadWrite.getBooks(fileName);
  }
}
