package java8.defaultInter;

/**
 * @author Karl
 * @date 2017/4/9 22:06
 */
public class OverridableImpl implements Defaulable {
    @Override
    public String noRequired() {
        return "Override";
    }
}
