package ThreadTest;

class MyThread2 extends Thread {
  public void run() {
    try {
      while (!isInterrupted()) {
        System.out.println("Running...");
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      System.out.println("Thread interrupted");
    }
    System.out.println("Thread finished");
  }
}

public class ThreadTest5 {
  public static void main(String[] args) {
    MyThread2 thread = new MyThread2();
    thread.start();

    try {
      Thread.sleep(5000); // 让主线程休眠5秒钟
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    thread.interrupt(); // 中断线程的执行

    System.out.println("Main thread finished");
  }
}
