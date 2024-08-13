package Thread.Synchronization.СountDownLatch;

import java.util.concurrent.CountDownLatch;

public class ResourceHandler extends ResourceTask{

    public ResourceHandler(long id, CountDownLatch countDownLatch) {
        super(id, countDownLatch);
    }
    @Override
    protected void run(CountDownLatch countDownLatch) {
        try {
            countDownLatch.await();
            System.out.printf("Resorces was handled by %s \n",this);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
