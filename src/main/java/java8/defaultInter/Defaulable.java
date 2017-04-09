package java8.defaultInter;

/**
 * @author Karl
 * @date 2017/4/9 21:41
 */
public interface Defaulable {
    default String noRequired() {
        return "Default";
    }
}
