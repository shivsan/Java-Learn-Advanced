package threads;

import junit.framework.TestCase;

public class ExecutorServicePoolingTest extends TestCase {
    public void testName() {
        new ExecutorServicePooling().runProducerAndConsumer();
    }
}
