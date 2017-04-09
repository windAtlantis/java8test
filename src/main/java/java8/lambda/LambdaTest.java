package java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Karl
 * @date 2017/4/9 17:28
 */
public class LambdaTest {
    public static void main(String[] args) {
        Arrays.asList("a","d").forEach((String e) -> {e += "1"; System.out.println(e);});
        List<String> list = Arrays.asList("a","b","d","c");
        list.sort((e1, e2)->e1.compareTo(e2));
        System.out.println(list);
    }
    public void name(){}
}
