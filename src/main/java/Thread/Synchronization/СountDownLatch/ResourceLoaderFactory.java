package Thread.Synchronization.СountDownLatch;

import java.util.concurrent.CountDownLatch;

public class ResourceLoaderFactory extends ResourceTaskFactory{
    private long nextSecoundDuration = 1;

    @Override
    protected ResourceLoader create(long id, CountDownLatch latch) {
        return new ResourceLoader(id,latch,nextSecoundDuration++);
    }
}
