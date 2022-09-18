package collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class BlockingQueueUsecase {
    private AtomicBoolean running = new AtomicBoolean(true);

    public void queueAndWaitForExecution() {
        BlockingQueue q = new LinkedBlockingQueue<Integer>(10);

        Thread consumer = new Thread(() -> {
            while (running.get() || q.size() > 0) {
                try {
                    System.out.println("Executing job " + q.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        consumer.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Submitted job " + i);
            try {
                q.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        running.set(false);
        try {
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
