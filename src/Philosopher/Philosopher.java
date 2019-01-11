package Philosopher;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class Philosopher {
    Semaphore sem;
    int number = 1;
    int id;

    Philosopher(Semaphore sem, int id) {
        this.sem = sem;
        this.id = id;
    }

    public void run() {
        try {
            while (number < 3) {
                sem.acquire();
                System.out.println("Философ " + id + " садится за стол");

                sleep(100);
                number++;
                System.out.println("Философ " + id + " выходит из-за стола");

                sem.release();
                sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("У философа " + id + " проблемы со здоровьем");
        }
    }

}
