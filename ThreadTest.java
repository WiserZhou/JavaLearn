public class ThreadTest {
  public static void main3(String[] args) {
    Thread thread = new MyThread();
    thread.start();
  }

  public static void main5(String[] args) {
    System.out.println("main start...");
    Thread t =
        new Thread() {
          public void run() {
            System.out.println("thread run...");
            try {
              Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            System.out.println("thread end.");
          }
        };
    t.start();
    try {
      Thread.sleep(20);
    } catch (InterruptedException e) {
    }
    System.out.println("main end...");
  }

  public static void main4(String[] args) {
    Thread thread = new Thread(new MyRunnable());
    thread.start();
  }

  public static void main2(String[] args) {
    Thread t =
        new Thread(
            () -> {
              System.out.println("start new thread!");
            });
    t.start(); // 启动新线程
  }

  public static void main(String[] args) throws InterruptedException {
    HelloThread2 t = new HelloThread2();
    t.start();
    Thread.sleep(1);
    t.running = false; // 标志位置为false
  }
}

class HelloThread2 extends Thread {
  public volatile boolean running = true; // 。线程间共享变量需要使用volatile关键字标记，确保每个线程都能读取到更新后的变量值。

  public void run() {
    int n = 0;
    while (running) {
      n++;
      System.out.println(n + " hello!");
    }
    System.out.println("end!");
  }
}

class MyThread extends Thread {
  public void run() {
    Thread hello = new HelloThread();
    hello.start(); // 启动hello线程
    try {
      hello.join(); // 等待hello线程结束
    } catch (InterruptedException e) {
      System.out.println("interrupted!");
    }
    hello
        .interrupt(); // 在t线程结束前，对hello线程也进行了interrupt()调用通知其中断。如果去掉这一行代码，可以发现hello线程仍然会继续运行，且JVM不会退出。
  }
}

class HelloThread extends Thread {
  public void run() {
    int n = 0;
    while (!isInterrupted()) {
      n++;
      System.out.println(n + " hello!");
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        System.out.println("Interrupted！");
        break;
      }
    }
  }
}

class MyRunnable implements Runnable {
  @Override
  public void run() {
    System.out.println("start new thread!");
  }
}
