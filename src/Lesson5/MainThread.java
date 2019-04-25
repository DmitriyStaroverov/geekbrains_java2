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

class MyRunnableClass implements Runnable {
    int num;

    public MyRunnableClass(int num) {
        this.num = num;
    }

    public static void main(String[] args) {
        MyRunnableClass myRunnableClass = new MyRunnableClass (1);
        MyRunnableClass myRunnableClass2 = new MyRunnableClass (2);
        new Thread ( myRunnableClass ).start ();
        new Thread ( myRunnableClass2 ).start ();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Поток: " + num + " - сигнал: " + i);
        }
    }
}