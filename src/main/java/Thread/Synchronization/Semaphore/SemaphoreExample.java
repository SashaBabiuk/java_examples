package Thread.Synchronization.Semaphore;
import java.util.concurrent.Semaphore;
public class SemaphoreExample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        //permits 3 це означає, що кількість дозволів 3 коли потік заходить в блок він бере вільний permit,якщо він є
        Runnable task = () -> {
            try {
                semaphore.acquire();
                System.out.println("Finished");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
