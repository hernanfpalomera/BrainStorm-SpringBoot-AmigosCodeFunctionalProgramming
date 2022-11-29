package brainstorm.springboot.amigoscodefunctionalprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

//        List<Person> people = List.of(
//            new Person("John", Gender.MALE),
//            new Person("Maria", Gender.FEMALE),
//            new Person("Aisha", Gender.FEMALE),
//            new Person("Alex", Gender.MALE),
//            new Person("Alice", Gender.FEMALE)
//        );

        List<Person> people = new ArrayList<>();
        people.add(new Person("John", Gender.MALE));
        people.add(new Person("Maria", Gender.FEMALE));
        people.add(new Person("Aisha", Gender.FEMALE));
        people.add(new Person("Alex", Gender.MALE));
        people.add(new Person("John", Gender.MALE));
        people.add(new Person("Alice", Gender.FEMALE));


        System.out.println("// Imperative approach");
        // Imperative approach
        List<Person> females = new ArrayList<>();

        for (Person person: people){
            if (Gender.FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for (Person female: females){
            System.out.println(female);
        }

        System.out.println("// Declarative approach 1");
        // Declarative approach

        people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("// Declarative approach 2");

        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);

        List<Person> females2 = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());

        females2.forEach(System.out::println);

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
        MALE, FEMALE
    }

}
