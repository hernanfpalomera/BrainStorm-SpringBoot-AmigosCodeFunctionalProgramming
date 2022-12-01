package brainstorm.springboot.amigoscodefunctionalprogramming.functionalinterface;

import com.sun.tools.javac.util.List;

import java.util.function.Supplier;

public class _Supplier {

    public static void main(String[] args) {

        System.out.println(getDBConnectionUrl());
        System.out.println(getDBConnectionUrlSupplier.get());
        System.out.println(getDBConnectionUrlListSupplier.get());
    }

    static String getDBConnectionUrl(){
        return "jdbc://localhost:5232/users";
    }

    static Supplier<String> getDBConnectionUrlSupplier = ()
            -> "jdbc://localhost:5232/users";

    static Supplier<List<String>> getDBConnectionUrlListSupplier = ()
            -> List.of("jdbc://localhost:5232/users",
            "jdbc://localhost:5232/customer");

}
