package java8.defaultInter;

/**
 * @author Karl
 * @date 2017/4/9 22:19
 */
public class test {
    public static void main(String[] args) {
        Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
        System.out.println(defaulable.noRequired());
        System.out.println("====================");
        defaulable = DefaulableFactory.create(OverridableImpl::new);
        System.out.println(defaulable.noRequired());
    }
}
