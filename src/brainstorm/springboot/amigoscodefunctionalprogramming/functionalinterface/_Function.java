package brainstorm.springboot.amigoscodefunctionalprogramming.functionalinterface;

import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {

        int increment = incrementByOne(1);
        System.out.println(increment);

        Integer increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        Integer multiply = multiplyByTenFunction.apply(increment2);
        System.out.println(multiply);

        Function<Integer,Integer> addBy1nadTheMultiplyBy10 =
                incrementByOneFunction.
                        andThen(multiplyByTenFunction);
        System.out.println(addBy1nadTheMultiplyBy10.apply(4));
    }

    static Function<Integer,Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer,Integer> multiplyByTenFunction =
            number -> number * 10;



    static int incrementByOne(int number){
        return number+1;
    }
}
