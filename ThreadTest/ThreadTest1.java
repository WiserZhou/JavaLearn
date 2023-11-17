package ThreadTest;
// 继承Thread类的线程子类
class MyThread extends Thread {
    public void run() {
        // 定义线程的执行逻辑
        for (int i = 0; i < 5; i++) {
            System.out.println("线程执行：" + i);
            try {
                Thread.sleep(1000);  // 线程睡眠1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        // 创建线程对象
        MyThread thread = new MyThread();
        // 启动线程
        thread.start();

        // 主线程的执行逻辑
        for (int i = 0; i < 5; i++) {
            System.out.println("主线程执行：" + i);
            try {
                Thread.sleep(1000);  // 主线程睡眠1秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
