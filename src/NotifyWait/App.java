package NotifyWait;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class App {
    public static void main(String[] args) {
        ReentrantLock locker = new ReentrantLock();
        Condition condition = locker.newCondition();
        Store store = new Store(locker,condition);
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}