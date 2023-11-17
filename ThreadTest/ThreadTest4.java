package ThreadTest;

class Producer implements Runnable {
  private final int[] arr;

  public Producer(int[] arr) {
    this.arr = arr;
  }

  public void run() {
    System.out.println("Initializing...");
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random() * 10);
      System.out.print(arr[i] + ",");
      if ((i + 1) % 10 == 0) System.out.println();
    }
    System.out.println();
  }
}

class Worker implements Runnable {
  private final int[] arr;
  private final Thread thread;

  public Worker(int[] arr, Thread thread) {
    this.arr = arr;
    this.thread = thread;
  }

  public void run() {
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Calculating...");
    int sum = 0;
    for (int j : arr) {
      sum += j;
    }
    ThreadTest4.sum = sum;
  }
}

class PrintTask implements Runnable {
  private final Thread thread;

  public PrintTask(Thread thread) {
    this.thread = thread;
  }

  public void run() {
    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("sum=" + ThreadTest4.sum);
  }
}

public class ThreadTest4 {
  static int sum = 0;

  public static void main(String[] args) throws InterruptedException {
    int[] arr = new int[10];

    Thread producer = new Thread(new Producer(arr));
    producer.start();

    Thread worker = new Thread(new Worker(arr, producer));
    worker.start();

    Thread printTask = new Thread(new PrintTask(worker));
    printTask.start();

    printTask.join();

    int sum1 = 0;
    for (int j : arr) {
      sum1 += j;
    }

    if (sum == sum1) {
      System.out.println("Verification passed!");
    } else {
      System.out.println("Verification failed! sum=" + sum + ", sum1=" + sum1);
    }
  }
}
