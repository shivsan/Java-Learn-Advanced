package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// A producer-consumer combo where the producer produces a Million jobs. Consumer can only consume slowly.
// Output: Producer finishes queuing tasks in 10s, consumer takes ~ 2 hours to complete.
public class ExecutorServicePooling {
    public void runProducerAndConsumer() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 1000000; i++) {
            System.out.println("Submitted job " + i++);
            executorService.submit(job(i));
        }

        try {
            executorService.awaitTermination(1000, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Runnable job(int i) {
        return () -> {
            System.out.println("Executing " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
