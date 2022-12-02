package brainstorm.springboot.amigoscodefunctionalprogramming.optionals;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Object value1 = Optional.ofNullable(null).orElseGet(()
                -> "default value");
        System.out.println(value1);

        Object value2 = Optional.ofNullable("Hello").orElseGet(()
                -> "default value");
        System.out.println(value2);

        Supplier<IllegalStateException> exception = ()  -> new IllegalStateException("Exception");

        Object value3 = Optional.ofNullable(null).orElseThrow(exception);
        System.out.println(value3);

    }
}
