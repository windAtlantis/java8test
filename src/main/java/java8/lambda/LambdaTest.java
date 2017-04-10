package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Karl
 * @date 2017/4/9 17:28
 */
public class LambdaTest {
    /*
        Lambda允许把函数作为一个方法的参数（函数作为参数传递进方法中），或者把代码看成数据：函数式程序员对这一概念非常熟悉。
        在JVM平台上的很多语言（Groovy，Scala，……）从一开始就有Lambda，但是Java程序员不得不使用毫无新意的匿名类来代替lambda。
    */
    public static void main(String[] args) {
        //在最简单的形式中，一个lambda可以由用逗号分隔的参数列表、–>符号与函数体三部分表示。
        Arrays.asList("a","d").forEach(e -> System.out.println(e));

        //请注意参数e的类型是由编译器推测出来的。同时，你也可以通过把参数类型与参数包括在括号中的形式直接给出参数的类型：
        Arrays.asList( "a", "b", "d" ).forEach( ( String e ) -> System.out.println( e ) );

        //在某些情况下lambda的函数体会更加复杂，这时可以把函数体放到在一对花括号中，就像在Java中定义普通函数一样。
        Arrays.asList( "a", "b", "d" ).forEach( e -> {
            System.out.print( e );
            System.out.print( e );
        } );

        //Lambda可以引用类的成员变量与局部变量（如果这些变量不是final的话，它们会被隐含的转为final，这样效率更高）
        String separator = ",";
        Arrays.asList( "a", "b", "d" ).forEach(
                ( String e ) -> System.out.print( e + separator ) );

        //Lambda可能会返回一个值。返回值的类型也是由编译器推测出来的。如果lambda的函数体只有一行的话，那么没有必要显式使用return语句
        new LambdaTest().name();

        //这段代码就是对一个字符串的列表，把其中包含的每个字符串都转换成全小写的字符串（熟悉Groovy和Scala的同学肯定会感觉很亲切）。
        //注意代码第四行的map方法调用，这里map方法就是接受了一个lambda表达式
        List<String> names = Arrays.asList("TaoBao","ZhiFuBao");
        List<String> lowercaseNames = names.stream().map((String name) -> {return name.toLowerCase();}).collect(Collectors.toList());
    }

    public void name() {
        Arrays.asList("a","b","d","c").sort((e1, e2)->e1.compareTo(e2));
    }
}
