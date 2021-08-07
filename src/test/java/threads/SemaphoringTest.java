package threads;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SemaphoringTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testRunningInOrderNotWorking() throws InterruptedException {
        final Object latch = new Object();
        synchronized (latch) {
            Runnable firstJob = () -> {
                synchronized (latch) {
                    try {
                        latch.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("First");
                }
            };

            Runnable secondJob = () -> {
                synchronized (latch) {
                    try {
                        latch.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("Second");
                }
            };

            Runnable thirdJob = () -> {
                synchronized (latch) {
                    try {
                        latch.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print("Third");
                }
            };

            Thread thread1 = new Thread(firstJob);
            thread1.start();

            Thread thread2 = new Thread(secondJob);
            thread2.start();

            Thread thread3 = new Thread(thirdJob);
            thread3.start();

            latch.notifyAll();

            thread1.join();
            thread2.join();
            thread3.join();
        }
        assertEquals("Negative numbers are invalid input", outContent.toString());
    }

    @Test
    public void testRunningInOrder() throws InterruptedException {
        Semaphoring semaphoring = new Semaphoring();
        Runnable firstJob = () -> System.out.print("First");

        Runnable secondJob = () -> System.out.print("Second");

        Runnable thirdJob = () -> System.out.print("Third");

        Thread thread3 = new Thread(() -> semaphoring.third(thirdJob));
        Thread thread1 = new Thread(() -> semaphoring.first(firstJob));
        Thread thread2 = new Thread(() -> semaphoring.second(secondJob));

        thread2.start();
        thread1.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        assertEquals("FirstSecondThird", outContent.toString());
    }
}
