package java8.annotations;

import java.lang.annotation.*;

/**
 * @author Karl
 * @date 2017/4/11 23:08
 */
public class RepeatingAnnotations {

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters {
        Filter[] value();
    }

    /*
    * 正如我们看到的，这里有个使用@Repeatable( Filters.class )注解的注解类Filter，
    * Filters仅仅是Filter注解的数组，但Java编译器并不想让程序员意识到Filters的存在。
    * 这样，接口Filterable就拥有了两次Filter（并没有提到Filter）注解。
    */
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    public @interface Filter {
        String value();
    }

    @Filter("filter1")
    @Filter("filter2")
    public interface Filterable {

    }

    /*
    * 自从Java 5引入了注解机制，这一特性就变得非常流行并且广为使用。
    * 然而，使用注解的一个限制是相同的注解在同一位置只能声明一次，不能声明多次。
    * Java 8打破了这条规则，引入了重复注解机制，这样相同的注解可以在同一地方声明多次。
    */
    public static void main(String[] args) {
        // 反射相关的API提供了新的函数getAnnotationsByType()来返回重复注解的类型
        for (Filter filter : Filterable.class.getAnnotationsByType(Filter.class)) {
            System.out.println(filter.value());
        }
    }
}
