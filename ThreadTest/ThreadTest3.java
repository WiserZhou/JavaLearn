package ThreadTest;

class MyThread1 implements Runnable {
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " is running");
        }
    }
}

public class ThreadTest3 {
    public static void main(String[] args) {
        MyThread1 myThread = new MyThread1();

        Thread thread1 = new Thread(myThread, "Thread-1");
        Thread thread2 = new Thread(myThread, "Thread-2");

        // 设置线程优先级
        thread1.setPriority(Thread.MIN_PRIORITY); // 最低优先级
        thread2.setPriority(Thread.MAX_PRIORITY); // 最高优先级

        thread1.start();
        thread2.start();
    }
}
