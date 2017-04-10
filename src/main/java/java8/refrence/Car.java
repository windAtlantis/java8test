package java8.refrence;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Karl
 * @date 2017/4/10 22:48
 */
public class Car {
    /**
     * 第一种方法引用是构造器引用，它的语法是Class::new，或者更一般的Class< T >::new。请注意构造器没有参数。
     * @param supplier
     * @return
     */
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    /**
     * 第二种方法引用是静态方法引用，它的语法是Class::static_method。请注意这个方法接受一个Car类型的参数。
     * @param car
     */
    public static void collide(final Car car) {
        System.out.println("Collide "+car.toString());
    }

    /**
     * 第三种方法引用是特定类的任意对象的方法引用，它的语法是Class::method。请注意，这个方法没有参数。
     * @param car
     */
    public void follow(final Car car) {
        System.out.println("Following the "+car.toString());
    }

    /**
     * 最后，第四种方法引用是特定对象的方法引用，它的语法是instance::method。请注意，这个方法接受一个Car类型的参数
     */
    public void repair() {
        System.out.println("Repaired "+this.toString());
    }

    public static void main(String[] args) {
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);
        cars.forEach(Car::collide);
        cars.forEach(Car::repair);
        cars.forEach(car::follow);
        //输出结果应该一致
    }
}
