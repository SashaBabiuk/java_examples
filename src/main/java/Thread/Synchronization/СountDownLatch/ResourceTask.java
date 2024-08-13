package Thread.Synchronization.СountDownLatch;

import java.util.concurrent.CountDownLatch;

public abstract class ResourceTask implements Runnable {
    private final long id;
    private final CountDownLatch countDownLatch;

    public ResourceTask(long id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    protected abstract void run(CountDownLatch countDownLatch);
    @Override
    public void run() {
        this.run(this.countDownLatch);
    }

    @Override
    public final String toString() {
        return this.getClass().getName() + "[id = " + this.id + "]";
    }

}
