package ThreadTest;

class CubbyHole {
  private int goods; // 缓冲区数据
  private boolean empty; // 缓冲区是否为空

  public CubbyHole() {
    empty = true; // 初始缓冲区为空
  }

  public synchronized int get() {
    // 当缓冲区为空
    while (empty) {
      try {
        wait(); // 让调用get方法的线程进入等待集合中
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println("消费者拿走了物品" + goods);
    empty = true; // 设置缓冲区为空
    notify(); // 唤醒等待集合中的线程
    return goods;
  }

  public synchronized void put(int value) {
    // 如果缓冲区不为空
    while (!empty) {
      try {
        wait(); // 让调用put方法的线程进入等待集合中
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    goods = value; // 向缓冲区放入数据value
    System.out.println("生产者生产了物品" + goods);
    empty = false; // 设置缓冲区为非空
    notify(); // 唤醒等待集合中的线程
  }
}

// 生产者
class Producer1 extends Thread {
  private final CubbyHole cubbyHole;

  public Producer1(CubbyHole c) {
    cubbyHole = c;
  }

  public void run() {
    // 向缓冲区放入1-100之间的50个随机数
    for (int i = 0; i < 50; i++) {
      cubbyHole.put(i);
    }
  }
}

// 消费者
class Consumer extends Thread {
  private final CubbyHole cubbyHole;

  public Consumer(CubbyHole c) {
    cubbyHole = c;
  }

  public void run() {
    for (int i = 0; i < 50; i++) {
      cubbyHole.get();
    }
  }
}

// Main类
public class ThreadTest8 {
  public static void main(String[] args) {
    // 创建单缓冲区
    CubbyHole c = new CubbyHole();

    // 创建生产者
    Producer1 producer = new Producer1(c);
    producer.start();

    // 创建消费者
    Consumer consumer = new Consumer(c);
    consumer.start();
  }
}
