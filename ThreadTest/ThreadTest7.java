package ThreadTest;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest7 implements Runnable {
  static List<String> list = new ArrayList<String>();

  // 实例方法同步
  public static synchronized void add() throws InterruptedException {
    String name = Thread.currentThread().getName();
    for (int i = 0; i < 5; i++) {
      list.add(name);
      Thread.sleep(200);
    }
  }

  // 线程体
  public void run() {
    try {
      add();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws InterruptedException {
    ThreadTest7 t1 = new ThreadTest7(); // 创建实例t1
    ThreadTest7 t2 = new ThreadTest7(); // 创建实例t2
    Thread ta = new Thread(t1, "A"); // 创建线程对象
    Thread th = new Thread(t2, "B"); // 创建线程对象
    Thread tc = new Thread(t2, "C"); // 创建线程对象

    // 启动线程
    ta.start();
    th.start();
    tc.start();

    // 在主线程之前执行
    ta.join();
    th.join();
    tc.join();

    System.out.println("ThreadSynch.list: " + list);
  }
}
