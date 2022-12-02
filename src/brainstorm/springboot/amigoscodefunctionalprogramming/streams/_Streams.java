package brainstorm.springboot.amigoscodefunctionalprogramming.streams;

import brainstorm.springboot.amigoscodefunctionalprogramming.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _Streams{

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", Gender.MALE));
        people.add(new Person("Maria", Gender.FEMALE));
        people.add(new Person("Aisha", Gender.FEMALE));
        people.add(new Person("Alex", Gender.MALE));
        people.add(new Person("John", Gender.MALE));
        people.add(new Person("Alice", Gender.FEMALE));


        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);


        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer println = System.out::println;

        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

        boolean containsOnlyFemales = people.stream()
                .allMatch(person -> Gender.FEMALE.equals(person.gender));

        System.out.println(containsOnlyFemales);

        boolean containsAtLeastOneFemale = people.stream()
                .anyMatch(person -> Gender.FEMALE.equals(person.gender));

        System.out.println(containsAtLeastOneFemale);

        boolean containsNotPreferGender = people.stream()
                .noneMatch(person -> Gender.PREFER_NOT_TO_SAY.equals(person.gender));

        System.out.println(containsNotPreferGender);
    }

    static class Person{
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }

    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
