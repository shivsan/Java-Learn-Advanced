package threads;

public class Semaphoring {
    public void first(Runnable firstJob) {
        firstJob.run();
    }

    public void second(Runnable secondJob) {
        secondJob.run();
    }

    public void third(Runnable thirdJob) {
        thirdJob.run();
    }
}
