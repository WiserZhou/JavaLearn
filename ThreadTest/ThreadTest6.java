package ThreadTest;

import java.io.*;

class MyWriter extends Thread {
  PipedOutputStream pos; // 管道输出数据流
  private final String[] messages = {
    "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
  }; // 写入数据

  public MyWriter(PipedOutputStream pos) {
    this.pos = pos;
  }

  public void run() {
    try {
      // 数据输出数据流
      DataOutputStream dos = new DataOutputStream(pos);
      // 数据长度
      int size = 7;
      dos.writeInt(size); // 写入数据长度

      // 写入数据
      for (String message : messages) {
        dos.writeUTF(message);
        System.out.println("Write: " + message);
        try {
          sleep(300);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      dos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

class MyReader extends Thread {
  PipedInputStream pis; // 管道输入数据流

  public MyReader(PipedInputStream pis) {
    this.pis = pis;
  }

  public void run() {
    try {
      // 数据输入数据流
      DataInputStream dis = new DataInputStream(pis);
      int size = dis.readInt(); // 读取数据长度
      // 接收数据
      String[] messages = new String[size]; // 设置数据长度

      // 读取数据
      for (int i = 0; i < messages.length; i++) {
        messages[i] = dis.readUTF();
        System.out.println("Read: " + messages[i]);
        try {
          sleep(400);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      dis.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

public class ThreadTest6 {
  public static void main(String[] args) {
    ThreadTest6 thisPipe = new ThreadTest6();
    thisPipe.process();
  }

  public void process() {
    PipedInputStream inStream; // 管道输入流
    PipedOutputStream outStream; // 管道输出流

    try {
      // 建立输入流与输出流之间的连接
      outStream = new PipedOutputStream();
      inStream = new PipedInputStream(outStream);

      new MyWriter(outStream).start(); // 启动写线程
      new MyReader(inStream).start(); // 启动读线程
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
