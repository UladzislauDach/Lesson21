package CommonResourse;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class CountThread implements Runnable {
    CommonResourse res;
    Semaphore sem;
    String name;

    public CountThread(CommonResourse res, Semaphore sem, String name) {
        this.res = res;
        this.sem = sem;
        this.name = name;
    }

    public void run() {
        try {
            System.out.println(name + " ожидает разрешение");
            sem.acquire();
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.println(name + ": " + res.x);
                res.x++;
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " освобождает разрешение");
        sem.release();
    }
}
