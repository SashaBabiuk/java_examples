package Thread.Synchronization.СountDownLatch;

import java.util.concurrent.CountDownLatch;

public abstract class ResourceTaskFactory {
    private int nextId;

    public final ResourceTask create(CountDownLatch countDownLatch){
        return this.create(this.nextId++,countDownLatch);
    }

    protected abstract ResourceTask create(long id,CountDownLatch latch);
}
