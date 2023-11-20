package ExamTest2.Selection;

public class ExampleThread {
  private final Object lock = new Object(); // 私有的Object类型的变量lock，用作同步锁。

  public void doSomething() {
    synchronized (lock) { // doSomething方法使用synchronized关键字将代码块标记为同步块，使用lock对象作为同步锁。
      // 一些操作...
      System.out.println("当前线程执行到唤醒其他线程的代码...");
      lock.notify(); // 唤醒在此对象上等待的一个线程。
      System.out.println("当前线程已经完成了唤醒其他线程的操作...");
    }
  }

  public static void main(String[] args) {
    ExampleThread example = new ExampleThread();
    Thread thread1 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                synchronized (example.lock) {
                  example.doSomething();
                }
              }
            });
    Thread thread2 =
        new Thread(
            new Runnable() {
              @Override
              public void run() {
                synchronized (example.lock) {
                  try {
                    example.lock.wait(); // 在lock对象上等待，直到被唤醒。
                    System.out.println("被唤醒的线程执行了操作...");
                  } catch (InterruptedException e) {
                    e.printStackTrace();
                  }
                }
              }
            });
    thread2.start(); // 先启动等待唤醒的线程
    thread1.start(); // 后启动执行唤醒操作的线程
  }
}
