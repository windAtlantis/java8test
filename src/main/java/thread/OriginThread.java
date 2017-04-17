package thread;

/**
 * @author Karl
 * @date 2017/4/17 23:50
 */
public class OriginThread {
    /* 使用“原汁原味”的裸线程 */
    /*
     * 使用裸线程的主要优点是，你很接近并发计算的操作系统/硬件模型，并且这个模型非常简单。
     * 多个线程运行，通过共享内存通讯，就是这样。
     *
     * 自己管理线程的最大劣势是，你很容易过分的关注线程的数量。
     * 线程是很昂贵的对象，创建它们需要耗费大量的内存和时间。
     * 这是一个矛盾，线程太少，你不能获得良好的并发性；线程太多，将很可能导致内存问题，调度也变得更复杂。
     */
    public static void main(String[] args) {
        new Thread(() -> System.out.println("1111")).start();
    }
}
