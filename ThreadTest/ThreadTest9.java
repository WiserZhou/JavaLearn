package ThreadTest;

class Buffer {
  private int index; // 栈当前指针
  private final char[] stack; // 堆栈

  public Buffer(int n) {
    // 栈大小
    index = 0;
    stack = new char[n];
  }

  // 入栈操作
  public synchronized void put(char c) {
    // 如果栈中的元素已满，将生产者线程放入对象的等待集合中
    while (index == stack.length) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      // 从对象的等待集合中选择一个等待的线程唤醒
      notify();
    }
    // 将字符放入到栈项
    stack[index] = c;
    System.out.println("put " + c);
    // 栈当前指针增1
    index++;
  }

  // 出栈操作
  public synchronized char pop() {
    // 如果栈为空，将消费者线程放入对象的等待集合中
    while (index == 0) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      // 从对象的等待集合中选择一个等待的线程唤醒
      notify();
    }
    // 栈当前指针减1
    index--;
    System.out.println("pop " + stack[index]);
    return stack[index];
  }
}

// 消费者线程体
class Consumer2 implements Runnable {
  Buffer buffer;
  int m;

  public Consumer2(Buffer buffer, int m) {
    this.buffer = buffer;
    this.m = m;
  }

  public void run() {
    char c;
    for (int i = 0; i < m; i++) {
      c = buffer.pop();
      try {
        Thread.sleep((int) (Math.random() * 100));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

// 生产者线程体
class Producer2 implements Runnable {
  Buffer buffer;
  int m;

  public Producer2(Buffer buffer, int m) {
    this.buffer = buffer;
    this.m = m;
  }

  public void run() {
    char c;
    for (int i = 0; i < 20; i++) {
      c = (char) (Math.random() * 26 + 'A');
      buffer.put(c);
      try {
        Thread.sleep((int) (Math.random() * 100));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

// 线程交互测试
public class ThreadTest9 {
  public static void main(String[] args) {
    Buffer buffer = new Buffer(20);
    Runnable producer = new Producer2(buffer, 20);
    Runnable consumer = new Consumer2(buffer, 20);
    Thread t1 = new Thread(producer);
    Thread t2 = new Thread(consumer);
    t1.start();
    t2.start();
  }
}
