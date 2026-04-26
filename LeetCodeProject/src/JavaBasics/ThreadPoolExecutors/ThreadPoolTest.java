package JavaBasics.ThreadPoolExecutors;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolTest {
    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(() -> "Hello World");
        try {
            String s1 = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executorService.submit(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newSingleThreadExecutor();
        threadPoolExecutor.submit(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 设置线程池的参数
        threadPoolExecutor.setCorePoolSize(2);
        threadPoolExecutor.setMaximumPoolSize(10);
        threadPoolExecutor.setKeepAliveTime(1000, TimeUnit.MILLISECONDS);

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(() -> {
            System.out.println("Hello World");
        }, 500, TimeUnit.MILLISECONDS);

        CountDownLatch lock = new CountDownLatch(3);
        ScheduledExecutorService scheduledExecutorService2 = Executors.newScheduledThreadPool(5);
        ScheduledFuture<?> future1 = scheduledExecutorService2.scheduleAtFixedRate(() -> {
            System.out.println("Hello World");
            lock.countDown();
        }, 500, 100, TimeUnit.MILLISECONDS);
        try {
            boolean flag = lock.await(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        future.cancel(true);

    }
}
