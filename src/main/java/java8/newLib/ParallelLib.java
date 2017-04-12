package java8.newLib;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Karl
 * @date 2017/4/12 23:26
 */
public class ParallelLib {

    /*
    * Java 8增加了大量的新方法来对数组进行并行处理。
    * 可以说，最重要的是parallelSort()方法，因为它可以在多核机器上极大提高数组排序的速度。
    * 上面的代码片段使用了parallelSetAll()方法来对一个有20000个元素的数组进行随机赋值。
    * 然后，调用parallelSort方法。这个程序首先打印出前10个元素的值，之后对整个数组排序。
    */
    public static void main(String[] args) {
        long[] array = new long[20000];
        Arrays.parallelSetAll(array, value -> ThreadLocalRandom.current().nextInt(1000000));
        Arrays.stream(array).limit(10).forEach(value -> System.out.println(value+""));
        System.out.println("================");

        Arrays.parallelSort(array);
        Arrays.stream(array).limit(10).forEach(value -> System.out.println(value+""));
        System.out.println("================");
    }
}
