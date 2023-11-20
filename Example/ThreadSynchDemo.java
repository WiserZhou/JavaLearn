package Example;

import java.util.ArrayList;
import java.util.List;

class ThreadSynch implements Runnable {
  static final List<String> list = new ArrayList<String>();

  public synchronized void add() throws InterruptedException {

    String name = Thread.currentThread().getName();
    for (int i = 0; i < 5; i++) {
      synchronized (list) {
        list.add(name);
      }
      Thread.sleep(200);
    }
  }

  public void run() {
    try {
      add();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

public class ThreadSynchDemo {
  public static void main(String[] args) throws InterruptedException {
    ThreadSynch t1 = new ThreadSynch();
    ThreadSynch t2 = new ThreadSynch();
    Thread ta = new Thread(t1, "A");
    Thread tb = new Thread(t2, "B");
    Thread tc = new Thread(t2, "C");
    ta.start();
    tb.start();
    tc.start();

    ta.join();
    tb.join();
    tc.join();
    System.out.println(ThreadSynch.list);
  }
}
