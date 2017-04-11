package java8.inference;

/**
 * @author Karl
 * @date 2017/4/11 23:25
 */
public class Value<T> {

    public static<T> T defaultValue() {
        return null;
    }

    public T getOrDefault(T value, T defaultValue) {
        return (value != null)?value : defaultValue;
    }

    /*
    * Java 8在类型推测方面有了很大的提高。在很多情况下，编译器可以推测出确定的参数类型，这样就能使代码更整洁
    */
    public static void main(String[] args) {
        final Value<String> value = new Value<>();
        // Value.defaultValue()的参数类型可以被推测出，所以就不必明确给出。
        // 在Java 7中，相同的例子将不会通过编译，正确的书写方式是 Value.< String >defaultValue()。
        value.getOrDefault("22", Value.defaultValue());
    }
}
