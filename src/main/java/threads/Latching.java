package threads;

import java.util.concurrent.CountDownLatch;

public class Latching {
    CountDownLatch firstLatch = new CountDownLatch(1);
    CountDownLatch secondLatch = new CountDownLatch(1);

    public void first(Runnable firstJob) {
        firstJob.run();
        firstLatch.countDown();
    }

    public void second(Runnable secondJob) throws InterruptedException {
        firstLatch.await();
        secondJob.run();
        secondLatch.countDown();
    }

    public void third(Runnable thirdJob) throws InterruptedException {
        secondLatch.await();
        thirdJob.run();
    }
}
