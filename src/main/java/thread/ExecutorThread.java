package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Karl
 * @date 2017/4/17 23:55
 */
public class ExecutorThread {

    public static void main(String[] args) {
        new ExecutorThread().scheduledThread();
    }

    private void demo(ExecutorService executorService) {
        for (int i = 0;i < 10;i++) {
            final int index = i;
            executorService.execute(() -> {
                try {
                    System.out.println("ThreadName:"+Thread.currentThread().getName()+","+index);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    /**
     * 创建一个单线程化(容量为1)的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
     */
    public void singleThread() {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        demo(singleThreadExecutor);
    }

    /**
     * 创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
     * 线程池的大小一旦达到最大值就会保持不变，在提交新任务，任务将会进入等待队列中等待。
     * 如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
     */
    public void fixedThread() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        demo(fixedThreadPool);
    }

    /**
     * 创建一个可缓存的线程池。
     * 如果线程池的大小超过了处理任务所需要的线程，那么就会回收部分空闲（60秒处于等待任务到来）的线程，
     * 当任务数增加时，此线程池又可以智能的添加新线程来处理任务。此线程池的最大值是Integer的最大值(2^31-1)。
     */
    public void cachedThread() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        demo(cachedThreadPool);
    }

    /**
     *  创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
     */
    public void scheduledThread() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
//        scheduledThreadPool.schedule(() -> {
//            System.out.println("delay 3 seconds");
//        }, 3, TimeUnit.SECONDS); //延迟3秒后执行run方法。

        scheduledThreadPool.scheduleAtFixedRate(() -> System.out.println("delay 1 seconds, and excute every 3 seconds"), 1, 3, TimeUnit.SECONDS); //延迟1秒后每3秒执行一次。
    }
}
