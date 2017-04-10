package java8.defaultInter;

/**
 * @author Karl
 * @date 2017/4/9 22:19
 */
public class test {
    public static void main(String[] args) {
        /* Defaulable接口用关键字default声明了一个默认方法notRequired()，
           Defaulable接口的实现者之一DefaultableImpl实现了这个接口，并且让默认方法保持原样。
           Defaulable接口的另一个实现者OverridableImpl用自己的方法覆盖了默认方法。
        */
        // Java 8带来的另一个有趣的特性是接口可以声明（并且可以提供实现）静态方法。
        Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
        System.out.println(defaulable.noRequired());
        System.out.println("====================");
        defaulable = DefaulableFactory.create(OverridableImpl::new);
        System.out.println(defaulable.noRequired());
    }
}
