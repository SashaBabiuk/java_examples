package Thread.Synchronization.СountDownLatch;

import java.util.concurrent.CountDownLatch;

public class ResourceHandlerFactory extends ResourceTaskFactory{
    @Override
    protected ResourceHandler create(long id, CountDownLatch latch) {
        return new ResourceHandler(id,latch);
    }
}
