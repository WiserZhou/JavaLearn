import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

  public static void main6(String[] args) throws Exception {
    var add = new AddThread();
    var dec = new DecThread();
    add.start();
    dec.start();
    add.join();
    dec.join();
    System.out.println(Counter.count);
  }

  public static void main(String[] args) throws InterruptedException {
    var q = new TaskQueue();
    var ts = new ArrayList<Thread>();
    for (int i = 0; i < 5; i++) {
      var t =
          new Thread() {
            public void run() {
              // 执行task:
              while (true) {
                try {
                  String s = q.getTask();
                  System.out.println("execute task: " + s);
                } catch (InterruptedException e) {
                  return;
                }
              }
            }
          };
      t.start();
      ts.add(t);
    }
    var add =
        new Thread(
            () -> {
              for (int i = 0; i < 10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try {
                  Thread.sleep(100);
                } catch (InterruptedException e) {
                }
              }
            });
    add.start();
    add.join();
    Thread.sleep(100);
    for (var t : ts) {
      t.interrupt();
    }
  }
}

class TaskQueue {
  Queue<String> queue = new LinkedList<>();

  public synchronized void addTask(String s) {
    this.queue.add(s);
    this.notifyAll(); // 使用notifyAll()将唤醒所有当前正在this锁等待的线程，而notify()只会唤醒其中一个（具体哪个依赖操作系统，有一定的随机性）
  }

  public synchronized String getTask() throws InterruptedException {
    while (queue.isEmpty()) {
      this.wait();
    }
    return queue.remove(); // 移除头部元素
  }
}

class Counter {
  public static final Object lock = new Object();
  public static int count = 0;
}

class AddThread extends Thread {
  public void run() {
    for (int i = 0; i < 10000; i++) {
      synchronized (Counter.lock) {
        Counter.count += 1;
        System.out.println("add" + Counter.count);
      }
    }
  }
}

class DecThread extends Thread {
  public void run() {
    for (int i = 0; i < 10000; i++) {
      synchronized (Counter.lock) {
        Counter.count -= 1;
        System.out.println("dec" + Counter.count);
      }
    }
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
