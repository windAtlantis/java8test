package java8.defaultInter;

import java.util.function.Supplier;

/**
 * @author Karl
 * @date 2017/4/9 22:15
 */
public interface DefaulableFactory {
    static Defaulable create(Supplier<Defaulable> supplier) {
        return supplier.get();
    }
}
