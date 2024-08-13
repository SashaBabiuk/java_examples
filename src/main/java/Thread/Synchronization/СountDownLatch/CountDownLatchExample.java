package Thread.Synchronization.СountDownLatch;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;


public class CountDownLatchExample {
    public static void main(String[] args) {
        int resourceCount = 3;
        CountDownLatch countDownLatch = new CountDownLatch(resourceCount);
        ResourceLoaderFactory loaderFactory = new ResourceLoaderFactory();
        Thread[] loadingThreads = createResourceThreads(loaderFactory,resourceCount,countDownLatch);

        ResourceHandlerFactory resourceHandlerFactory = new ResourceHandlerFactory();
        int handlingThreadsCount = 4;
        Thread[] handlingThreads = createResourceThreads(resourceHandlerFactory,handlingThreadsCount,countDownLatch);

        Arrays.stream(loadingThreads).forEach(Thread::start);
        Arrays.stream(handlingThreads).forEach(Thread::start);

    }

    private static Thread[] createResourceThreads(ResourceTaskFactory factory,int thredsCound,CountDownLatch countDownLatch){
        return IntStream.range(0,thredsCound)
                .mapToObj(i -> factory.create(countDownLatch))
                .map(Thread::new)
                .toArray(Thread[]::new);
    }
}
