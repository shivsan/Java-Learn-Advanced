package collections;

import junit.framework.TestCase;

public class BlockingQueueUsecaseTest extends TestCase {
    public void testQueuingWithBlockedQueue() {
        new BlockingQueueUsecase().queueAndWaitForExecution();
    }
}
