package ThreadTest;

// 实现Runnable接口的线程类
class MyRunnable implements Runnable {
  public void run() {
    // 定义线程的执行逻辑
    for (int i = 0; i < 5; i++) {
      System.out.println("线程执行：" + i);
      try {
        Thread.sleep(1000); // 线程睡眠1秒
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

public class ThreadTest2 {
  public static void main(String[] args) {
    // 创建实现Runnable接口的对象
    MyRunnable myRunnable = new MyRunnable();
    // 创建线程对象，将实现类对象作为参数传递
    Thread thread = new Thread(myRunnable);
    // 启动线程
    thread.start();

    // 主线程的执行逻辑
    for (int i = 0; i < 5; i++) {
      System.out.println("主线程执行：" + i);
      try {
        Thread.sleep(1000); // 主线程睡眠1秒
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
