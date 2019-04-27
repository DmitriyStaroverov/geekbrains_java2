package Lesson5;

public class MainThread {
    public static void main(String[] args) {
        MyThread myThread_1 = new MyThread();
        MyThread myThread_2 = new MyThread();
        myThread_1.start();
        myThread_2.start();
        try {
            myThread_1.join();
            myThread_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("END");


    }
}

class MyThread extends Thread {
   @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }
}

class MyRunnable implements Runnable {
    int num;

    public MyRunnable(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable (1);
        MyRunnable myRunnable2 = new MyRunnable (2);
        Thread thread1 = new Thread ( myRunnable );
        Thread thread2 = new Thread ( myRunnable2 );
        thread1.start ();
        thread1.setPriority ( 10 );
        thread2.start ();


    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Поток: " + num + " - сигнал: " + i);
        }
    }
}