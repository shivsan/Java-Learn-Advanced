package threads;

import java.util.concurrent.Semaphore;

public class Semaphoring {
    Semaphore semaphore = new Semaphore(0);

    public void first(Runnable firstJob) {
        firstJob.run();
        semaphore.release(1);
    }

    public void second(Runnable secondJob) throws InterruptedException {
        semaphore.acquire(1);
        secondJob.run();
        semaphore.release(3);
    }

    public void third(Runnable thirdJob) throws InterruptedException {
        semaphore.acquire(3);
        thirdJob.run();
    }
}
