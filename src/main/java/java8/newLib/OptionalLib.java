package java8.newLib;

import java.util.Optional;

/**
 * @author Karl
 * @date 2017/4/11 23:56
 */
public class OptionalLib {

    /*
    * Optional实际上是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
    */
    public static void main(String[] args) {
        /*
        * 如果Optional类的实例为非空值的话，isPresent()返回true，否从返回false。
        * 为了防止Optional为空值，orElseGet()方法通过回调函数来产生一个默认值。
        * map()函数对当前Optional的值进行转化，然后返回一个新的Optional实例。
        * orElse()方法和orElseGet()方法类似，但是orElse接受一个默认值而不是一个回调函数。
        */
        Optional<String> fullname = Optional.ofNullable(null);
        System.out.println("Full name is set? "+fullname.isPresent());
        System.out.println("Full name: "+fullname.orElseGet(() -> "[none]"));
        System.out.println(fullname.map(s -> "Hey "+s+" !").orElse("Hey Stranger!"));

        System.out.println("=============================");

        Optional< String > firstName = Optional.of( "Tom" );
        System.out.println( "First Name is set? " + firstName.isPresent() );
        System.out.println( "First Name: " + firstName.orElseGet( () -> "[none]" ) );
        System.out.println( firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
    }
}
