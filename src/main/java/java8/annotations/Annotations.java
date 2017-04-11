package java8.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Karl
 * @date 2017/4/11 23:37
 */
public class Annotations {

    /*
    * ElementType.TYPE_USE和ElementType.TYPE_PARAMETER是两个新添加的用于描述适当的注解上下文的元素类型。
    */
    @Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NotEmpty {}

    public static class Holder<@NotEmpty T> extends @NotEmpty Object {
        public void method() throws @NotEmpty Exception {}
    }

    /*
    * Java 8扩展了注解的上下文。现在几乎可以为任何东西添加注解：局部变量、泛型类、父类与接口的实现，就连方法的异常也能添加注解。
    */
    public static void main(String[] args) {
        final Holder<String> holder = new @NotEmpty Holder<>();
        @NotEmpty Collection<@NotEmpty String> strings = new ArrayList<>();
    }
}
