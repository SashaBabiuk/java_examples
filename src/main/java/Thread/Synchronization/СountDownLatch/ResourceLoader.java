package Thread.Synchronization.СountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ResourceLoader extends ResourceTask{
    private final long secoundDuration;

    public ResourceLoader(long id, CountDownLatch countDownLatch, long secoundDuration) {
        super(id, countDownLatch);
        this.secoundDuration = secoundDuration;
    }

    @Override
    protected void run(CountDownLatch countDownLatch) {
        try {
            System.out.printf("%s is loading some resource\n",this);
            TimeUnit.SECONDS.sleep(secoundDuration);
            System.out.printf("Some resource was loaded by %s\n",this);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
