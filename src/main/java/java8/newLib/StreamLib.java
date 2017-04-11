package java8.newLib;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Karl
 * @date 2017/4/12 0:04
 */
public class StreamLib {

    private enum Status {
        OPEN, CLOSED
    }

    private static final class Task {
        private final Status status;
        private final Integer points;

        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }


        public Status getStatus() {
            return status;
        }

        public Integer getPoints() {
            return points;
        }

        @Override
        public String toString() {
            return String.format("[%S, %d]", status, points);
        }
    }

    public static void main(String[] args) {
        final Collection< Task > tasks = Arrays.asList(
                new Task( Status.OPEN, 5 ),
                new Task( Status.OPEN, 13 ),
                new Task( Status.CLOSED, 8 )
        );

        /*
        * 这里有几个注意事项。
        * 第一，task集合被转换化为其相应的stream表示。然后，filter操作过滤掉状态为CLOSED的task。
        * 下一步，mapToInt操作通过Task::getPoints这种方式调用每个task实例的getPoints方法把Task的stream转化为Integer的stream。
        * 最后，用sum函数把所有的分数加起来，得到最终的结果
        */
        // Calculate total points of all active tasks using sum()
        final long totalPointsOfOpenTasks = tasks.stream()
                .filter(task -> task.getStatus() == Status.OPEN)
                .mapToInt(Task::getPoints)
                .sum();

        System.out.println( "Total points: " + totalPointsOfOpenTasks );

        /*
        * 这个例子和第一个例子很相似，但这个例子的不同之处在于这个程序是并行运行的，其次使用reduce方法来算最终的结果。
        */
        // Calculate total points of all tasks
        final double totalPoints = tasks.stream()
                .parallel()
                .map(task -> task.getPoints())
                .reduce(0, Integer::sum);

        System.out.println( "Total points (all tasks): " + totalPoints );

        /*
        * 经常会有这个一个需求：我们需要按照某种准则来对集合中的元素进行分组。Stream也可以处理这样的需求，下面是一个例子：
        */
        // Group tasks by their status
        final Map<Status, List<Task>> map = tasks.stream()
                .collect(Collectors.groupingBy(Task::getStatus));

        System.out.println(map);

        /*
        * 让我们来计算整个集合中每个task分数（或权重）的平均值来结束task的例子。
        */
        // Calculate the weight of each tasks (as percent of total points)
        final Collection< String > result = tasks
                .stream()                                        // Stream< String >
                .mapToInt( Task::getPoints )                     // IntStream
                .asLongStream()                                  // LongStream
                .mapToDouble( points -> points / totalPoints )   // DoubleStream
                .boxed()                                         // Stream< Double >
                .mapToLong( weigth -> ( long )( weigth * 100 ) ) // LongStream
                .mapToObj( percentage -> percentage + "%" )      // Stream< String>
                .collect( Collectors.toList() );                 // List< String >

        System.out.println( result );

        /*
        * 最后，就像前面提到的，Stream API不仅仅处理Java集合框架。像从文本文件中逐行读取数据这样典型的I/O操作也很适合用Stream API来处理。
        */
        String filename = "d:/data/demo.txt";
        final Path path = new File( filename ).toPath();
        try(
            Stream< String > lines = Files.lines( path, StandardCharsets.UTF_8 ) ) {
            lines.onClose( () -> System.out.println("Done!") ).forEach( System.out::println );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
