package CommonResourse;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadsApp {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        CommonResourse res = new CommonResourse();
        new Thread(new CountThread(res, sem, "Thread 1")).start();
        new Thread(new CountThread(res, sem, "Thread 2")).start();
        new Thread(new CountThread(res, sem, "Thread 3")).start();
    }
}

